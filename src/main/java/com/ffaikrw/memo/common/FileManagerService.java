package com.ffaikrw.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	private String FILE_UPLOAD_PATH = "D:\\정혜원\\SpringProject\\memo\\upload\\images/";
	
	
	// 파일 저장 후 접근 경로 리턴
	public String saveFile(int userId, MultipartFile file) {
		
		// 1. 파일 경로
		// 파일 이름이 겹치는 것을 방지하기 위해 사용자 별로 폴더 구분
		// 같은 사용자가 같은 파일명을 올려 겹치는 것을 방지하기 위해 현재 시간을 폴더 이름에 포함시킴
		// UNIX time: 1970년 1월 1일 0시 0분 0초 기준으로 현재 몇 millisecond(1/1000초)가 지났는지 세는 시간
		// /images/6_3249171624.../asdf.jpg
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		// ex) D:\\정혜원\\SpringProject\\memo\\upload\\images/6_3249171624.../asdf.jpg
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		
		// 2. 디렉토리 생성
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 디렉토리 생성 에러
			return null;
		}
		
		// 3. 파일 저장
		try {
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
			
		}
		
		
		// <img src="/images/6_3298237523.../test.jpg">
		return "/images/" + directoryName + file.getOriginalFilename();

	}
	
}
