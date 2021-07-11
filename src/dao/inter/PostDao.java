package dao.inter;

import java.util.List;

import dto.join.PostContentDto;
import dto.join.PostSearchAndCaterogy;
import util.PageInfo;

public interface PostDao {
	
	//메인 페이지
	public List<PostContentDto> getHitPostFromMain();
	
	//포스트 리스트
	public int getPostCount();
	public int getPostCountBySearch(String search);
	public int getPostCountByCategory(int category_id);
	public int getPostCountByCategoryAndSerarch(PostSearchAndCaterogy postSearchAndCaterogy);
	public List<PostContentDto> getPostFromPostList(PageInfo info);
	public List<PostContentDto> getPostFromPostListByCategory(PageInfo info);
	
	//포스트 페이지
	public PostContentDto getPostContentFromContent(int post_id);
	public int getCurrentamountFromApply(int post_id);
	public int getMinamountFromApply(int post_id);
	
	//리뷰 페이지
	public PostContentDto getPayedPostFromReview(int payment_id);
	
}
