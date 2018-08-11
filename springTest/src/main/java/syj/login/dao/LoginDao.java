package syj.login.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import syj.login.model.MemberVo;

public class LoginDao implements LoginDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public int checkMember(MemberVo memberVo) {
		int checkMember = template.selectOne("member.checkMember", memberVo);
		
		return checkMember;
	}

	@Override
	public int joinMember(MemberVo memberVo) {
		int joinMember = template.insert("member.joinMember", memberVo);
		return joinMember;
	}
	
	
	
	
	

}
