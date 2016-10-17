package com.niit.backend.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
public static void uploadImage(String path, MultipartFile file, String myFile) {
		
		/*To check whether file path exist or not if not create it*/
		if (!Files.exists(Paths.get(path))) {
			try {
				Files.createDirectories(Paths.get(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*Now transfer the image to it destination*/
		try{
			file.transferTo(new File(path+myFile+".jpeg"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
