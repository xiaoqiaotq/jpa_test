import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.StringIdEntity;
import org.xiaoqiaotq.repository.StringIdEntityRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class StringIdEntityTest {
    @Autowired
    private StringIdEntityRepository repository;
    @Test
    public void testSave(){
        StringIdEntity stringIdEntity=new StringIdEntity();
        stringIdEntity.setId("222");
        stringIdEntity.setNameee("dsfdsf");
        repository.save(stringIdEntity);
    }
    @Test
    @Transactional
    public void testUpdate(){
        StringIdEntity one = repository.findOne("222");
        one.setId("2222222");
    }
}

