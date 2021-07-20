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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.ApplicationDao;
import dao.inter.PaymentDao;
import dao.inter.PostDao;
import dao.inter.ReviewDao;
import dto.ApplicationDto;
import dto.ReviewDto;
import dto.join.PostContentDto;
import service.inter.PageService;
import service.inter.PostService;
import util.AppCancelReason;
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

		int cnt = (post_status == "S") ? postDao.getMyPostByPayment(member_id) : postDao.getMyPostCountByStatus(map);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
					
			info.setMember_id(member_id);
			info.setPost_status(post_status);
			
			List<PostContentDto> postListDto = (post_status == "S") ? postDao.getMyPostListBypayement(info) : postDao.getMyPostListByStatus(info);
			
			map.put("postListDto", pageService.preprocessingFromPostList(postListDto));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//신청 취소하기
	@Override
	public int cancelApp(int application_id, AppCancelReason reason) {
		
		ApplicationDto applicationDto = applicationDao.getApplication(application_id);

		int result = applicationDao.deleteApplication(application_id);
		
		if(result == 1) {
			applicationDao.updateApplicationAndDecreaseComments(applicationDto);
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
