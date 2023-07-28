package ltd.newbee.mall.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * PageQueryUtil类，用于处理分页查询参数的工具类。
 *
 * 该类继承自LinkedHashMap，并提供了处理分页查询参数的方法。
 * 在构造函数中，会解析传入的params参数，提取出当前页码和每页条数，并计算查询的起始位置。
 *
 * 注：该工具类假设传入的params参数中包含"page"和"limit"两个字段，且值为合法的整数。
 * 如果params参数不包含这两个字段或值不合法，可能会抛出NumberFormatException异常。
 *
 * 使用该工具类时，要确保params参数的正确性，并根据具体业务场景进行适当的异常处理。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 18:07
 */
public class PageQueryUtil extends LinkedHashMap<String, Object> {
    //当前页码
    private int page;
    //每页条数
    private int limit;

    /**
     * 构造PageQueryUtil对象，并处理分页查询参数。
     *
     * @param params 分页查询参数，应包含"page"和"limit"字段
     * @throws NumberFormatException 如果"page"和"limit"字段的值无法转换为整数，会抛出此异常
     */
    public PageQueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }

    /**
     * 获取当前页码。
     *
     * @return 当前页码
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置当前页码。
     *
     * @param page 要设置的当前页码
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 获取每页条数。
     *
     * @return 每页条数
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 设置每页条数。
     *
     * @param limit 要设置的每页条数
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
