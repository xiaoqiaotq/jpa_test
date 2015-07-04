import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.expression.spel.ast.OpNE;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.AutoStatisticsConf;
import org.xiaoqiaotq.domain.OneToMany.Many;
import org.xiaoqiaotq.domain.OneToMany.One;
import org.xiaoqiaotq.domain.TimePoint;
import org.xiaoqiaotq.repository.AutoStatisticsConfRepository;
import org.xiaoqiaotq.repository.OneRepository;

import javax.persistence.Temporal;
import java.util.HashSet;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class OneToManyTest {
    @Autowired
    private OneRepository oneRepository;

    @Test
    public void saveOne(){
        One one=new One();
        one.setName("one2");
        Many many1=new Many();
        many1.setName("many3");
        Many many2=new Many();
        many2.setName("many43");
        Set set = new HashSet<>();
        set.add(many1);
        set.add(many2);
        one.setManySet(set);
        oneRepository.save(one);
    }

}