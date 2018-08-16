package syj.attachment.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import syj.attachment.model.AttachmentVo;
import syj.attachment.service.AttachmentServiceInf;

@RequestMapping("/attach")
@Controller
public class AttachmentController {
	
	@Resource(name="attachmentService")
	private AttachmentServiceInf attachmentService;
	
	
	//첨부파일삭제
	@RequestMapping(value="/deleteAttach", method=RequestMethod.GET)
	public String deleteAttach(AttachmentVo attachmentVo){
		attachmentService.deleteAttachment(attachmentVo.getAttach_no());
		return "redirect:/article/articleDetail?article_no="+attachmentVo.getArticle_no();
	}

	
	//첨부파일 다운로드
	@RequestMapping(value="/fileDownload", method=RequestMethod.GET)
	public String fileDown(@RequestParam("attach_name") String fileName, 
						   Model model){
		
		model.addAttribute("attach_name", fileName);
		return "fileDownloadView";
	}
	
	
	
	

}
