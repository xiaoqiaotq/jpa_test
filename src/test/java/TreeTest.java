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
import java.util.Collections;
import java.util.List;

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
        district.setName("江宁区");
        District root = new District();
        root.setId(2);
        district.setParent(root);
        districtRepository.save(district);
    }

    @Test
    @Transactional
    public void testTransverse(){
        District root = districtRepository.findRoot();
//        tranverseTree(root,new ArrayList<>());
        List<District> districts = traverseTree(root);
        System.err.println(districts);

    }
    private void tranverseTree(District district,Collection<District> collection) {
        System.err.println(district.getId()+" , "+district.getName());
        collection.add(district);
        for (District o : district.getChildren()) {
            tranverseTree(o,collection);
        }
    }
    private List<District>  traverseTree(District district) {
        System.err.println(district.getId()+" , "+district.getName());
        List<District> list = new ArrayList<>();
        list.add(district);
        for (District o : district.getChildren()) {
           list.addAll(traverseTree(o));
        }
        return list;
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
