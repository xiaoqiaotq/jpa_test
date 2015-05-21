import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.Student;
import org.xiaoqiaotq.repository.StudentRepository;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void test1() {
        studentRepository.save(new Student());
    }
}
