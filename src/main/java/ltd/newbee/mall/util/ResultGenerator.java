package ltd.newbee.mall.util;

import org.springframework.util.StringUtils;

/**
 * ResultGenerator工具类，用于生成接口返回结果的通用方法。
 *
 * 该工具类提供了生成成功结果、失败结果和错误结果的静态方法，
 * 并可根据需要设置不同的返回码、返回信息和返回数据。
 *
 * 注：在生成失败结果时，如果不提供自定义的失败信息，将会使用默认的失败信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @description TODO
 * @date 2023/07/27 19:59
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    /**
     * 生成默认的成功结果。
     *
     * @return 默认的成功结果
     */
    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 生成带自定义成功信息的成功结果。
     *
     * @param message 自定义的成功信息
     * @return 带自定义成功信息的成功结果
     */
    public static Result genSuccessResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

    /**
     * 生成带数据的成功结果。
     *
     * @param data 返回数据
     * @return 带数据的成功结果
     */
    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    /**
     * 生成带自定义失败信息的失败结果。
     *
     * @param message 自定义的失败信息
     * @return 带自定义失败信息的失败结果
     */
    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        if (!StringUtils.hasText(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    /**
     * 生成带自定义返回码和信息的错误结果。
     *
     * @param code    自定义的返回码
     * @param message 自定义的错误信息
     * @return 带自定义返回码和信息的错误结果
     */
    public static Result genErrorResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
