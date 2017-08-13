package com.smm.clas.pojo;

import com.smm.school.pojo.School;
import com.smm.student.pojo.Student;

import java.util.HashSet;
import java.util.Set;

public class Clas {

    private Integer cid;
    private String cname;

    //所属学校，存的是学校的对象
    private School school;

    //配置学生集合
    private Set<Student> student = new HashSet<Student>();

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
