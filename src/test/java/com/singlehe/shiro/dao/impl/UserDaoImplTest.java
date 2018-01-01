package impl;

import com.singlehe.shiro.dao.UserDao;
import com.singlehe.shiro.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void saveUser() throws Exception {
        User user = new User("SingleHe","123456");
        user.setLocked(false);
        user.setOrganizationId(1L);
        user.setSalt("singlehe");
        User backUser = userDao.saveUser(user);
        System.out.println("新创建的用户信息为:"+backUser.toString());
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findByUsername() throws Exception {
    }

}