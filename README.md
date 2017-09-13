**一、简介：**

	这是一个校园信息管理系统，可以查询学校，学校下的班级，班级里的学生的信息，以及对各层信息的增删改查的管理，实现了信息的关联和安全校验

**二、开发环境(工具)：**

	IntelliJ IDEA 2017.01 + Tomcat + Win10 + Mysql + PowerDesigner + Adobe Photoshop CC (64 Bit) 

**三、框架：**

	Struts2 + Hibernate + Spring

**四、其他技术：**

	Java + Jsp + Js + CSS + Html + Ajax

**五、数据库设计**

	学校表：school的主键shid作为班级表：clas的外键
	班级表：clas的主键cid作为学生表：student的外键

**六、项目功能：**

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

![查询学校](https://github.com/TaroYoVen/SMSystem/raw/master/image/school.jpg)

![查询班级](https://github.com/TaroYoVen/SMSystem/raw/master/image/class.jpg)

![查询学生](https://github.com/TaroYoVen/SMSystem/raw/master/image/student.jpg)

----------
学校管理

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/schoolSelect.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/schoolAdd.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/schoolEdit.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/schoolError.jpg)

----------
班级管理

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/classSelect.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/classAdd.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/classEdit.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/classError.jpg)

----------
学生管理

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/studentSelect.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/studentAdd.jpg)

![](https://github.com/TaroYoVen/SMSystem/raw/master/image/studentEdit.jpg)

----------
