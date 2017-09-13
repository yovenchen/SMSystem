**一、简介：**

	这是一个校园信息管理系统，可以查询学校，学校下的班级，班级里的学生的信息，以及对各层信息的增删改查的管理

**二、开发环境：**

	IntelliJ IDEA 2017.01 + Tomcat + Win10 + Mysql + PowerDesigner + Adobe Photoshop CC (64 Bit) 

**三、框架：**

	Struts2 + Hibernate + Spring

**四、其他：**

	Java + Jsp + Js + CSS + Html

**五、数据库设计**

	学校表：school的主键shid作为班级表：clas的外键
	班级表：clas的主键cid作为学生表：student的外键

**六、功能：**

	1.前台

		查询学校，通过学校查询学校下的班级，班级下的学生，各层的详细信息。
	
	2.后台（管理）

		（1）学校管理：增删改查
		（2）班级管理：增删改查，包含学校的选择，以便存入到对应学校之下
		（3）学生管理：增删改查，包含学校的选择，以便存入到对应学校之下
		

----------

**七、系统运行截图：**

登录界面

![登录界面](https://github.com/TaroYoVen/SMSystem/raw/master/image/login.jpg)

----------
主界面

![主界面](https://github.com/TaroYoVen/SMSystem/raw/master/image/main.jpg)

----------
查询信息

![查询信息](https://github.com/TaroYoVen/SMSystem/raw/master/image/school.jpg)




