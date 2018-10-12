package com.moli.manager.utils;

public interface FileUploadWriter {
	
	String writeToStore(String dest,String ext, byte[] data) throws Exception;

}
