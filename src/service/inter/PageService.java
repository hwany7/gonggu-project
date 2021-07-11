package service.inter;

import java.util.List;

import dto.join.PostContentDto;
import dto.join.ReviewContentDto;
import util.PageInfo;

public interface PageService {

	public PageInfo process(int count, String pageNum);
	public List<PostContentDto> preprocessingFromPostList(List<PostContentDto> postList);
	public List<ReviewContentDto> preprocessingFromReviewList(List<ReviewContentDto> reviewContentDtos);
	
}
