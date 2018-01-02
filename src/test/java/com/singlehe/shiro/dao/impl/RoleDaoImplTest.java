import com.singlehe.shiro.dao.RoleDao;
import com.singlehe.shiro.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class RoleDaoImplTest {
    @Autowired
    private RoleDao roleDao;
    @Test
    public void saveRole() throws Exception{
        Role role = new Role("码奴","重复造轮子就行了",true);
        Role role1 = roleDao.saveRole(role);
        System.out.println(role1.toString());
    }
    @Test
    public void updateRole() throws Exception{

    }
    @Test
    public void deleteRole() throws Exception{
        roleDao.deleteRole(2L);
        System.out.println("删除成功！");
    }
    @Test
    public void findOne() throws Exception{

    }
    @Test
    public void findAll() throws Exception{

    }
}
