package com.ffaikrw.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	// utils 메소드 중 멤버변수의 사용이 별로 없는 메소드는 일반적으로 static 메소드
	
	// 멤버변수로 설정
	// final을 붙여주면 변수형태로 이 변수의 값을 변경시킬 수 없음
	public final static String FILE_UPLOAD_PATH = "D:\\정혜원\\SpringProject\\memo\\upload\\images/";
	
	// 로그 쌓는 방법
	private static Logger logger = LoggerFactory.getLogger(FileManagerService.class);
	
	// 파일 저장 후 접근 경로 리턴
	public static String saveFile(int userId, MultipartFile file) {
		
		// 파일을 올리지 않았을 때 null을 리턴하도록 함
		if (file == null) {
			
			logger.error("FileManagerService-saveFile : 파일 없음");
			
			return null;
		}
		
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
			logger.error("FileManagerService-saveFile : 디렉토리 생성 에러");
			return null;
		}
		
		// 3. 파일 저장
		try {
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			logger.error("FileManagerService-saveFile : 파일 저장 에러");
			return null;
			
		}
		
		
		// <img src="/images/6_3298237523.../test.jpg">
		return "/images/" + directoryName + file.getOriginalFilename();

	}
	
}
