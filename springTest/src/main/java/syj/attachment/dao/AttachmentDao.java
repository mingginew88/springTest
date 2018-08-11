package syj.attachment.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import syj.attachment.model.AttachmentVo;


@Repository("attachmentDao")
public class AttachmentDao implements AttachmentDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	/**
	* Method : getAttachmentOfArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	@Override
	public List<AttachmentVo> getAttachmentOfArticle(int article_no) {
		List<AttachmentVo> attachmentList = template.selectList("attachment.getAttachmentOfArticle", article_no);
		return attachmentList;
	}

	
	/**
	* Method : deleteAttachment
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	@Override
	public int deleteAttachment(int article_no) {
		int deleteResult = template.delete("attachment.deleteAttachment", article_no);
		return deleteResult;
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
	@Override
	public AttachmentVo getAttachment(int attach_no) {
		AttachmentVo attachmentVo = template.selectOne("attachment.getAttachment", attach_no);
		return attachmentVo;
	}

}
