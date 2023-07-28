package ltd.newbee.mall.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description BeanUtil工具类，提供一些处理JavaBean的静态方法。
 * @date 2023/07/27 16:48
 */
public abstract class BeanUtil {

    /**
     * 将源对象的属性复制到目标对象中，忽略指定的属性。
     *
     * @param source          源对象
     * @param target          目标对象
     * @param ignoreProperties 要忽略复制的属性名称数组
     * @return 目标对象，带有源对象的属性值
     */
    public static Object copyProperties(Object source, Object target, String... ignoreProperties) {
        if (source == null) {
            return target;
        }
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }

    /**
     * 将源对象列表复制为目标对象列表，目标对象类为指定类型，并可对复制后的目标对象进行自定义回调处理。
     *
     * @param sources  源对象列表
     * @param clazz    目标对象类型
     * @return 目标对象列表，带有源对象列表的属性值
     */
    public static <T> List<T> copyList(List sources, Class<T> clazz) {
        return copyList(sources, clazz, null);
    }

    /**
     * 将源对象列表复制为目标对象列表，目标对象类为指定类型，并可对复制后的目标对象进行自定义回调处理。
     *
     * @param sources  源对象列表
     * @param clazz    目标对象类型
     * @param callback 自定义回调接口，用于在复制后对目标对象进行处理
     * @return 目标对象列表，带有源对象列表的属性值
     */
    public static <T> List<T> copyList(List sources, Class<T> clazz, Callback<T> callback) {
        List<T> targetList = new ArrayList<>();
        if (sources != null) {
            try {
                for (Object source : sources) {
                    T target = clazz.newInstance();
                    copyProperties(source, target);
                    if (callback != null) {
                        callback.set(source, target);
                    }
                    targetList.add(target);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return targetList;
    }

    /**
     * 将JavaBean对象转换为属性名与属性值组成的Map，并可忽略指定属性。
     *
     * @param bean             JavaBean对象
     * @param ignoreProperties 要忽略转换的属性名称数组
     * @return 属性名与属性值组成的Map
     */
    public static Map<String, Object> toMap(Object bean, String... ignoreProperties) {
        Map<String, Object> map = new LinkedHashMap<>();
        List<String> ignoreList = new ArrayList<>(Arrays.asList(ignoreProperties));
        ignoreList.add("class");
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(bean);
        for (PropertyDescriptor pd : beanWrapper.getPropertyDescriptors()) {
            if (!ignoreList.contains(pd.getName()) && beanWrapper.isReadableProperty(pd.getName())) {
                Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
                map.put(pd.getName(), propertyValue);
            }
        }
        return map;
    }

    /**
     * 将属性名与属性值组成的Map转换为指定类型的JavaBean对象。
     *
     * @param map      属性名与属性值组成的Map
     * @param beanType JavaBean类型
     * @return 转换后的JavaBean对象
     */
    public static <T> T toBean(Map<String, Object> map, Class<T> beanType) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(beanType);
        map.forEach((key, value) -> {
            if (beanWrapper.isWritableProperty(key)) {
                beanWrapper.setPropertyValue(key, value);
            }
        });
        return (T) beanWrapper.getWrappedInstance();
    }

    /**
     * 自定义回调接口，用于在复制对象时对目标对象进行个性化处理。
     *
     * @param <T> 目标对象类型
     */
    public static interface Callback<T> {
        void set(Object source, T target);
    }

    /**
     * 检查指定的JavaBean对象是否含有null字段。
     *
     * @param o   要检查的JavaBean对象
     * @param clz JavaBean对象的类类型
     * @return 如果JavaBean对象中所有字段均非null，则返回true；否则返回false
     */
    public static boolean checkPojoNullField(Object o, Class<?> clz) {
        try {
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(o) == null) {
                    return false;
                }
            }
            if (clz.getSuperclass() != Object.class) {
                return checkPojoNullField(o, clz.getSuperclass());
            }
            return true;
        } catch (IllegalAccessException e) {
            return false;
        }
    }
}
