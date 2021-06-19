package handler.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.inter.MemberDao;

@Controller
public class SignUpHandler {
	
	//스프링 빈 객체 할당
	@Resource(name="memberDao")
	MemberDao memberDao;
	
	//회원가입 폼으로 이동
	@RequestMapping("/signUpForm.do")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("user/signup/signUpForm");
	}
	
	//이메일 중복 검사
	@RequestMapping("/checkEmail.do")
	public ModelAndView checkEmail(HttpServletRequest request, HttpServletResponse response) {
			
		//파라미터 받기
		String member_email = request.getParameter("member_email");
		
		//이메일 중복 체크
		int result = memberDao.checkEmail(member_email);
		
		//결과셋팅
		request.setAttribute("result", result);
			
		return new ModelAndView("user/signup/checkEmail");
	}
	
	//닉네임 중복 체크
	@RequestMapping("/checkNickname.do")
	public ModelAndView checkNickname(HttpServletRequest request, HttpServletResponse response) {
		
		//파라미터 받기
		String nickname = request.getParameter("nickname");
		
	    //닉네임 검사
	    int result = memberDao.checkNickname(nickname);
	   	    
	    //결과 셋팅
	    request.setAttribute("result", result);
	    
	    //결과 반환	
	    return new ModelAndView("user/signup/checkNickname");
	}
	
}
