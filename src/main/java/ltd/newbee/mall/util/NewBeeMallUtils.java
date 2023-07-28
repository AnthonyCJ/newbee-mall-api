package ltd.newbee.mall.util;

import org.springframework.util.StringUtils;

import java.net.URI;

/**
 * NewBeeMallUtils工具类，提供一些通用的工具方法。
 *
 * 该类包含获取URI中的主机部分和对字符串进行清理的静态方法。
 *
 * 注意：cleanString方法用于对输入字符串进行安全处理，防止XSS和SQL注入等安全问题。
 * 建议在输出到HTML页面或拼接SQL语句之前使用该方法对字符串进行处理。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 17:00
 */
public class NewBeeMallUtils {

    /**
     * 获取URI中的主机部分，并返回新的URI对象。
     *
     * @param uri 原始URI对象
     * @return 包含主机部分的新URI对象
     */
    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }

    /**
     * 清理输入字符串，防止XSS和SQL注入等安全问题，并返回清理后的字符串。
     *
     * @param value 输入字符串
     * @return 清理后的字符串
     */
    public static String cleanString(String value) {
        if (!StringUtils.hasText(value)) {
            return "";
        }
        value = value.toLowerCase();
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("onload", "0nl0ad");
        value = value.replaceAll("xml", "xm1");
        value = value.replaceAll("window", "wind0w");
        value = value.replaceAll("click", "cl1ck");
        value = value.replaceAll("var", "v0r");
        value = value.replaceAll("let", "1et");
        value = value.replaceAll("function", "functi0n");
        value = value.replaceAll("return", "retu1n");
        value = value.replaceAll("$", "");
        value = value.replaceAll("document", "d0cument");
        value = value.replaceAll("const", "c0nst");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "scr1pt");
        value = value.replaceAll("insert", "1nsert");
        value = value.replaceAll("drop", "dr0p");
        value = value.replaceAll("create", "cre0ate");
        value = value.replaceAll("update", "upd0ate");
        value = value.replaceAll("alter", "a1ter");
        value = value.replaceAll("from", "fr0m");
        value = value.replaceAll("where", "wh1re");
        value = value.replaceAll("database", "data1base");
        value = value.replaceAll("table", "tab1e");
        value = value.replaceAll("tb", "tb0");
        return value;
    }
}
