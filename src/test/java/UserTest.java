import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.Address;
import org.xiaoqiaotq.domain.Student;
import org.xiaoqiaotq.domain.User;
import org.xiaoqiaotq.repository.StudentRepository;
import org.xiaoqiaotq.repository.UserRepository;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        User u2=new User();
        u2.setAddress(new Address("吴中区", "啊啊blco222", 2222));
        userRepository.save(u2);
    }
    @Test
//    @Transactional
    public void test2() {
        User one = userRepository.findOne(2l);
        one.setAddress(new Address("吴dddd中aaa区", "cc", 11));

    }

    @Test
    public void test3() {
        User u = new User();
        u.setId(33);
        u.setAddress(new Address("33", "c22c", 11));
        userRepository.save(u);
    }
    @Test
    public void testFind() {
        List<User> all = userRepository.findAll(Arrays.asList(new Long[]{10l, 20l, 38l}));
        System.err.println(all);
    }
    @Test
    @Transactional
    public void testSetEmail() {
        User one = userRepository.findOne(1l);
        List<String> list = Arrays.asList(new String[]{"aaa", "bbb"});
        one.setEmails(new HashSet<>(list));
    }
    @Test
    public void testEnum() {
        System.err.println(User.CarBrands.FIAT.getDeclaringClass());
        System.err.println(User.CarBrands.class.getDeclaringClass());
    }
    @Test
    public void testDecalringOrEnclosing() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println(this.getClass().getDeclaringClass());
                System.err.println(this.getClass().getEnclosingClass());
            }
        }).run();
    }
    @Test
    public void testDecimalFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("##.000%");
        String format = decimalFormat.format(1.333);
        System.err.println(format);
    }
}
