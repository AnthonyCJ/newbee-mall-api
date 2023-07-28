package ltd.newbee.mall.util;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Result类，用于封装接口返回的通用结果模型。
 *
 * 该类是一个泛型类，可以适用于不同类型的返回数据。
 *
 * Result类包含了业务码、返回信息和数据结果三个字段，用于统一接口返回的格式。
 *
 * 注：该类使用了io.swagger.annotations.ApiModelProperty注解，
 * 可用于生成API文档时对字段的说明，推荐根据具体业务情况提供详细的字段说明。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @param <T> 返回数据的类型
 * @date 2023/07/27 19:34
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 业务码，比如成功、失败、权限不足等 code，可自行定义
    @ApiModelProperty("返回码")
    private int resultCode;
    // 返回信息，后端在进行业务处理后返回给前端一个提示信息，可自行定义
    @ApiModelProperty("返回信息")
    private String message;
    // 数据结果，泛型，可以是列表、单个对象、数字、布尔值等
    @ApiModelProperty("返回数据")
    private T data;

    /**
     * 无参构造方法。
     */
    public Result() {
    }

    /**
     * 含参构造方法，用于设置业务码和返回信息。
     *
     * @param resultCode 业务码，表示接口调用的结果状态
     * @param message    返回信息，后端在进行业务处理后返回给前端的提示信息
     */
    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    /**
     * 获取业务码。
     *
     * @return 业务码，表示接口调用的结果状态
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * 设置业务码。
     *
     * @param resultCode 要设置的业务码，表示接口调用的结果状态
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 获取返回信息。
     *
     * @return 返回信息，后端在进行业务处理后返回给前端的提示信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置返回信息。
     *
     * @param message 要设置的返回信息，后端在进行业务处理后返回给前端的提示信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取数据结果。
     *
     * @return 数据结果，可以是列表、单个对象、数字、布尔值等
     */
    public T getData() {
        return data;
    }

    /**
     * 设置数据结果。
     *
     * @param data 要设置的数据结果，可以是列表、单个对象、数字、布尔值等
     */
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}