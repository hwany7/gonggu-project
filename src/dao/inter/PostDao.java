package dao.inter;

import java.util.List;

import dto.join.HitPostDto;

public interface PostDao {
	
	//메인페이지
	public List<HitPostDto> getHitPostFromMain();
}
