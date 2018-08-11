package syj.login.dao;

import syj.login.model.MemberVo;

public interface LoginDaoInf {
	
	int checkMember(MemberVo memberVo);
	
	int joinMember(MemberVo memberVo);

}
