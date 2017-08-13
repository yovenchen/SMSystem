package com.smm.clas.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smm.clas.pojo.Clas;
import com.smm.clas.service.ClasService;
import com.smm.school.pojo.School;
import com.smm.school.service.SchoolService;
import com.smm.util.PageBean;

import java.util.List;

public class ClasAction extends ActionSupport implements ModelDriven<Clas>{

    //注入模型驱动
    private Clas clas = new Clas();
    @Override
    public Clas getModel() {
        return clas;
    }
    //注入ClasService
    private ClasService clasService;

    public void setClasService(ClasService clasService) {
        this.clasService = clasService;
    }

    //注入学校的service方法
    private SchoolService schoolService;

    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    //接收page
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    private Integer shid;

    public Integer getShid() {
        return shid;
    }

    public void setShid(Integer shid) {
        this.shid = shid;
    }

    //查询班级的方法
    public String findAll(){
        PageBean<Clas> pageBean = clasService.findByPage(page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findAll";
    }

    // 跳转到添加页面的方法:
    public String addPage() {
        // 查询所有一级分类.
        List<School> sList = schoolService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("sList", sList);
        // 页面跳转:
        return "addPageSuccess";
    }

    //添加班级的方法
    public String save(){
        clasService.save(clas);
        return "saveSuccess";
    }

    // 编辑班级的方法:
    public String edit() {
        // 根据id查询班级:
        clas = clasService.findByCid(clas.getCid());
        // 查询所有一级分类:
        List<School> sList = schoolService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("sList", sList);
        // 页面跳转:
        return "editSuccess";
    }

    //更新班级的方法
    public String update(){
        clasService.update(clas);
        return "updateSuccess";
    }

    //删除班级的方法
    public String delete(){
        //如果级联删除，先查询再删除，配置cascade
        clas = clasService.findByCid(clas.getCid());
        clasService.delete(clas);
        return "deleteSuccess";
    }

    //根据学校id,查询班级的方法
    public String findByShid(){
        PageBean<Clas> pageBean = clasService.findByPageShid(shid,page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findByShid";
    }
}
