import com.singlehe.shiro.dao.UserDao;
import com.singlehe.shiro.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void saveUser() throws Exception {
        User user = new User("JoeChen","123456");
        user.setLocked(false);
        user.setOrganizationId(1L);
        user.setSalt("singlehe");
        User backUser = userDao.saveUser(user);
        System.out.println("新创建的用户信息为:"+backUser.toString());
    }

    @Test
    public void updateUser() throws Exception {
        User user = userDao.findOne(1L);
        user.setPassword("SingleHe");
        User user1 = userDao.updateUser(user);
        System.out.println(user1.toString());
    }

    @Test
    public void deleteUser() throws Exception {
        try {
            userDao.deleteUser(3L);
            System.out.println("删除成功！");
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {

        }
    }

    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        List<User> all = userDao.findAll();
        for(User user : all){
            System.out.println(user.toString());
        }
    }

    @Test
    public void findByUsername() throws Exception {
        User singleHe = userDao.findByUsername("SingleHe");
        System.out.println(singleHe.toString());
    }

}