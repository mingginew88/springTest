package syj.article.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;

@Repository("articleDao")
public class ArticleDao implements ArticleDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	

	/**
	* Method : getArticleInfo
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글 번호의 상세정보 조회
	*/
	@Override
	public ArticleVo getArticleInfo(int article_no) {
		ArticleVo articleVo = template.selectOne("article.getArticleInfo", article_no);
		return articleVo;
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
	@Override
	public int addAttachment(AttachmentVo attachmentVo) {
		int addResult = template.insert("article.addAttachment", attachmentVo);
		return addResult;
	}


	/**
	* Method : addArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	@Override
	public int addArticle(ArticleVo articleVo) {
		int addResult = template.insert("article.addArticle", articleVo);
		return addResult;
	}


	/**
	* Method : deleteArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 게시글 삭제 ( 실제로는 삭제여부  N -> Y 로 업데이트 )
	*/
	@Override
	public int deleteArticle(int article_no) {
		int updateResult = template.update("article.deleteArticle", article_no);
		return updateResult;
	}

	
	/**
	* Method : updateArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updateArticle(ArticleVo articleVo) {
		int updateResult = template.update("article.updateArticle", articleVo);
		return updateResult;
	}


	/**
	* Method : addReArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 답글 추가
	*/
	@Override
	public int addReArticle(ArticleVo articleVo) {
		int addResult = template.insert("article.addReArticle", articleVo);
		return addResult;
	}


	/**
	* Method : addAttachFromUpdate
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param attachmentVo
	* @return
	* Method 설명 : 게시글 수정을 통한 첨부파일추가 
	*/
	@Override
	public int addAttachFromUpdate(AttachmentVo attachmentVo) {
		int addResult = template.insert("article.addAttachFromUpdate", attachmentVo);
		return addResult;
	}
	
	
	
	
	

}
