package ltd.newbee.mall.config.annotation;

import java.lang.annotation.*;

/**
 * TokenToAdminUser注解，用于标识将Token转换为管理员用户的注解。
 *
 * 该注解用于在Controller的方法参数上，用于将Token转换为管理员用户对象。
 *
 * @Target({ElementType.PARAMETER}) 表示该注解可以用于方法参数上。
 * @Retention(RetentionPolicy.RUNTIME) 表示该注解在运行时有效。
 * @Documented 表示该注解会被包含在Javadoc中。
 *
 * value属性用于指定当前用户在request中的名字，默认值为"adminUser"。
 * 在Controller方法中使用该注解时，可以通过该value属性指定Token所对应的管理员用户对象。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/28 20:44
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToAdminUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default "adminUser";

}
