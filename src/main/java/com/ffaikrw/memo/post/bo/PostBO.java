package com.ffaikrw.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ffaikrw.memo.common.FileManagerService;
import com.ffaikrw.memo.post.dao.PostDAO;
import com.ffaikrw.memo.post.model.Post;

@Service
public class PostBO {

	@Autowired
	private PostDAO postDAO;
	
	
	// 메모 입력
	public int addPost(int userId, String subject, String content, MultipartFile file) {
		
		// 파일 저장, 경로 생성
		String filePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, subject, content, filePath);
	}
	
	
	// 메모리스트
	public List<Post> getPostList(int userId) {
		return postDAO.selectPostList(userId);
	}
	
	
	// 메모 보기
	public Post getPost(int id) {
		return postDAO.selectPost(id);
	}
	
	
	// 메모 수정
	public int updatePost(int postId, String subject, String content) {
		return postDAO.updatePost(postId, subject, content);
	}
	
	
	// 메모 삭제
	public int deletePost(int postId, int userId) {
		
		Post post = this.getPost(postId); // 위의 '메모 보기' 메소드 호출
		
		// 파일 삭제
		FileManagerService.removeFile(post.getImagePath());
		
		return postDAO.deletePost(postId, userId);
	}
	
}
