package com.smm.student.dao;

import com.smm.student.pojo.Student;
import com.smm.util.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class StudentDao extends HibernateDaoSupport {

    // DAO中的统计二级分类个数的方法
    public int findCount() {
        String hql = "select count(*) from Student";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    // DAO中分页查询的方法
    public List<Student> findByPage(int begin, int limit) {
        String hql = "from Student order by cid desc";
        List<Student> list = this.getHibernateTemplate().execute(
                new PageHibernateCallback<Student>(hql, null, begin,
                        limit));
        return list;
    }

    public void save(Student student) {
        this.getHibernateTemplate().save(student);
    }

    public Student findByStuid(Integer stuid) {
        return this.getHibernateTemplate().get(Student.class,stuid);
    }

    public void update(Student student) {
        this.getHibernateTemplate().update(student);
    }

    public void delete(Student student) {
        this.getHibernateTemplate().delete(student);
    }

    public int findCountCid(Integer cid) {
        String hql = "select count(*) from Student s where s.clas.cid = ?";
        List<Long> list = this.getHibernateTemplate().find(hql, cid);
        if(list != null && list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Student> findByPageCid(Integer cid, int begin, int limit) {
        String hql = "select s from Student s join s.clas c where c.cid = ?";
        List<Student> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Student>(hql, new Object[]{cid}, begin, limit));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }
}
