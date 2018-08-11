package syj.attachment.web;


import javax.annotation.Resource;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import syj.article.model.ArticleVo;
import syj.attachment.service.AttachmentServiceInf;

@RequestMapping("/attach")
@Controller
public class AttachmentController {
	
	@Resource(name="attachmentService")
	private AttachmentServiceInf attachmentService;
	
	
	//첨부파일삭제
	@RequestMapping(value="/deleteAttach", method=RequestMethod.GET)
	public String deleteAttach(ArticleVo articleVo){
		attachmentService.deleteAttachment(articleVo.getArticle_no());
		return "redirect:/article/articleDetail?article_no="+articleVo.getArticle_no();
	}
	//TODO : 다시 데이터 보내는거 확인작업하기
	
	
	//첨부파일 다운로드
	@RequestMapping(value="/fileDownload", method=RequestMethod.GET)
	public String fileDown(@RequestParam("attach_name") String fileName, 
						   Model model){
		
		model.addAttribute("attach_name", fileName);
		return "fileDownloadView";
	}
	
	
	
	

}
