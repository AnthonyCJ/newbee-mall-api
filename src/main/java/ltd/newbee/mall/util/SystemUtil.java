package ltd.newbee.mall.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * SystemUtil类，用于提供系统级别的工具方法。
 *
 * 该类包含了生成保持用户登录状态会话token值的方法genToken。
 * 在该方法中，会对传入的src参数进行MD5加密，并返回加密后的结果作为token值。
 *
 * 注意：该方法假设传入的src参数不为null或空字符串，并且确保传入的src参数具有唯一性。
 * 生成token的方式涉及用户登录状态保持，请根据具体业务场景进行适当的处理和安全校验。
 *
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 20:09
 */
public class SystemUtil {

    private SystemUtil() {
    }


    /**
     * 登录或注册成功后，生成保持用户登录状态会话token值。
     *
     * @param src 用户最新一次登录时的now()+user.id+random(4)组合字符串
     * @return 生成的保持用户登录状态会话token值
     *         如果src为null或空字符串，返回null
     *         如果生成token时发生异常，返回null
     */
    public static String genToken(String src) {
        if (null == src || "".equals(src)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);
            if (result.length() == 31) {
                result = result + "-";
            }
            System.out.println(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
