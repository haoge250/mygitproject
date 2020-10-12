package com.etc.controller;

import com.etc.entity.Student;
import com.etc.feigninters.StuFeignClient;
import com.etc.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huge
 * @date 2020/9/29 - 17:16
 */
@RestController
@RequestMapping("/stu")
public class StuController {
    @Resource
    StudentService studentService;

    @Resource
    private StuFeignClient stuFeignClient;

    @RequestMapping("/getclafeign/{sid}")
    public Map<String,Object> getClaDetail(@PathVariable Integer sid){
        Student student =studentService.findById(sid);
        Map<String,Object> map =new HashMap<>();
        if (student.getCla()!=null){
            //调用feign中定义的方法
            map = stuFeignClient.getClassById(student.getCla());
        }
        if(student != null){
            map.put("sid",student.getSid());
            map.put("sname",student.getSname());
            map.put("sex",student.getSex());
            map.put("birth",student.getBirth());
        }
        return map;
    }
}
