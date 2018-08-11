package syj.login.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import syj.login.model.MemberVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:syj/config/spring/root-context.xml",
								"classpath:syj/config/spring/servlet-context.xml",
								"classpath:syj/config/spring/datasource_dev.xml",
								"classpath:syj/config/spring/transaction.xml"})
public class LoginServiceTest {
	
	@Resource(name="loginService")
	private LoginServiceInf loginService;
	
	
	@Before
	public void setup(){
		//populator : 스프링에서 제공
		//datasource(db연결정보), 초기화 스크립트
		
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("springtest");
		datasource.setPassword("java");
		
		//초기화 스크립트 (init.sql)
		
		//populator 생성
		ResourceDatabasePopulator populaotor = new ResourceDatabasePopulator();
		populaotor.addScript(new ClassPathResource("syj/config/db/init.sql"));
		
		DatabasePopulatorUtils.execute(populaotor, datasource);
	}

	/**
	* Method : checkMemberTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 로그인 시 회원 정보 여부
	*/
	@Test
	public void checkMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		String id = "syjun88";
		String pw = "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4";
		memberVo.setMem_id(id);
		memberVo.setMem_pw(pw);

		/***When***/
		int checkResult = loginService.checkMember(memberVo);

		/***Then***/
		assertEquals(1, checkResult);
	}
	
	
	/**
	* Method : joinMemberTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 회원가입
	*/
	@Test
	public void joinMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		String mem_id 	 = "s001";
		String mem_name  = "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4";
		String mem_pw 	 = "1234";
		String mem_email ="seo@naver.com";
		String mem_tel 	 = "010-1234-2222";
		String mem_addr1 ="대전";
		String mem_addr2 = "서구 월평동";
		
		memberVo.setMem_id(mem_id);
		memberVo.setMem_name(mem_name);
		memberVo.setMem_pw(mem_pw);
		memberVo.setMem_email(mem_email);
		memberVo.setMem_tel(mem_tel);
		memberVo.setMem_addr1(mem_addr1);
		memberVo.setMem_addr2(mem_addr2);

		/***When***/
		int joinResult = loginService.joinMember(memberVo);

		/***Then***/
		assertEquals(1, joinResult);		
	}

}
