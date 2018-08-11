package syj.login.service;

import javax.annotation.Resource;



import org.springframework.stereotype.Service;

import syj.login.dao.LoginDaoInf;
import syj.login.model.MemberVo;

@Service("loginService")
public class LoginService implements LoginServiceInf {
	
	@Resource(name="loginDao")
	private LoginDaoInf loginDao;

	
	/**
	* Method : checkMember
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param memberVo
	* @return 1(회원 존재) 0(회원 미존재)
	* Method 설명 : 로그인 시 회원 정보 여부
	*/
	@Override
	public int checkMember(MemberVo memberVo) {
		return loginDao.checkMember(memberVo);
	}

	
	/**
	* Method : joinMember
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param memberVo
	* @return 1(가입성공) 0(가입실패)
	* Method 설명 : 회원가입
	*/
	@Override
	public int joinMember(MemberVo memberVo) {
		return loginDao.joinMember(memberVo);
	}

}
