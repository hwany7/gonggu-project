package dao.inter;

import java.util.List;
import java.util.Map;

import dto.join.PostContentDto;
import util.PageInfo;

public interface PostDao {
	
	public List<PostContentDto> getPostsTopFive();
	public List<PostContentDto> getPostsByInfo(PageInfo info);
	public List<PostContentDto> getPostsByInfoAboutCategory(PageInfo info);
	public List<PostContentDto> getPostsByInfoAboutFinishedStatus(PageInfo info);
	public List<PostContentDto> getMyPostsByInfoAboutpayement(PageInfo info);
	public List<PostContentDto> getMyPostsByInfoAboutStatus(PageInfo info);
	
	public PostContentDto getPost(int post_id);
	
	public int getPostCount();
	public int getPostCountBySearch(String search);	
	public int getPostCountAboutFinishedStatus();
	public int getPostCountAboutFinishedStatusBySearch(String search);	
	public int getPostCountByCategory(int category_id);
	public int getPostCountByCategoryAndSerarch(Map<String,Object> map);
	
	public int getMyPostCountAboutPayment(int member_id);
	public int getMyPostCountByStatusAndMemberId(Map<String,Object> map);
	
	public int getCurrentAmount(int post_id);
	public int getMinAmount(int post_id);

	public int updateCurrentAmount(Map<String, Object> map);
	
	public PostContentDto getPostByPayedStatus(int payment_id); //미사용(리팩토리 후)

}
