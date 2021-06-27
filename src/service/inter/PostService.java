package service.inter;

import java.util.List;

import dto.join.HitPostDto;
import dto.join.PostContentDto;

public interface PostService {
	
	public List<HitPostDto> getMainPost();
	public PostContentDto getPost(int post_id);

}
