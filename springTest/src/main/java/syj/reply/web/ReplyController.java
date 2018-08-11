package syj.reply.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import syj.reply.model.ReplyVo;
import syj.reply.service.ReplyServiceInf;

@SessionAttributes("sessionId")
@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	@Resource(name="replyService")
	private ReplyServiceInf replyService;
	
	//댓글 삭제
	@RequestMapping(value="/deleteReply", method=RequestMethod.GET)
	public String deleteReply(@RequestParam(value="article_no") int article_no,
							  @RequestParam("reply_no") int reply_no){
		
		replyService.deleteReply(reply_no);
		return "redirect:/article/articleDetail?article_no="+article_no;
	}
	
	
	//댓글 등록
	@RequestMapping(value="/addReply", method=RequestMethod.GET)
	public String addReply(@RequestParam(value="article_no") int article_no,
										 @RequestParam(value="reply_content") String reply_content,
										 HttpSession session){
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setArticle_no(article_no);
		replyVo.setMem_id(sessionId);
		replyVo.setReply_writer(sessionId);
		replyVo.setReply_content(reply_content);
		replyVo.setReply_del_confirm("N");
		
		replyService.addReply(replyVo);
		return "redirect:/article/articleDetail?article_no="+article_no;
	}
	
	
	
	
	

}
