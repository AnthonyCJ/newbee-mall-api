package ltd.newbee.mall.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * NumberUtil工具类，提供一些处理数字的静态方法。
 *
 * 该类包含判断是否为11位电话号码、生成指定长度的随机数和生成订单流水号的方法。
 * 注：生成随机数方法的随机性有限，不适用于安全性要求较高的场景。
 *
 * 附：在genRandomNum方法中生成随机数的方式并非高质量随机数生成方法，
 * 仅用于简单的随机数需求，如生成验证码等场景。对于需要高安全性的随机数需求，推荐使用更为专业的方法。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 17:20
 */
public class NumberUtil {

    private NumberUtil() {
    }


    /**
     * 判断给定字符串是否为11位电话号码格式。
     *
     * @param phone 要判断的字符串
     * @return 如果字符串是11位电话号码格式，则返回true；否则返回false
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 生成指定长度的随机整数。
     *
     * @param length 随机数的长度
     * @return 指定长度的随机整数
     */
    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 生成订单流水号，基于当前时间戳和指定长度的随机数。
     *
     * @return 订单流水号，格式为时间戳+随机数
     */
    public static String genOrderNo() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(4);
        buffer.append(num);
        return buffer.toString();
    }
}