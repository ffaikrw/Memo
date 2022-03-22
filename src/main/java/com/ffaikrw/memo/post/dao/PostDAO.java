package com.ffaikrw.memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ffaikrw.memo.post.model.Post;

@Repository
public interface PostDAO {
	
	// 메모 입력
	public int insertPost(
			@Param("userId") int userId
			, @Param("subject") String subject
			, @Param("content") String content
			, @Param("filePath") String filePath
			);
	
	
	// 메모리스트
	public List<Post> selectPostList(@Param("userId") int userId);
	
	
	// 메모 보기
	public Post selectPost(@Param("id") int id);
	
}
