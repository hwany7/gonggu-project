package service.inter;

import java.util.List;

import dto.join.HitPostDto;
import dto.join.ReviewContentDto;
import util.PageInfo;

public interface PageService {

	public PageInfo process(int count, String pageNum);
	public List<HitPostDto> preprocessingFromPostList(List<HitPostDto> postList);
	public List<ReviewContentDto> preprocessingFromReviewList(List<ReviewContentDto> reviewContentDtos);
	
}
