import com.lijian.config.SpringConfig;
import com.lijian.entity.User;
import com.lijian.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author lijia
 * @createTime 2023/5/22 21:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class testMapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
