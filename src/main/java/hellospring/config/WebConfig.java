package hellospring.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 * 
 * @author Dream Sky 配置类
 */

import com.google.gson.Gson;

@Configuration
@EnableWebMvc
/* 通过标志接口配置自动扫描基础包 */
@ComponentScan(basePackageClasses = { hellospring.config.ScanMark.class, hellospring.controller.ScanMark.class,
		hellospring.model.ScanMark.class, hellospring.service.implement.ScanMark.class,
		hellospring.dao.implement.ScanMark.class })
public class WebConfig extends WebMvcConfigurerAdapter {

	/* 配置静态资源的处理 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/* 配置JSP视图解析器 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/* 视图路径前缀 */
		resolver.setPrefix("/WEB-INF/views/pages/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	/*
	 * 配置数据源
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		/*
		 * 添加?characterEncoding=utf8&useSSL=false 可以防止出现错误：WARN: Establishing
		 * SSL connection without server's identity verification is not
		 * recommended
		 */
		ds.setUrl("jdbc:mysql://localhost/hellospring?characterEncoding=utf8&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("1320074071");
		return ds;
	}

	/*
	 * 配置JDBC模板
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
	}

	/* 获取 JSON 转换工具 */
	@Bean
	public Gson getGson() {
		return new Gson();
	}
}
