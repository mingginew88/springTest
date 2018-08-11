package syj.attachment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import syj.attachment.dao.AttachmentDaoInf;
import syj.attachment.model.AttachmentVo;

@Service("attachmentService")
public class AttachmentService implements AttachmentServiceInf {

	@Resource(name="attachmentDao")
	private AttachmentDaoInf attachmentDao;
	
	
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
		return attachmentDao.getAttachmentOfArticle(article_no);
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
		return attachmentDao.deleteAttachment(article_no);
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
		return attachmentDao.getAttachment(attach_no);
	}

}
