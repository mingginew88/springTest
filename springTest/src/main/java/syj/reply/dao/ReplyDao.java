package syj.reply.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import syj.reply.model.ReplyVo;

@Repository("replyDao")
public class ReplyDao implements ReplyDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	/**
	* Method : addReply
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param replyVo
	* @return
	* Method 설명 : 해당게시글에 댓글 추가
	*/
	@Override
	public int addReply(ReplyVo replyVo) {
		int addResult = template.insert("reply.addReply", replyVo);
		return addResult;
	}

	
	/**
	* Method : getAllReplyOfArticleNo
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글에 모든 댓글
	*/
	@Override
	public List<ReplyVo> getAllReplyOfArticleNo(int article_no) {
		List<ReplyVo> replyList = template.selectList("reply.getAllReplyOfArticleNo", article_no);
		return replyList;
	}


	/**
	* Method : deleteReply
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : SEO
	* 변경이력 :
	* @param reply_no
	* @return 
	* Method 설명 : 댓글을 삭제한다. 하지만 실제로 삭제하지않고 삭제여부를 N -> Y로 업데이트한다.
	*/
	@Override
	public int deleteReply(int reply_no) {
		int deleteResult = template.update("reply.deleteReply", reply_no);
		return deleteResult;
	}

}
