package syj.login.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import syj.login.model.MemberVo;

@Repository("loginDao")
public class LoginDao implements LoginDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
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
		int checkMember = template.selectOne("member.checkMember", memberVo);
		return checkMember;
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
		int joinMember = template.insert("member.joinMember", memberVo);
		return joinMember;
	}
	
	
	
	
	

}
