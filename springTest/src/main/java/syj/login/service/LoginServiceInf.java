package syj.login.service;

import syj.login.model.MemberVo;

public interface LoginServiceInf {
	
	int checkMember(MemberVo memberVo);
		
	int joinMember(MemberVo memberVo);

}
