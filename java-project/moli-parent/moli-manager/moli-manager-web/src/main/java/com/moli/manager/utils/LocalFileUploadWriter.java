package com.moli.manager.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;


@Component
public class LocalFileUploadWriter implements FileUploadWriter {

	@Override
	public String writeToStore(String dest, String ext, byte[] data) throws Exception {
		// TODO Auto-generated method stub
		String picServerHost ="http://localhost:8080";
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDate = sf.format(date);
		//存储目录
		
		String storePath = dest;
		//生成文件名
		
		UUID randomUUID = UUID.randomUUID();
		String storeName = formatedDate+randomUUID+"."+ext;
		//将字节写入存储文件中
		//先将字节码包装成输入流
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		//构造存储文件输出流
		FileOutputStream os =new FileOutputStream(storePath+"/"+storeName);
		
		//将输入流中的数据写入输出流
		IOUtils.copy(in,os);
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(os);
		
		//访问URL
		String url = picServerHost+"/img/"+storeName;
		return url;
		
	}

}
