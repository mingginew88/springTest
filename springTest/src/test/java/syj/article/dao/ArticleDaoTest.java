package syj.article.dao;

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

import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:syj/config/spring/root-context.xml",
								"classpath:syj/config/spring/servlet-context.xml",
								"classpath:syj/config/spring/datasource_dev.xml",
								"classpath:syj/config/spring/transaction.xml"})
public class ArticleDaoTest {
	
	@Resource(name="articleDao")
	private ArticleDaoInf articleDao;
	
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
	* Method : getArticleInfoTest
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 해당 게시글 정보 조회
	*/
	@Test
	public void getArticleInfoTest() {
		/***Given***/
		int article_no = 1;

		/***When***/
		ArticleVo articleVo = articleDao.getArticleInfo(article_no);
		
		/***Then***/
		assertEquals("123", articleVo.getArticle_title());
	}
	
	
	/**
	* Method : addAttachment
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param attachmentVo
	* @return
	* Method 설명 : 해당게시글 첨부파일 추가
	*/
	@Test
	public void addAttachment() {
		//TODO 
		/***Given***/
		AttachmentVo attachmentVo = new AttachmentVo();
		attachmentVo.setArticle_no(1);
		attachmentVo.setAttach_name("sally.png");
		attachmentVo.setAttach_path("");
		attachmentVo.setAttach_upload_name("sally.png");

		/***When***/
		int result = articleDao.addAttachment(attachmentVo);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : addArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	@Test
	public void addArticle() {
		/***Given***/
		ArticleVo articleVo = new ArticleVo();
		articleVo.setArticle_gno(1);
		articleVo.setArticle_title("123");
		articleVo.setArticle_writer("syjun88");
		articleVo.setArticle_content("123123");
		articleVo.setArticle_del_confirm("N");
		articleVo.setBoard_no(1);
		articleVo.setMem_id("syjun88");

		/***When***/
		int result = articleDao.addArticle(articleVo);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : deleteArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 게시글 삭제 ( 실제로는 삭제여부  N -> Y 로 업데이트 )
	*/
	@Test
	public void deleteArticle() {
		/***Given***/
		int article_no = 2;
		
		/***When***/
		int result = articleDao.deleteArticle(article_no);

		/***Then***/
		assertEquals(1, result);

	}
	
	
	/**
	* Method : updateArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Test
	public void updateArticle() {
		/***Given***/
		ArticleVo articleVo = new ArticleVo();
		articleVo.setArticle_title("111");
		articleVo.setArticle_content("123");
		articleVo.setArticle_no(1);
		
		/***When***/
		int result = articleDao.updateArticle(articleVo);

		/***Then***/
		assertEquals(1, result);
	}

}
