package com.etc.service;

import com.etc.entity.Student;

import java.util.List;

/**
 * @author huge
 * @date 2020/9/28 - 16:14
 */
public interface StudentService {
    public Student findById(Integer sid);
    public List<Student> findAllStudent();
}
