package ltd.newbee.mall.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.service.impl.NewBeeMallUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.MallUserMapper;

@SpringBootTest
public class NewBeeMallUserServiceImplTest {

    @Mock
    private MallUserMapper mallUserMapper;

    @InjectMocks
    private NewBeeMallUserServiceImpl userService;

    @Test
    public void testRegister_Success() {
        // Arrange
        String loginName = "testUser";
        String password = "testPassword";
        when(mallUserMapper.selectByLoginName(loginName)).thenReturn(null);

        // Act
        String result = userService.register(loginName, password);

        // Assert
        assertEquals(ServiceResultEnum.SUCCESS.getResult(), result);
    }

    @Test
    public void testRegister_SameLoginNameExist() {
        // Arrange
        String loginName = "existingUser";
        String password = "testPassword";
        when(mallUserMapper.selectByLoginName(loginName)).thenReturn(new MallUser());

        // Act
        String result = userService.register(loginName, password);

        // Assert
        assertEquals(ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult(), result);
    }

    @Test
    public void testRegister_DbError() {
        // Arrange
        String loginName = "testUser";
        String password = "testPassword";
        when(mallUserMapper.selectByLoginName(loginName)).thenReturn(null);
        when(mallUserMapper.insertSelective(any(MallUser.class))).thenReturn(0);

        // Act
        String result = userService.register(loginName, password);

        // Assert
        assertEquals(ServiceResultEnum.DB_ERROR.getResult(), result);
    }
}

