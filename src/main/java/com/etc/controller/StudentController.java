package com.etc.controller;

import com.etc.entity.Student;
import com.etc.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huge
 * @date 2020/9/28 - 16:22
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/getdetail/{sid}")
    public Map<String,Object> getDetail(@PathVariable Integer sid){
        Student student =studentService.findById(sid);
        Map<String,Object> map =new HashMap<>();
        if (student.getCla()!=null){
            map = restTemplate.getForObject("http://localhost:8773/cla/getcla/"+student.getCla(),Map.class);
        }
        if(student != null){
            map.put("sid",student.getSid());
            map.put("sname",student.getSname());
            map.put("sex",student.getSex());
            map.put("birth",student.getBirth());
        }
        return map;
    }

    @RequestMapping("/getstudent/{sid}")
    public Map<String,Object> getStudent(@PathVariable Integer sid){
        Student student = studentService.findById(sid);
        Map<String,Object> map = new HashMap<>();
        if(student != null){
            map.put("sid",student.getSid());
            map.put("sname",student.getSname());
            map.put("sex",student.getSex());
            map.put("birth",student.getBirth());
        }
        return map;
    }

    @RequestMapping("/getallstudent")
    public List<Student> getAllStudent(){
        return studentService.findAllStudent();
    }


}
