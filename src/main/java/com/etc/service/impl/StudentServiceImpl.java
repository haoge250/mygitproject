package com.etc.service.impl;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;
import com.etc.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author huge
 * @date 2020/9/28 - 16:16
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;
    @Override
    public Student findById(Integer sid) {
        Optional<Student> optional = studentDao.findById(sid);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAll();
    }
}
