package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.ApplicationDao;
import dao.inter.PostDao;
import dto.join.HitPostDto;
import dto.join.PostContentDto;
import service.inter.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Resource
	private PostDao postDao;
	
	@Resource
	private ApplicationDao applicationDao;
	
	//메인페이지 - 게시글 얻기
	@Override
	public List<HitPostDto> getMainPost() {
		
		return postDao.getHitPostFromMain();
	}
	
	
	//포스트 페이지 - 포스트 정보 얻기
	@Override
	public PostContentDto getPost(int post_id) {

		return postDao.getPostContentFromContent(post_id);
	}
	
	//포스트 페이지 - 신청하기
	@Override
	public Map<String, Integer> addPostApply(int member_id, int post_id, int amount) {

			
		Map<String, Integer> result = new HashMap<String, Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("member_id", member_id);
		map.put("post_id", post_id);
		map.put("amount", amount);
		
		//게시글의 신청 정보를 가져온다
		int curamount = postDao.getCurrentamountFromApply(post_id);
		int minamount = postDao.getMinamountFromApply(post_id);
		int amountCheck = minamount - curamount-amount;
			
		// 진행 수량 이상으로 신청시 신청 막는 방어코드
		if(amountCheck < 0) {
			// 진행 수량보다 초과되는 경우
			result.put("result", -1);
		} else {
			result.put("result",applicationDao.registerAppFromPostContent(map));
			
			if(result.get("result") == 1) {
				result.put("resultUpdate", applicationDao.updateAppFromPostPostContent(map));
			}
		}
		
		return result;
	}
}
