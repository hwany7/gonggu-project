package service.inter;

import java.util.List;
import java.util.Map;

import dto.join.HitPostDto;

public interface PostService {
	
	public List<HitPostDto> getMainPost();
	public Map<String, Object> getPostList(String pageNum, String search, int category_id);
	public Map<String, Object> getPost(int post_id);
	public int addPostApply(int member_id, int post_id, int amount);
	

}
