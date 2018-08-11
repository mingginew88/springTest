package syj.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

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

import syj.reply.model.ReplyVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:syj/config/spring/root-context.xml",
								"classpath:syj/config/spring/servlet-context.xml",
								"classpath:syj/config/spring/datasource_dev.xml",
								"classpath:syj/config/spring/transaction.xml"})
public class ReplyDaoTest {
	
	@Resource(name="replyDao")
	private ReplyDaoInf replyDao;
	
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
	* Method : addReplyTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당게시글에 댓글 추가
	*/
	@Test
	public void addReplyTest() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply_writer("syjun88");
		replyVo.setReply_content("123");
		replyVo.setArticle_no(1);
		replyVo.setMem_id("syjun88");
		replyVo.setReply_del_confirm("N");

		/***When***/
		int result = replyDao.addReply(replyVo);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : getAllReplyOfArticleNoTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당 게시글에 모든 댓글
	*/
	@Test
	public void getAllReplyOfArticleNoTest() {
		/***Given***/
		int article_no = 1;
		
		/***When***/
		List<ReplyVo> replyList = replyDao.getAllReplyOfArticleNo(article_no);
		
		/***Then***/
		assertEquals(2, replyList.size());
	}
	
	
	/**
	* Method : deleteReplyTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 댓글을 삭제한다. 하지만 실제로 삭제하지않고 삭제여부를 N -> Y로 업데이트한다.
	*/
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int reply_no = 1;

		/***When***/
		int result = replyDao.deleteReply(reply_no);

		/***Then***/
		assertEquals(1, result);
	}

}
