import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.Address;
import org.xiaoqiaotq.domain.CustomUserGroup;
import org.xiaoqiaotq.domain.Student;
import org.xiaoqiaotq.domain.User;
import org.xiaoqiaotq.repository.CustomUserGroupRepository;
import org.xiaoqiaotq.repository.StudentRepository;
import org.xiaoqiaotq.repository.UserRepository;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import sun.text.normalizer.UTF16;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class CustomUserGroupTest {
    @Autowired
    private CustomUserGroupRepository customUserGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSave() {
        CustomUserGroup customUserGroup=new CustomUserGroup();
        customUserGroup.setGroupName("001078");
        User u1=new User();
        u1.setAddress(new Address("平江路22","pinganjie",11111));
        User u2=new User();
        u2.setAddress(new Address("平江路11","pinganjie",11111));
        Set<User> users = new HashSet<>();
        users.add(u1);
        users.add(u2);
        customUserGroup.setUsers(users);
        customUserGroupRepository.save(customUserGroup);  //没设cascadetype=persist  报TransientObjectException: object references an unsaved transient instance
//        结果
//        Hibernate: insert into custom_user_group (group_name) values (?)
//        Hibernate: insert into user (district, postcode, street, abcd, dtype) values (?, ?, ?, ?, 'User')
//        Hibernate: insert into custom_user_group_users (custom_user_group, users) values (?, ?)
//        Hibernate: insert into custom_user_group_users (custom_user_group, users) values (?, ?)
    }
    @Test
    public void testDel() {
         customUserGroupRepository.delete(11l);
//         结果
//        Hibernate: select customuser0_.id as id1_0_0_, customuser0_.group_name as group_na2_0_0_ from custom_user_group customuser0_ where customuser0_.id=?
//        Hibernate: delete from custom_user_group_users where custom_user_group=?
//        Hibernate: delete from custom_user_group where id=?
    }
    @Test
    @Transactional
    public void testUpdate() {
        CustomUserGroup customUserGroup = customUserGroupRepository.findOne(11l);
        User u1 = userRepository.findOne(1l);
        u1.setAddress(new Address("dddddddd","dsfdsfaaa是打发打发",12334));
        User u2=userRepository.findOne(2l);
        Set<User> userSet = customUserGroup.getUsers();
        userSet.add(u1);
        userSet.add(u2);
//        customUserGroupRepository.save(customUserGroup);
//        System.err.println(customUserGroup.getGroupName());
    }
    @Test
    @Transactional()
    public void test3() {
        CustomUserGroup customUserGroup = customUserGroupRepository.findOne(4l);
//        CustomUserGroup customUserGroup = new CustomUserGroup();
//        customUserGroup.setId(5l);
        customUserGroup.setGroupName("nihaodd地方");
        User u2=userRepository.findOne(2l);
        u2.setAddress(new Address("nihaow", "suzhou", 111111));
        customUserGroup.getUsers().remove(u2);
//        customUserGroupRepository.save(customUserGroup);
    }
    @Test
    @Transactional()
    public void test6() {
        CustomUserGroup customUserGroup = customUserGroupRepository.findOne(4l);
        customUserGroup.setGroupName("nihao");
        User u2=userRepository.findOne(2l);
        u2.setAddress(new Address("nihao", "suzhou", 111111));
        customUserGroup.getUsers().remove(u2);
        customUserGroupRepository.save(customUserGroup);
    }
    @Test
    @Transactional()
    public void testAdd() {
        CustomUserGroup customUserGroup = customUserGroupRepository.findOne(4l);
        customUserGroup.setGroupName("nihao");
        User u2=userRepository.findOne(3l);new User();
        customUserGroup.getUsers().add(u2);
//        customUserGroupRepository.save(customUserGroup);
    }
    @Test
    @Transactional
    public void test5() {
        CustomUserGroup customUserGroup = customUserGroupRepository.findOne(4l);
        customUserGroup.setGroupName("nihao3");
        customUserGroup.setUsers(null);
//        customUserGroupRepository.flush();
//        customUserGroupRepository.save(customUserGroup);
    }
    @Test
    @Transactional
    public void test4() {
        CustomUserGroup customUserGroup = customUserGroupRepository.getOne(4l);
        System.err.println(customUserGroup.getUsers());
    }
    @Test
    public void testQuery() {
        PageRequest pageRequest=new PageRequest(0,2);
        Specification<CustomUserGroup> specification =( root, query, cb)->{
           return cb.like(root.get("groupName"),"%0%");
        };
        Page<CustomUserGroup> customUserGroups = customUserGroupRepository.findAll(specification, pageRequest);
        for (CustomUserGroup customUserGroup : customUserGroups) {
            System.err.println(customUserGroup);
        }
    }
//    private Specification<Rest> buildAuditSpecification(final User user, final RestCondition condition) {
//        Specification<Rest> spec = new Specification<Rest>() {
//
//            @Override
//            public Predicate toPredicate(Root<Rest> root,
//                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Predicate predicate = cb.conjunction();
//                List<Expression<Boolean>> expressions = predicate.getExpressions();
//                if (StringUtils.isNotBlank(condition.getSearchUsername())) {
//                    expressions.add(cb.like(root.<User>get("user").<String>get("username"), "%"+condition.getSearchUsername()+"%"));           //用户邮箱
//                }
//                if ((condition.getSearchAuditState()!=null)) {
//                    expressions.add(cb.equal(root.<AuditState>get("auditState"), condition.getSearchAuditState()));      //审核状态
//                }
//
//                expressions.add(cb.notEqual(root.get("user").get("id"), user.getId()));
//                return predicate;
//            }
//        };
//        return spec;
//    }
    @Test
    @Transactional
    public void testMove() {
        CustomUserGroup sourceGroup = customUserGroupRepository.findOne(1l);
        Set<User> users = sourceGroup.getUsers();
        customUserGroupRepository.findOne(9l).getUsers().addAll(users);
        sourceGroup.setUsers(null);
        customUserGroupRepository.flush();
    }

    @Test
    @Transactional
    public void testQuery2() {
//        List<User> users1 = customUserGroupRepository.findUsers(9l);
//        System.err.println(users1);
//        List<User> users1 = customUserGroupRepository.findUsers2(new PageRequest(0,2));//(root,cq,cb)->{ return cb.equal(root.get("id"),333);});
        List<User> id1 = userRepository.findAll((root, cq, cb) -> {
            Subquery<Integer> subquery = cq.subquery(Integer.class);
            Root<CustomUserGroup> customUserGroupRoot = subquery.from(CustomUserGroup.class);
            Join<CustomUserGroup, User> users = customUserGroupRoot.join("users");
            subquery.select(users.get("id"));
//            subquery.where(cb.equal(customUserGroupRoot.get("id")))
            return cb.in(root.get("id")).value(subquery);
        });
        System.err.println(id1);
//        System.err.println(customUserGroupRepository.findUsers2(9l, new PageRequest(0,10)));
    }
    @Test
    @Transactional
    public void testQuery3() {
//        List<User> users1 = customUserGroupRepository.findUsers(9l);
//        System.err.println(users1);
//        List<User> users1 = customUserGroupRepository.findUsers2(new PageRequest(0,2));//(root,cq,cb)->{ return cb.equal(root.get("id"),333);});
        List<User> id1 = userRepository.findAll((root, cq, cb) -> {
            Subquery<Integer> subquery = cq.subquery(Integer.class);
            Root<CustomUserGroup> customUserGroupRoot = subquery.from(CustomUserGroup.class);
            Join<CustomUserGroup, User> users = customUserGroupRoot.join("users");
            subquery.select(users.get("id"));
//            subquery.where(cb.equal(customUserGroupRoot.get("id")))
            return cb.in(root.get("id")).value(subquery);
        });
        System.err.println(id1);
//        System.err.println(customUserGroupRepository.findUsers2(9l, new PageRequest(0,10)));
    }
    @Test
    @Transactional
    public void testQuery4() {
        Page<Map> id1 = userRepository.findUsersByCustomGroupId(new PageRequest(1,3));
        System.err.println(id1);
        Gson gson=new Gson();
        System.err.println(gson.toJson(id1));
//        System.err.println(customUserGroupRepository.findUsers2(9l, new PageRequest(0,10)));
    }
    @Test
    @Transactional
    public void testQuery5() {
        Page<User> id1 = userRepository.findAll(new PageRequest(1, 3));
        System.err.println(id1);
        Gson gson=new Gson();
        System.err.println(gson.toJson(id1));
//        System.err.println(customUserGroupRepository.findUsers2(9l, new PageRequest(0,10)));
    }
}
