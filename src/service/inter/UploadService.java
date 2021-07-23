package service.inter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UploadService {
	
	public void fileupload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
}
