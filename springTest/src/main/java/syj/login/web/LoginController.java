package syj.login.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import syj.login.model.MemberVo;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/view")
	public String login(Model model){
		return "login/login";
	}

	
	@RequestMapping("/loginProcess")
	public String loginProcess(MemberVo memberVo){
		
		//logger : userId, password
		logger.debug("{}", memberVo.getMem_id() + " : " + memberVo.getMem_pw());
		
		//TODO : id 비번 맞는지 여부 확인후 리턴 해주기
		
		//정상접속완료
		return "main";
	}
	

}
