package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.ApplicationRepository;
import dao.inter.PostRepository;
import dao.inter.ReviewRepository;
import dto.ApplicationDto;
import dto.join.PostContentDto;
import dto.join.ReviewContentDto;
import service.inter.PageService;
import service.inter.PostService;
import util.AppCancelReason;
import util.PageInfo;

@Service
public class PostServiceImpl implements PostService {
	
	private final PostRepository postRepository;
	private final ApplicationRepository applicationRepository;
	private final ReviewRepository reviewRepository;
	private final PageService pageService;
	
	@Autowired
    public PostServiceImpl(PostRepository postRepository, ApplicationRepository applicationRepository, ReviewRepository reviewRepository, PageService pageService) {
		
        this.postRepository = postRepository;
        this.applicationRepository = applicationRepository;
        this.reviewRepository = reviewRepository;
        this.pageService = pageService;
    }
	
	//메인페이지 - 게시글 얻기
	@Override
	public List<PostContentDto> getMainPost() {
		
		return postRepository.getPostsTopFive();
	}
	
	//포스트 페이지 - 포스트 정보 얻기
	@Override
	public Map<String, Object> getPost(int post_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//Post
		PostContentDto post = postRepository.getPost(post_id);
		map.put("post", post);
		
		//Review	
		List<ReviewContentDto> reviews = reviewRepository.getReviewsTopThree(post.getPost_id());
			
		if(reviews != null) {		
			reviews = pageService.preprocessingFromReviewList(reviews);
		}
		
		map.put("reviews", reviews);
		
		return map;
	}
	
	//포스트 리스트 
	@Override
	public Map<String, Object> getPostList(String pageNum, String search, int category_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = 0;
			
		if(category_id == 0) {
			cnt = (search == null) ? postRepository.getPostCount() : postRepository.getPostCountBySearch(search);
		}else if(category_id == -1) {
			cnt = (search == null) ? postRepository.getPostCountAboutFinishedStatus() : postRepository.getPostCountAboutFinishedStatusBySearch(search);
		}else {
			map.put("category_id", category_id);
			map.put("search", search);
			cnt = (search == null) ? postRepository.getPostCountByCategory(category_id) : postRepository.getPostCountByCategoryAndSerarch(map);
			map.clear();
		}
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setSearch(search);	
			info.setCategory_id(category_id);
								
			List<PostContentDto> posts = (category_id == 0) ? postRepository.getPostsByInfo(info) :
														(category_id == -1) ? postRepository.getPostsByInfoAboutFinishedStatus(info) : postRepository.getPostsByInfoAboutCategory(info);			
			
			map.put("posts", pageService.preprocessingFromPostList(posts));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//포스트 페이지 - 신청하기
	@Transactional
	@Override
	public int addPostApply(int member_id, int post_id, int amount) {

		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", member_id);
		map.put("post_id", post_id);
		map.put("amount", amount);
		
		//게시글의 신청 정보를 가져온다
		int curamount = postRepository.getCurrentAmount(post_id);
		int minamount = postRepository.getMinAmount(post_id);
		int amountCheck = minamount - curamount - amount;
			
		// 진행 수량 이상으로 신청시 신청 막는 방어코드
		if(amountCheck < 0) {

			result = -1;
		} else {
			result = applicationRepository.insertApplication(map);
			
			if(result == 1) {
				postRepository.updateCurrentAmount(map);
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

		int cnt = (post_status.equals("S")) ? postRepository.getMyPostCountAboutPayment(member_id) : postRepository.getMyPostCountByStatusAndMemberId(map);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
					
			info.setMember_id(member_id);
			info.setPost_status(post_status);
					
			List<PostContentDto> posts = (post_status.equals("S")) ? postRepository.getMyPostsByInfoAboutpayement(info) : postRepository.getMyPostsByInfoAboutStatus(info);
	
			map.put("posts", pageService.preprocessingFromPostList(posts));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//신청 취소하기
	@Transactional
	@Override
	public int cancelApp(int application_id, AppCancelReason reason) {
		
		ApplicationDto applicationDto = applicationRepository.getApplication(application_id);

		int result = applicationRepository.deleteApplication(application_id);
		
		if(result == 1) {
			applicationRepository.decreaseCurrentAmount(applicationDto);
		}
		
		//파일 패스 생성
		File file = new File("C:\\ExpertJava/logs/canscelLog.log");
		      
		//현재 날짜 받기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String date = sdf.format(Calendar.getInstance().getTime());
			         
		try {      
			//버퍼 셋팅
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));    
		     //파일이 쓰기 가능한 상태면
		     if(file.isFile() && file.canWrite()) {        
				bw.write(
						"{ "
					+ 		"\"date\":\"" 				+ date 							+ "\", "
					+ 		"\"cancel_price\":\"" 		+ reason.getCancel_price()		+ "\", "
					+ 		"\"cancel_function\":\"" 	+ reason.getCancel_function()	+ "\", "
					+ 		"\"cancel_product\":\"" 	+ reason.getCancel_product()	+ "\", "
					+ 		"\"cancel_site\":\"" 		+ reason.getCancel_site() 		+ "\", "	
					+ 		"\"cancel_mind\":\"" 		+ reason.getCancel_mind() 		+ "\", "
					+ 		"\"cancel_content\":\"" 	+ reason.getCancel_content()	+ "\", "
					+ 	" },"	
			);		        		        
		        bw.newLine();
		        bw.close();
		     }   
		}catch (IOException e) {
		     e.printStackTrace();
		}			

		return result;
	}
	
}
