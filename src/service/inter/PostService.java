package service.inter;

import java.util.List;
import java.util.Map;

import dto.join.HitPostDto;
import dto.join.PostContentDto;

public interface PostService {
	
	public List<HitPostDto> getMainPost();
	public PostContentDto getPost(int post_id);
	public Map<String, Integer> addPostApply(int member_id, int post_id, int amount);

}
