package ltd.newbee.mall.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.dao.AdminUserMapper;
import ltd.newbee.mall.entity.AdminUser;

@SpringBootTest
public class AdminUserMapperTest {

    @Mock
    private AdminUserMapper adminUserMapper;

    @Test
    public void testLogin_Success() {
        // Arrange
        String userName = "admin";
        String password = "e10adc3949ba59abbe56e057f20f883e";
        AdminUser adminUser = new AdminUser();
        adminUser.setAdminUserId(1L);
        adminUser.setLoginUserName(userName);
        adminUser.setLoginPassword(password);
        adminUser.setNickName("十三");
        adminUser.setLocked((byte) 0);
        
        when(adminUserMapper.login(userName, password)).thenReturn(adminUser);

        // Act
        AdminUser result = adminUserMapper.login(userName, password);

        // Assert
        assertEquals(adminUser, result);
    }

    @Test
    public void testLogin_Failure() {
        // Arrange
        String userName = "admin";
        String password = "wrongPassword";
        
        when(adminUserMapper.login(userName, password)).thenReturn(null);

        // Act
        AdminUser result = adminUserMapper.login(userName, password);

        // Assert
        assertEquals(null, result);
    }

}
