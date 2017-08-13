package com.smm.school.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smm.school.pojo.School;
import com.smm.school.service.SchoolService;
import com.smm.util.PageBean;

/**
 * Created by TaroChen on 2017/8/4.
 */
public class SchoolAction extends ActionSupport implements ModelDriven<School>{

    // 模型驱动使用的对象
    private School school = new School();

    public School getModel() {
        return school;
    }

    // 注入SchoolService
    private SchoolService schoolService;

    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    //接收page
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    public String findAll(){

        PageBean<School> pageBean = schoolService.findByPage(page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findAll";
    }

    //保存学校的信息
    public String save(){
        //调用service方法保存
        schoolService.save(school);
        return "saveSuccess";
    }

    //修改学校的信息
    public String edit(){
        //接收shid，可以使用模型驱动，必须根据id查询再修改
        school = schoolService.findByShid(school.getShid());
        return "editSuccess";
    }

    //删除学校的信息
    public String delete(){
        //调用service方法删除
        schoolService.delete(school);
        return "deleteSuccess";
    }

    //更新学校信息
    public String update(){
        //调用service方法更新
       schoolService.update(school);
       return "updateSuccess";
    }

    public String find(){

        PageBean<School> pageBean = schoolService.findByPage(page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "find";
    }
}
