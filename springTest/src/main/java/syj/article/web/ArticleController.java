package syj.article.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import syj.article.model.ArticleVo;
import syj.article.service.ArticleServiceInf;
import syj.attachment.model.AttachmentVo;
import syj.attachment.model.FileVo;
import syj.attachment.service.AttachmentServiceInf;
import syj.reply.model.ReplyVo;
import syj.reply.service.ReplyServiceInf;
import syj.util.FileUtil;

@RequestMapping("/article")
@Controller
public class ArticleController {
	
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Resource(name="articleService")
	private ArticleServiceInf articleService;
	
	@Resource(name="replyService")
	private ReplyServiceInf replyService;
	
	@Resource(name="attachmentService")
	private AttachmentServiceInf attachmentService;
	
	//게시글 상세 조회
	@RequestMapping(value="/articleDetail", method=RequestMethod.GET)
	public String articleDetail(@RequestParam("article_no") int article_no,
								Model model){
		
		ArticleVo articleVo = articleService.getArticleInfo(article_no);
		List<ReplyVo> replyList = replyService.getAllReplyOfArticleNo(article_no);
		List<AttachmentVo> attachmentList = attachmentService.getAttachmentOfArticle(article_no);
		
		model.addAttribute("articleVo", articleVo);
		model.addAttribute("replyList", replyList);
		model.addAttribute("attachmentList", attachmentList);
		return "article/articleDetail";
	}
	
	
	//게시글 작성 화면 이동
	@RequestMapping(value="/addArticle", method=RequestMethod.GET)
	public String addArticle(@RequestParam(value="board_no") int board_no,
							 Model model){
		
		ArticleVo articleVo = new ArticleVo();
		articleVo.setBoard_no(board_no);
		
		model.addAttribute("articleVo", articleVo);
		return "article/addArticle";
	}
	
	
	//게시글 등록
	@RequestMapping(value="/addArticleResult", method=RequestMethod.POST)
	public String addArticleResult(ArticleVo articleVo,
//								   @RequestParam("uploadFile") String uploadFile,
								   FileVo files,
								   HttpSession session){
		
		String article_writer = (String) session.getAttribute("sessionId");
		articleVo.setArticle_writer(article_writer);
		articleVo.setMem_id(article_writer);
		
		articleService.addArticle(articleVo);
		
		
		//첨부파일 등록
		for (MultipartFile f : files.getFiles()) {
			String contentType = f.getContentType();
			if( contentType != null ){
				//fileSize가 정상적인 경우에만 업로드를 수행한다
				String attach_upload_name = f.getName();
				String attach_path = FileUtil.fileUploadPath;			
				String attach_name = UUID.randomUUID().toString();
				File file = new File(attach_path + File.separator + attach_name);
				
				try {
					f.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				AttachmentVo attachmentVo = new AttachmentVo();
				attachmentVo.setAttach_upload_name(attach_upload_name);
				attachmentVo.setAttach_path(attach_path);
				attachmentVo.setAttach_name(attach_name);
				articleService.addAttachment(attachmentVo);
			}
		}
		return "redirect:/board/showBoardList?board_no="+articleVo.getBoard_no();
	}
	

	
	
	//게시글 수정화면 이동
	@RequestMapping(value="/updateArticle", method=RequestMethod.GET)
	public String updateArticle(@RequestParam(value="article_no") int article_no,
							    @RequestParam(value="board_no") int board_no,
							    Model model){
		
		ArticleVo articleVo = articleService.getArticleInfo(article_no);
		model.addAttribute("articleVo", articleVo);
		return "/article/updateArticle";
	}
	
	
	//게시글 수정
	@RequestMapping(value="/updateArticleResult", method=RequestMethod.POST)
	public String updateArticleResult(ArticleVo articleVo,
									  @RequestParam(value="board_no") int board_no){
		
		articleService.updateArticle(articleVo);
		return "redirect:/board/showBoardList?board_no="+board_no;
	}
	
	
	//게시글 삭제
	@RequestMapping(value="/deleteArticle", method=RequestMethod.GET)
	public String deleteArticle(@RequestParam(value="article_no") int article_no,
							    @RequestParam(value="board_no") int board_no,
							    Model model){
		
		articleService.deleteArticle(article_no);
		
		model.addAttribute("board_no", board_no);
		return "redirect:/board/showBoardList?board_no="+board_no;
	}
	
	
	//답글 작성화면 이동
	@RequestMapping(value="/addArticle2", method=RequestMethod.GET)
	public String addArticle2(@RequestParam(value="board_no") int board_no,
							  @RequestParam(value="article_gno") int article_gno,
							  @RequestParam(value="article_no") int article_pno,
							  Model model){
		
		ArticleVo articleVo = new ArticleVo();
		articleVo.setBoard_no(board_no);
		articleVo.setArticle_gno(article_gno);
		articleVo.setArticle_pno(article_pno);
		
		model.addAttribute("articleVo", articleVo);
		return "/article/addArticle2";
	}
	
	
	//답글 등록
	@RequestMapping(value="/addArticle2Result", method=RequestMethod.POST)
	public String addArticle2Result(ArticleVo articleVo,
									HttpSession session){
		
		String article_writer = (String) session.getAttribute("sessionId");
		articleVo.setArticle_writer(article_writer);
		articleVo.setMem_id(article_writer);
		
		articleService.addReArticle(articleVo);
		return "redirect:/board/showBoardList?board_no="+articleVo.getBoard_no();
	}
	
	
	
	
	//TODO : 새글 답글 수정 에서 첨부파일 등록
	//TODO : 첨부파일 다운로드
	
	

	

}
