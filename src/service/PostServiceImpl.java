package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.ApplicationDao;
import dao.inter.PostDao;
import dao.inter.ReviewDao;
import dto.ReviewDto;
import dto.join.PostContentDto;
import service.inter.PageService;
import service.inter.PostService;
import util.PageInfo;

@Service
public class PostServiceImpl implements PostService {
	
	@Resource
	private PostDao postDao;
	
	@Resource
	private ApplicationDao applicationDao;
	
	@Resource
	private ReviewDao reviewDao;
	
	@Resource
	private PageService pageService;
	
	//메인페이지 - 게시글 얻기
	@Override
	public List<PostContentDto> getMainPost() {
		
		return postDao.getHitPostFromMain();
	}
	
	//포스트 페이지 - 포스트 정보 얻기
	@Override
	public Map<String, Object> getPost(int post_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//Post
		PostContentDto postContentDto = postDao.getPostContentFromContent(post_id);
		map.put("postContentDto", postContentDto);
		
		//Review
		String textByContent = null;
		String reg = "<[^>]*>";
		int product_id = postContentDto.getPost_id();
		
		List<ReviewDto> postContentReview = reviewDao.getReviewFromContent(product_id);
			
		if(postContentReview != null) {		
			for(int i=0; i<postContentReview.size(); i++) {

				textByContent= postContentReview.get(i).getContent().replaceAll(reg, "");
				textByContent = textByContent.trim().replaceAll("&nbsp;", "");
				postContentReview.get(i).setContent(textByContent);
			}
		}
		
		map.put("postContentReview", postContentReview);
		
		return map;
	}
	
	//포스트 리스트 
	@Override
	public Map<String, Object> getPostList(String pageNum, String search, int category_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = 0;
			
		if(category_id == 0) {
			cnt = (search == null) ? postDao.getPostCount() : postDao.getPostCountBySearch(search);
		}else if(category_id == -1) {
			cnt = (search == null) ? postDao.getPostCountByfinished() : postDao.getPostCountByFinishedAndSearch(search);
		}else {
			map.put("category_id", category_id);
			map.put("search", search);
			cnt = (search == null) ? postDao.getPostCountByCategory(category_id) : postDao.getPostCountByCategoryAndSerarch(map);
			map.clear();
		}
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setSearch(search);	
			info.setCategory_id(category_id);
								
			List<PostContentDto> postListDto = (category_id == 0) ? postDao.getPostFromPostList(info) :
														(category_id == -1) ? postDao.getPostFromPostListByFinished(info) : postDao.getPostFromPostListByCategory(info);			
			
			map.put("postListDto", pageService.preprocessingFromPostList(postListDto));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//포스트 페이지 - 신청하기
	@Override
	public int addPostApply(int member_id, int post_id, int amount) {

		int result = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("member_id", member_id);
		map.put("post_id", post_id);
		map.put("amount", amount);
		
		//게시글의 신청 정보를 가져온다
		int curamount = postDao.getCurrentamountFromApply(post_id);
		int minamount = postDao.getMinamountFromApply(post_id);
		int amountCheck = minamount - curamount - amount;
			
		// 진행 수량 이상으로 신청시 신청 막는 방어코드
		if(amountCheck < 0) {
			// 진행 수량보다 초과되는 경우
			result = -1;
		} else {
			result = applicationDao.registerAppFromPostContent(map);
			
			if(result == 1) {
				applicationDao.updateAppFromPostPostContent(map);
			}
		}
		
		return result;
	}
	
	//상태에 따라 내 포스트 리스트 가져오기
	@Override
	public Map<String, Object> myPostListByStatus(String pageNum, int member_id, String post_status) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", member_id);
		map.put("post_status", post_status);
		int cnt = postDao.getMyPostCountByStatus(map);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
					
			info.setMember_id(member_id);
			info.setPost_status(post_status);
			
			List<PostContentDto> postListDto = postDao.getMyPostListByStatus(info);
			
			map.put("postListDto", pageService.preprocessingFromPostList(postListDto));
		}
		
		map.put("info", info);
		
		return map;
	}
	
}
