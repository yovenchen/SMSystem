package com.smm.student.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smm.clas.pojo.Clas;
import com.smm.clas.service.ClasService;
import com.smm.student.pojo.Student;
import com.smm.student.service.StudentService;
import com.smm.util.PageBean;

import java.util.List;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{

    //注入模型驱动
    private Student student = new Student();
    @Override
    public Student getModel() {
        return student;
    }

    //注入StudentService
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    //注入ClasService
    private ClasService clasService;

    public void setClasService(ClasService clasService) {
        this.clasService = clasService;
    }

    //接收page
    private Integer page;

    public void setPage(Integer page) {
        this.page = page;
    }

    private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    //查询班级的方法
    public String findAll(){
        PageBean<Student> pageBean = studentService.findByPage(page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findAll";
    }

    // 跳转到添加页面的方法:
    public String addPage() {
        // 查询班级
        List<Clas> cList = clasService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("cList", cList);
        // 页面跳转:
        return "addPageSuccess";
    }

    //添加学生信息
    public String save(){
        studentService.save(student);
        return "saveSuccess";
    }

    //编辑学生信息
    public String edit() {
        // 根据id查询学生:
        student = studentService.findByStuid(student.getStuid());
        // 查询班级:
        List<Clas> cList = clasService.findAll();
        // 将集合存入到值栈中.
        ActionContext.getContext().getValueStack().set("cList", cList);
        // 页面跳转:
        return "editSuccess";
    }

    //更新学生信息
    public String update(){
        studentService.update(student);
        return "updateSuccess";
    }

    // 删除学生的方法:
    public String delete() {
        //如果级联删除，先查询再删除，配置cascade
        student = studentService.findByStuid(student.getStuid());
        studentService.delete(student);
        return "deleteSuccess";
    }

    //根据班级id，查询学生的方法
    public String findByCid(){
        PageBean<Student> pageBean = studentService.findByPageCid(cid,page);
        // 将pageBean的数据存入到值栈中.
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findByCid";
    }
}
