package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import util.UploadPath;

@Configuration
public class CreateBean {
	

	@Bean
	public ViewResolver viewResolver(){
		
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public UploadPath uploadPath() {
		
		UploadPath uploadPath = new UploadPath();
		
		uploadPath.setImagePath("C:\\ExpertJava\\imageBase\\image");
		uploadPath.setThumbImagePath("C:\\ExpertJava\\imageBase\\thumbnail");
		uploadPath.setEditorImagePath("C:\\ExpertJava\\imageBase\\editor");
		
		uploadPath.setImageCallPath( "/gonggu/imageBase/image/");
		uploadPath.setThumbImageCallPath("/gonggu/imageBase/thumbnail/");
		uploadPath.setEditorImageCallPath("/gonggu/imageBase/editor/");
		return uploadPath;
	}
	
}
