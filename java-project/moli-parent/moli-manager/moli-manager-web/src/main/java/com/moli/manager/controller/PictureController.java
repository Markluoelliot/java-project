package com.moli.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moli.common.pojo.PictureResult;
import com.moli.manager.utils.FileUploadWriter;

@Controller
public class PictureController {
    @Autowired
	FileUploadWriter uploader;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PictureResult uploadPicture(MultipartFile uploadFile) {
        String destPath = "C:/Study/java/moli-parent/moli-manager/moli-manager-web/src/main/webapp/img";	
		String originalFileName = uploadFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		PictureResult pictureResult = new PictureResult();
		try {
			String url = uploader.writeToStore(destPath, extName, uploadFile.getBytes());
			pictureResult.setError(0);;
			pictureResult.setUrl(url);;
			return pictureResult;
		}catch(Exception e){
			pictureResult.setError(11);;
			pictureResult.setMessage("服务器正忙");
			e.printStackTrace();
			return pictureResult;
		}
		
        
       
		
	}
}
