package com.etc.dao;

import com.etc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author huge
 * @date 2020/9/28 - 16:11
 */
public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student>, Serializable {
}
