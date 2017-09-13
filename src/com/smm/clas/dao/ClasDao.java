package com.smm.clas.dao;

import com.smm.clas.pojo.Clas;
import com.smm.util.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class ClasDao extends HibernateDaoSupport {

    // DAO中的统计班级个数的方法
    public int findCount() {
        String hql = "select count(*) from Clas";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    // DAO中分页查询的方法
    public List<Clas> findByPage(int begin, int limit) {
        String hql = "from Clas order by cid desc";
        List<Clas> list = this.getHibernateTemplate().execute(
                new PageHibernateCallback<Clas>(hql, null, begin,
                        limit));
        return list;
    }

    public void save(Clas clas) {
        this.getHibernateTemplate().save(clas);
    }

    public Clas findByCid(String cid) {
        return this.getHibernateTemplate().get(Clas.class, cid);
    }

    public void update(Clas clas) {
        this.getHibernateTemplate().update(clas);
    }

    public void delete(Clas clas) {
        this.getHibernateTemplate().delete(clas);
    }

    public List<Clas> findAll() {
        String hql = "from Clas";
        List<Clas> list = this.getHibernateTemplate().find(hql);
        return list;
    }

    public int findCountShid(String shid) {
        String hql = "select count(*) from Clas c where c.school.shid = ?";
        List<Long> list = this.getHibernateTemplate().find(hql, shid);
        if(list != null && list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Clas> findByPageShid(String shid, int begin, int limit) {
        String hql = "select c from Clas c join c.school sh where sh.shid = ?";
        List<Clas> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Clas>(hql, new Object[]{shid}, begin, limit));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    public Clas findByCname(String cname) {
        String hql = "from Clas c where c.cname = ?";
        List<Clas> list = this.getHibernateTemplate().find(hql,cname);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public Clas findByShid(String shid) {
        String hql = "from Clas c where c.school.shid = ?";
        List<Clas> list = this.getHibernateTemplate().find(hql,shid);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
