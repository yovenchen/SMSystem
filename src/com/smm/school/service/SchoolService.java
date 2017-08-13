package com.smm.school.service;

import com.smm.school.dao.SchoolDao;
import com.smm.school.pojo.School;
import com.smm.util.PageBean;

import java.util.List;

/**
 * Created by TaroChen on 2017/8/4.
 */
public class SchoolService {

    //注入SchoolDao
    private SchoolDao schoolDao;

    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    // 二级分类带有分页的查询操作:
    public PageBean<School> findByPage(Integer page) {

        PageBean<School> pageBean = new PageBean<School>();

        // 设置参数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 10;
        pageBean.setLimit(limit);
        // 设置总记录数:
        int totalCount = schoolDao.findCount();
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
        List<School> list = schoolDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    public void save(School school){
        schoolDao.save(school);
    }

    public School findByShid(Integer shid) {
        return schoolDao.findByShid(shid);
    }

    public void delete(School school) {
        schoolDao.delete(school);
    }

    public List<School> findAll(){
        return schoolDao.findAll();
    }

    public void update(School school) {
        schoolDao.update(school);
    }
}
