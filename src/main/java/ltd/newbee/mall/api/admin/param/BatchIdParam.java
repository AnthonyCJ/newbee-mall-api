package ltd.newbee.mall.api.admin.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 批量ID参数类
 * 用于接收批量操作中的ID数组
 */
@Data
public class BatchIdParam implements Serializable {
    // id数组
    Long[] ids;
}
