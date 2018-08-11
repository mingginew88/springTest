package syj.attachment.web;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.springframework.web.servlet.View;

import syj.util.FileUtil;

public class FileDownloadView implements View{

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName = (String) model.get("attach_name");
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
		response.setContentType("application/octet-stream");
		
		//D:\A_TeachingMaterial\7.JspSrpgin\fileUpload\sally.png
		String file = FileUtil.fileUploadPath + File.separator + fileName;
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		
		byte[] b = new byte[512];
		int len = 0;
		while( (len = fis.read(b)) != -1 ) {
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
	}

}
