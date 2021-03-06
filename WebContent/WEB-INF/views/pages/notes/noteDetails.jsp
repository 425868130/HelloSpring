<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>笔记详情页</title>
</head>
<body>
	<a href="home">返回首页</a>
	<form action="noteDetails">
		<h1>Spring学习笔记1——基础知识</h1>
		<hr>
		<span>
			1.在Java开发领域，spring相对于EJB来说是一种轻量级的，非侵入性的Java开发框架，曾经有两本很畅销的书《Expert
			one-on-one J2EE Design and Development》和《Expert one-on-one
			J2EEdevelopment without EJB》是java高手进阶必看的宝典，Spring就是从这两本书的理论发展起来的。
			Spring主要核心是：
			(1).控制反转(IOC)：以前传统的java开发模式中，当需要一个对象时我们，我们会自己使用new或者getInstance等直接或者间接调用构造方法创建一个对象，而在Spring开发模式中，Spring容器使用了工厂模式为我们创建了所需要的对象，我们使用时不需要自己去创建，直接调用Spring为我们提供的对象即可，这就是控制反转的思想。实例化一个java对象有三种方式：使用类构造器，使用静态工厂方法，使用实例工厂方法，当使用spring时我们就不需要关心通过何种方式实例化一个对象，spring通过控制反转机制自动为我们实例化一个对象。
			(2).依赖注入(DI)：Spring使用Java
			Bean对象的Set方法或者带参数的构造方法为我们在创建所需对象时将其属性自动设置所需要的值的过程就是依赖注入的基本思想。
			(3).面向切面编程(AOP)：在面向对象编程(OOP)思想中，我们将事物纵向抽象成一个个的对象。而在面向切面编程中，我们将一个个对象某些类似的方面横向抽象成一个切面，对这个切面进行一些如权限验证，事物管理，记录日志等公用操作处理的过程就是面向切面编程的思想。
			2.在Spring中，所有管理的对象都是JavaBean对象，而BeanFactory和ApplicationContext就是spring框架的两个IOC容器，现在一般使用ApplicationnContext，其不但包含了BeanFactory的作用，同时还进行更多的扩展。
			....... </span>
		<hr>
		<input type="submit" value="编辑">&nbsp;<input type="reset" value="取消" style="display: none">
	</form>
</body>
</html>