package handler.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageHandler {
	
	@RequestMapping("/mainPage.do")
	public String mainPage() {
			
		//메인페이지로 가기(임시 페이지)
		return "user/main/mainPage";
	}

}
