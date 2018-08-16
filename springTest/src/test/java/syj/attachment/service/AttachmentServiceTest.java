package syj.attachment.service;

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

import syj.attachment.model.AttachmentVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:syj/config/spring/root-context.xml",
								"classpath:syj/config/spring/servlet-context.xml",
								"classpath:syj/config/spring/datasource_dev.xml",
								"classpath:syj/config/spring/transaction.xml"})
public class AttachmentServiceTest {
	
	@Resource(name="attachmentService")
	private AttachmentServiceInf attachmentService;
	
	@Before
	public void setup(){
		//populator : 스프링에서 제공
		//datasource(db연결정보), 초기화 스크립트
		
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		datasource.setUsername("springtest");
		datasource.setPassword("java");
		
		//초기화 스크립트 (init.sql)
		
		//populator 생성
		ResourceDatabasePopulator populaotor = new ResourceDatabasePopulator();
		populaotor.addScript(new ClassPathResource("syj/config/db/init.sql"));
		
		DatabasePopulatorUtils.execute(populaotor, datasource);
	}

	/**
	* Method : getAttachmentOfArticleTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	@Test
	public void getAttachmentOfArticleTest() {
		/***Given***/
		int article_no = 1;
		/***When***/
		List<AttachmentVo> attachmentList = attachmentService.getAttachmentOfArticle(article_no);

		/***Then***/
		assertEquals(1, attachmentList.size());
	}

	
	/**
	* Method : deleteAttachmentTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 첨부파일 삭제
	*/
	@Test
	public void deleteAttachmentTest() {
		/***Given***/
		int attach_no = 4;
		
		/***When***/
		int result = attachmentService.deleteAttachment(attach_no);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : getAttachment
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param attach_no
	* @return
	* Method 설명 : 해당 첨부파일 조회
	*/
	@Test
	public void getAttachmentTest() {
		/***Given***/
		int attach_no = 4;

		/***When***/
		AttachmentVo attachmentVo = attachmentService.getAttachment(attach_no);
		
		/***Then***/
		assertEquals("sally.png", attachmentVo.getAttach_upload_name());
	}

}
