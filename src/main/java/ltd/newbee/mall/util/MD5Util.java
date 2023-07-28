package ltd.newbee.mall.util;

import java.security.MessageDigest;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description MD5Util工具类，提供对字符串进行MD5加密的静态方法。
 * @date 2023/07/27 16:57
 */
public class MD5Util {

    /**
     * 将字节数组转换为十六进制字符串。
     *
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    /**
     * 将字节转换为十六进制字符串。
     *
     * @param b 字节
     * @return 十六进制字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 对指定字符串进行MD5加密。
     *
     * @param origin      原始字符串
     * @param charsetname 字符编码名称，可为null
     * @return MD5加密后的字符串
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    /**
     * 十六进制字符数组，用于在MD5加密过程中将字节转换为十六进制字符串。
     */
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}
