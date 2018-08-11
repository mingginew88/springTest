package syj.login.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import syj.encrypt.kisa.sha256.KISA_SHA256;
import syj.login.model.MemberVo;
import syj.login.service.LoginServiceInf;

@SessionAttributes("sessionId")
@RequestMapping("/login")
@Controller
public class LoginController {
	
//	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="loginService")
	private LoginServiceInf loginService;
	
	
	//로그인 화면 이동
	@RequestMapping("/view")
	public String login(Model model){
		return "login/login2";
	}

	
	//로그인 처리
	@RequestMapping("/loginProcess")
	public String loginProcess(@RequestParam(value="loginId") 		String loginId,
							   @RequestParam(value="loginPassword") String loginPassword,
							   Model model){
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_id(loginId);
		String mem_pw = KISA_SHA256.encrypt(loginPassword);
		memberVo.setMem_pw(mem_pw);
		
		int loginResult = loginService.checkMember(memberVo);
		
		if(loginResult == 1) {
			model.addAttribute("sessionId", loginId);
			return "/main/main";
		}
		
		return "login/login2";
	}
	
	
	//회원가입 화면
	@RequestMapping("/join")
	public String join(){
		return "login/join";
	}
	
	
	//TODO : 회원가입 시 데이터 넘겨받아서 데이터 저장하기
	//회원가입 처리
	@RequestMapping("/joinProcess")
	public String joinProcess(){
		return "login/login2";
	}
	
	
	//메인화면에서 로그아웃
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		status.setComplete();			//session 정리
		return "login/login2";
	}
	
	
	//메인화면
	@RequestMapping("main")
	public String main(){
		return "main/main";
	}
	
	
	

}
