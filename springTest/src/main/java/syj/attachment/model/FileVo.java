package syj.attachment.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileVo {
	
	private List<MultipartFile> uploadFile;

	
	public List<MultipartFile> getFiles() {
		return uploadFile;
	}
	public void setFiles(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	

}
