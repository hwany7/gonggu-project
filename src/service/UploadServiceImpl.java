package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.inter.UploadService;
import util.UploadPath;

@Service
public class UploadServiceImpl implements UploadService{
	
	@Resource
	UploadPath uploadPath;
	
	//ckEdit4 이미지 파일 서버로 업로드
	@Override
	public void fileupload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		MultipartRequest multi = null;
		PrintWriter printWriter = null;
		
		String imagePath = uploadPath.getEditorImagePath();
		String imageCallPath = uploadPath.getEditorImageCallPath();
		
		try {
			
			multi = new MultipartRequest(request, imagePath, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
			
			String imgName = multi.getFilesystemName("upload");	
			String url = imageCallPath + imgName;
			
			printWriter = response.getWriter();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("uploaded", "1");
			map.put("fileName", imgName);
			map.put("url", url);
			
			JSONObject json = new JSONObject(map);
			printWriter.println(json);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	

}
