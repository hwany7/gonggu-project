package controller.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.inter.UploadService;

@Controller
public class UploadController {

	private final UploadService uploadService;
	
	@Autowired
	public UploadController(UploadService uploadService) {
		
		this.uploadService = uploadService;
	}
	
	
	//ckEdict4 이미지 서버 업로드
	@RequestMapping("/upload/image/ckedit")
	public void uploadEditImage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		uploadService.fileupload(request, response);
	}
}
