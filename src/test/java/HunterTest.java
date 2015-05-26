import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.Dog;
import org.xiaoqiaotq.domain.Hunter;
import org.xiaoqiaotq.domain.Student;
import org.xiaoqiaotq.repository.HunterResopistory;

import javax.transaction.Transactional;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback = false)
public class HunterTest {
    @Autowired
    private HunterResopistory hunterResopistory;

    @Test
    public void testAdd() {
        Hunter hunter = new Hunter();
        hunter.setName("Lisi");
        Dog dog1=new Dog();
        dog1.setNickname("wangzai");
        Dog dog2=new Dog();
        dog2.setNickname("xiaoqiang");
        Set<Dog> dogs = new HashSet<>();
        dogs.add(dog1);
        dogs.add(dog2);
        hunter.setDogs(dogs);

        hunterResopistory.save(hunter);
    }

    @Test
    @Transactional
    public void testSerializable() {
        Hunter hunter = hunterResopistory.findOne(1);
        hunter.getDogs().size();
        Hunter copy = (Hunter) deepCopy(hunter);
        hunterResopistory.save(copy);
    }

    private Serializable deepCopy(Serializable serializable) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(serializable);
            ByteArrayInputStream in =new  ByteArrayInputStream(out.toByteArray());
            ObjectInputStream inputStream = new ObjectInputStream(in);
            Serializable o = (Serializable) inputStream.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
