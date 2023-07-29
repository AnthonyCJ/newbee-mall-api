package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.MallUserToken;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 商城用户的登录令牌表dao层接口
 * @date 2023/07/28 21:06
 */
public interface NewBeeMallUserTokenMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(MallUserToken record);

    int insertSelective(MallUserToken record);

    MallUserToken selectByPrimaryKey(Long userId);

    MallUserToken selectByToken(String token);

    int updateByPrimaryKeySelective(MallUserToken record);

    int updateByPrimaryKey(MallUserToken record);
}
