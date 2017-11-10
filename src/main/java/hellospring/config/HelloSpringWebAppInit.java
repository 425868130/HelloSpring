package hellospring.config;
/**
 * 配置DispatcherServlet
 */
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloSpringWebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	/*指定ContextLoadListener的配置类*/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}
	
	/*指定配置类*/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { WebConfig.class };
	}
	
	/*将DispatcherServlet映射到"/" */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
}
