package ltd.newbee.mall.common;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 自定义异常
 * @date 2023/07/27 16:16
 */
public class NewBeeMallException extends RuntimeException {

    public NewBeeMallException() {
    }

    public NewBeeMallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     *
     * @param message 异常信息
     */
    public static void fail(String message) {
        throw new NewBeeMallException(message);
    }

}
