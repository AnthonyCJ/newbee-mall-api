package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.AdminUserToken;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 管理员用户Token dao层接口，增删改查
 * @date 2023/07/28 20:54
 */
public interface NewBeeAdminUserTokenMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(AdminUserToken record);

    int insertSelective(AdminUserToken record);

    AdminUserToken selectByPrimaryKey(Long userId);

    AdminUserToken selectByToken(String token);

    int updateByPrimaryKeySelective(AdminUserToken record);

    int updateByPrimaryKey(AdminUserToken record);
}
