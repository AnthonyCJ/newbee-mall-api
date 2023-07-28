package ltd.newbee.mall.util;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 *  * PageResult类，用于封装分页查询结果的通用模型。
 *  *
 *  * 该类是一个泛型类，可以适用于不同类型的列表数据。
 *  *
 *  * PageResult类包含了分页查询的结果信息，包括总记录数、每页记录数、总页数、当前页数以及列表数据。
 *  *
 *  * 在构造函数中，会接收列表数据、总记录数、每页记录数和当前页数，并计算出总页数。
 *  *
 *  * 注意：该类使用了io.swagger.annotations.ApiModelProperty注解，
 *  * 可用于生成API文档时对字段的说明，建议根据具体业务情况提供详细的字段说明。
 *  *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 19:11
 */
public class PageResult<T> implements Serializable {

    @ApiModelProperty("总记录数")
    private int totalCount;

    @ApiModelProperty("每页记录数")
    private int pageSize;

    @ApiModelProperty("总页数")
    private int totalPage;

    @ApiModelProperty("当前页数")
    private int currPage;

    @ApiModelProperty("列表数据")
    private List<T> list;

    /**
     * 分页结果类的构造函数。
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageResult(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
