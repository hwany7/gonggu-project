package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.inter.MemberDao;

@Controller
public class SignUpHandler {
	
	//스프링 빈 객체 할당
	@Resource(name="memberDaoImpl")
	MemberDao memberDao;
	
	//회원가입 폼으로 이동
	@RequestMapping("/signUpForm.do")
	public String signUp() {
		
		return "user/signup/signUpForm";
	}
	
	//이메일 중복 검사
	@RequestMapping("/checkEmail.do")
	public ModelAndView checkEmail(String member_email) {

		ModelAndView mav = new ModelAndView("user/common/ajaxResult");
		
		//이메일 중복 체크
		int result = memberDao.checkEmail(member_email);
		
		//결과 반환
		mav.addObject("result", result);
	
		return mav;
	}
	
	//닉네임 중복 체크
	@RequestMapping("/checkNickname.do")
	public ModelAndView checkNickname(String nickname) {
		
		ModelAndView mav = new ModelAndView("user/common/ajaxResult");
			
	    //닉네임 검사
	    int result = memberDao.checkNickname(nickname);
	   	    
	    //결과 셋팅
	    mav.addObject("result", result);

	    //결과 반환
	    return mav;
	}
	
}
