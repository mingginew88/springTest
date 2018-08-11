package syj.article.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import syj.article.dao.ArticleDaoInf;
import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;

@Service("articleService")
public class ArticleService implements ArticleServiceInf {
	
	@Resource(name="articleDao")
	private ArticleDaoInf articleDao;
	
	
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
		return articleDao.getArticleInfo(article_no);
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
		return articleDao.addAttachment(attachmentVo);
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
		return articleDao.addArticle(articleVo);
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
		return articleDao.deleteArticle(article_no);
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
		return articleDao.updateArticle(articleVo);
	}


	/**
	* Method : addReArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 해당 게시글의 답글 작성
	*/
	@Override
	public int addReArticle(ArticleVo articleVo) {
		return articleDao.addReArticle(articleVo);
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
		return articleDao.addAttachFromUpdate(attachmentVo);
	}

}
