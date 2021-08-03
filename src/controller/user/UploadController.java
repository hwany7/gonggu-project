package controller.user;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.inter.UploadService;

@Controller
public class UploadController {

	@Resource
	private UploadService uploadService;
	
	//ckEdict4 이미지 서버 업로드
	@RequestMapping("/upload/image/ckedit")
	public void uploadEditImage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		uploadService.fileupload(request, response);
	}
}
