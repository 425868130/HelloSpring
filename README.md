# HelloSpring
## 项目简介
本项目是一个简单的spring的教程网站，主要实现了简单的教程文章管理，包括文章的创建、主题创建管理、个人信息管理、浏览与留言等简单功能。

* 技术关键词:  
Spring MVC、JdbcTemplate、Bootstrap、JQuery、Ajax、Maven

## 部署说明
* 环境需求：Tomcat8.0、JDK.18、MySQL5.7、IntelliJ IDEA  

* 属性配置文件路径:
数据库脚本文件：src/main/resources/HelloSpring-mysql.sql  
Spring配置：src/main/java/hellospring/config/WebConfig.java  
本项目完全使用Spring的Java类配置方式,WebConfig.java包含了全部的配置，包括数据库和各种Bean的配置。  

* 注意事项：
在Idea中导入项目后,为项目添加Tomcat运行环境配置，在设置打包文件时请将Application Context路径指定为"/HelloSpring"（如下图），访问项目时在端口号后也加上"/HelloSpring"，原因是页面中对静态资源的访问使用了项目名称作为路径前缀。  
![setting][setting]


## 界面预览
登录  
![登录][1]  
首页  
![首页][2]  
教程浏览  
![教程浏览][3]  
个人中心  
![个人中心][4]  
教程管理  
![教程管理][5]  
教程修改  
![教程修改][6]  


修改时间：2017-11-10 15:28:18

[setting]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/deployment.png
[1]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/login.png?x-oss-process=style/pic-70-peaktop
[2]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/index.png?x-oss-process=style/pic-70-peaktop
[3]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/article.png?x-oss-process=style/pic-70-peaktop
[4]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/userZone.png?x-oss-process=style/pic-70-peaktop
[5]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/articleManage.png?x-oss-process=style/pic-70-peaktop
[6]:http://my-dist.oss-cn-hangzhou.aliyuncs.com/java/HelloSpring/Edit.png?x-oss-process=style/pic-70-peaktop