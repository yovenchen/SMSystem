package com.smm.school.dao;

import com.smm.school.pojo.School;
import com.smm.util.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by TaroChen on 2017/8/4.
 */
public class SchoolDao extends HibernateDaoSupport {

    // DAO中的统计二级分类个数的方法
    public int findCount() {
        String hql = "select count(*) from School";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    // DAO中分页查询的方法
    public List<School> findByPage(int begin, int limit) {
        String hql = "from School order by shid desc";
        List<School> list = this.getHibernateTemplate().execute(
                new PageHibernateCallback<School>(hql, null, begin,
                        limit));
        return list;
    }

    // DAO中添加的方法
    public void save(School school){
        this.getHibernateTemplate().save(school);
    }

    public School findByShid(String shid) {
        return this.getHibernateTemplate().get(School.class,shid);
    }

    public void delete(School school) {
        this.getHibernateTemplate().delete(school);
    }

    public List<School> findAll() {
        String hql="from School";
        List<School> list =  this.getHibernateTemplate().find(hql);
        return list;
    }

    public void update(School school) {
        this.getHibernateTemplate().update(school);
    }
}
