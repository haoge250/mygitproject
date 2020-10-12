package com.etc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author huge
 * @date 2020/9/28 - 16:04
 */
@Entity
@Table(name = "Stu")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Integer sid;
    @Column(name = "sname")
    private String sname;
    @Column(name = "sex")
    private String sex;
    @Column(name = "birth")
    private String birth;
    @Column(name = "cla")
    private Integer cla;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", cla=" + cla +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getCla() {
        return cla;
    }

    public void setCla(Integer cla) {
        this.cla = cla;
    }

    public Student(String sname, String sex, String birth, Integer cla) {
        this.sname = sname;
        this.sex = sex;
        this.birth = birth;
        this.cla = cla;
    }

    public Student() {
    }
}
