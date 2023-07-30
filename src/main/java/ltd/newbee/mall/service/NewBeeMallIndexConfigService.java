package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.vo.NewBeeMallIndexConfigGoodsVO;
import ltd.newbee.mall.entity.IndexConfig;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

/**
 * 首页配置服务层接口
 *
 * @author GnayYzal
 * @version 1.0
 * @date 2023/07/29 16:29
 */

public interface NewBeeMallIndexConfigService {

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param configType 配置类型
     * @param number 商品数量
     * @return 首页配置的商品列表数据VO对象集合
     */
    List<NewBeeMallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    /**
     * 后台分页
     *
     * @param pageUtil 分页查询条件
     * @return 分页查询结果
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    /**
     * 添加首页配置信息
     *
     * @param indexConfig 首页配置信息
     * @return 添加操作结果，成功success
     */
    String saveIndexConfig(IndexConfig indexConfig);

    /**
     * 修改首页配置信息
     *
     * @param indexConfig 首页配置信息
     * @return 修改操作结果，成功success
     */
    String updateIndexConfig(IndexConfig indexConfig);

    /**
     * 获取首页配置信息
     *
     * @param id 待获取首页配置信息的配置ID
     * @return 对应的首页配置信息，信息不存在则返回null
     */
    IndexConfig getIndexConfigById(Long id);

    /**
     * 批量删除首页配置信息
     *
     * @param ids 首页配置id
     * @return 删除操作结果
     */
    Boolean deleteBatch(Long[] ids);
}
