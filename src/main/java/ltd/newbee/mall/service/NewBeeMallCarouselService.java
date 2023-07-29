/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本软件已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2021 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.vo.NewBeeMallIndexCarouselVO;
import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

/**
 * 商城轮播图服务层接口
 *
 * @author GnayYzal
 * @version 1.0
 * @date 2023/07/29 16:18
 */

public interface NewBeeMallCarouselService {

    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number 轮播图数量
     * @return 获取到的轮播图数据（列表）
     */
    List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number);

    /**
     * 后台分页
     *
     * @param pageUtil 分页查询条件（每页数据数量和所在页码）
     * @return 分页查询的结果
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    /**
     * 添加轮播图
     *
     * @param carousel 需要保存的轮播图对象
     * @return 操作结果，成功success
     */
    String saveCarousel(Carousel carousel);

    /**
     * 修改轮播图
     *
     * @param carousel 需要更新的轮播图对象
     * @return 操作结果，成功success
     */
    String updateCarousel(Carousel carousel);

    /**
     * 查询轮播图
     *
     * @param id 轮播图id
     * @return 根据传入id查询到的轮播图对象
     */
    Carousel getCarouselById(Integer id);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要批量删除的轮播图的 ID 数组
     * @return 删除操作的结果，成功为true
     */
    Boolean deleteBatch(Long[] ids);
}
