package org.xiaoqiaotq.repository;

import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.xiaoqiaotq.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/22.
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
    @Autowired
    private EntityManager em;
    @Override
    public Page<Map> findUsersByCustomGroupId(Pageable pageable) {
        StringBuffer sql=new StringBuffer();
        sql.append(" select new map(u as user, g.groupName as  groupName ,g.id as groupId) from CustomUserGroup g  join g.users u where g.id in (1) ");
        Query query = em.createQuery(sql.toString());
        Long total = (long)query.getResultList().size();//QueryUtils.executeCountQuery(getCountQuery(spec));
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<Map> content = total > pageable.getOffset() ? query.getResultList() : Collections.<Map> emptyList();

        return new PageImpl<Map>(content, pageable, total);
//        query.setFirstResult(page);
//        query.setMaxResults(rows);
    }
}
