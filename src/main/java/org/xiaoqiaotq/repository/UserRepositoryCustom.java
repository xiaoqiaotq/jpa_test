package org.xiaoqiaotq.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.xiaoqiaotq.domain.User;

import java.util.List;
import java.util.Map;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/22.
 */
public interface UserRepositoryCustom {
    Page<Map> findUsersByCustomGroupId(Pageable pageable);
}
