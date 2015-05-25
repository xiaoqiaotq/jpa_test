import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.District;
import org.xiaoqiaotq.repository.DistrictRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class TreeTest {
    @Autowired
    private DistrictRepository districtRepository;
    @Test
    @Transactional
    public void addRoot(){
        District district=new District();
        district.setName("江苏省");
        districtRepository.save(district);
    }

    @Test
    @Transactional
    public void addChildren(){
        District district=new District();
        district.setName("aaaaa市");
        District root = new District();
        root.setId(1);
        district.setParent(root);
        districtRepository.save(district);
    }

    @Test
    @Transactional
    public void testTransverse(){
        District root = districtRepository.findRoot();
        tranverseTree(root,new ArrayList<>());

    }
    private void tranverseTree(District district,Collection<District> collection) {
        System.err.println(district.getId()+" , "+district.getName());
        collection.add(district);
        for (District o : district.getChildren()) {
            tranverseTree(o,collection);
        }
    }
    @Test
    @Transactional
    public void addBoolean(){
        District district=new District();
        district.setName("aa");
        District root = new District();
        root.setId(1);
        district.setParent(root);
        districtRepository.save(district);
    }
    @Test
    @Transactional
    public void testToggleBoolean(){
//        districtRepository.toggleBoolean(9);
    }
}
