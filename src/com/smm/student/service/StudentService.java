package com.smm.student.service;

import com.smm.student.dao.StudentDao;
import com.smm.student.pojo.Student;
import com.smm.util.PageBean;

import java.util.List;

public class StudentService {

    //注入StudentDao
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public PageBean<Student> findByPage(Integer page) {
        PageBean<Student> pageBean = new PageBean<Student>();
        // 设置参数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 10;
        pageBean.setLimit(limit);
        // 设置总记录数:
        int totalCount = studentDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 设置总页数:
        int totalPage = 0;
        if (totalCount % limit == 0) {
            totalPage = totalCount / limit;
        } else {
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 设置页面显示数据的集合:
        int begin = (page - 1) * limit;
        List<Student> list = studentDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public Student findByStuid(Integer stuid) {
        return studentDao.findByStuid(stuid);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(Student student) {
        studentDao.delete(student);
    }

    public PageBean<Student> findByPageCid(Integer cid, Integer page) {
        PageBean<Student> pageBean = new PageBean<Student>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 8;
        pageBean.setLimit(limit);
        //  设置总记录数:
        int totalCount = 0 ;
        totalCount = studentDao.findCountCid(cid);
        pageBean.setTotalCount(totalCount);
        // 设置总页数:
        int totalPage = 0;
        // Math.ceil(totalCount / limit);
        if(totalCount % limit == 0){
            totalPage = totalCount / limit;
        }else{
            totalPage = totalCount / limit + 1;
        }
        pageBean.setTotalPage(totalPage);
        // 每页显示的数据集合:
        // 从哪开始:
        int begin = (page - 1) * limit;
        List<Student> list = studentDao.findByPageCid(cid,begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
}
