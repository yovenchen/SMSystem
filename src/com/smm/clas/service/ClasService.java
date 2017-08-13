package com.smm.clas.service;

import com.smm.clas.dao.ClasDao;
import com.smm.clas.pojo.Clas;
import com.smm.util.PageBean;
import java.util.List;

public class ClasService {

    //注入ClasDao
    private ClasDao clasDao;

    public void setClasDao(ClasDao clasDao) {
        this.clasDao = clasDao;
    }

    // 班级带有分页的查询操作:
    public PageBean<Clas> findByPage(Integer page) {

        PageBean<Clas> pageBean = new PageBean<Clas>();

        // 设置参数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 10;
        pageBean.setLimit(limit);
        // 设置总记录数:
        int totalCount = clasDao.findCount();
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
        List<Clas> list = clasDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    //保存班级
    public void save(Clas clas) {
        clasDao.save(clas);
    }

    public Clas findByCid(Integer cid) {
        return clasDao.findByCid(cid);
    }

    public void update(Clas clas) {
        clasDao.update(clas);
    }

    public void delete(Clas clas) {
        clasDao.delete(clas);
    }

    public List<Clas> findAll() {
        return clasDao.findAll();
    }

    public PageBean<Clas> findByPageShid(Integer shid, Integer page) {
        PageBean<Clas> pageBean = new PageBean<Clas>();
        // 设置当前页数:
        pageBean.setPage(page);
        // 设置每页显示记录数:
        int limit = 8;
        pageBean.setLimit(limit);
        //  设置总记录数:
        int totalCount = 0 ;
        totalCount = clasDao.findCountShid(shid);
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
        List<Clas> list = clasDao.findByPageShid(shid,begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
}
