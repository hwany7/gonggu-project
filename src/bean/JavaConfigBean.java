package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import util.UploadPath;

@Configuration
public class JavaConfigBean {
	
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
