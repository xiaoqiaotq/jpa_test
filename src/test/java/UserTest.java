import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.Address;
import org.xiaoqiaotq.domain.Student;
import org.xiaoqiaotq.domain.User;
import org.xiaoqiaotq.repository.StudentRepository;
import org.xiaoqiaotq.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        User u2=new User();
        u2.setAddress(new Address("吴中区", "啊啊blco222", 2222));
        userRepository.save(u2);
    }
}
