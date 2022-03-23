package com.ffaikrw.memo.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffaikrw.memo.post.bo.PostBO;
import com.ffaikrw.memo.post.model.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	
	// 메모 작성 View
	@GetMapping("/create_view")
	public String createView() {
		return "post/create";
	}
	
	
	// 메모리스트 View
	@GetMapping("/list_view")
	public String listView(
			HttpServletRequest request
			, Model model
			) {
		
		HttpSession session = request.getSession();
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> postList = postBO.getPostList(userId);
		
		model.addAttribute("postList", postList);
		
		return "post/list";
	}
	
	
	// 메모 상세 보기 View
	@GetMapping("/detail_view")
	public String detailView(@RequestParam("id") int id, Model model) {
		
		Post post = postBO.getPost(id);
		
		model.addAttribute("post", post);
		
		return "post/detail";
	}
	
}
