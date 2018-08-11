package syj.login.service;

import org.springframework.stereotype.Service;

import syj.login.model.MemberVo;

@Service("loginService")
public class LoginService implements LoginServiceInf {

	
	@Override
	public int checkMember(MemberVo memberVo) {
		return 0;
	}

	@Override
	public int joinMember(MemberVo memberVo) {
		return 0;
	}

}
