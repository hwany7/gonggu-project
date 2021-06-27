package dao.inter;

import java.util.List;

import dto.join.HitPostDto;
import dto.join.PostContentDto;

public interface PostDao {
	
	//메인 페이지
	public List<HitPostDto> getHitPostFromMain();
	
	//포스트 페이지
	public PostContentDto getPostContentFromContent(int post_id);
	
}
