package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.PostDao;
import dto.join.HitPostDto;
import dto.join.PayedPostDto;
import dto.join.PostContentDto;
import util.PageInfo;

@Repository
public class PostDaoImpl implements PostDao {
	
	@Resource
	SqlSession session;
	
	//마감 임박 게시글 정보 가져오기
	@Override
	public List<HitPostDto> getHitPostFromMain(){
		
		return session.selectList("post.getHitPostFromMain");
	}
	
	//전체 포스트 개수
	@Override
	public int getPostCount() {
		
		return session.selectOne("post.getPostCount");
	}
	
	//검색된 전체 포스트 개수
	@Override
	public int getPostCountBySearch(String nav_search) {

		return session.selectOne("post.getPostCountBySearch", nav_search);
	}
	
	//post 리스트 뿌리기
	@Override
	public List<HitPostDto> getPostFromPostList(PageInfo info){
		
		return session.selectList("post.getPostFromPostList", info);
	}
	
	// 게시글 콘텐트 보기
	@Override
	public PostContentDto getPostContentFromContent(int post_id){
		
		return session.selectOne("post.getPostContentFromContent", post_id);
	}	
	
	//현재 신청 수량	
	@Override
	public int getCurrentamountFromApply(int post_id) {
		
		return session.selectOne("post.getCurrentamountFromApply", post_id);
	}
	
	//모집수량
	@Override
	public int getMinamountFromApply(int post_id) {
		
		return session.selectOne("post.getMinamountFromApply", post_id);
	}
	
	//reviewContent 에서 post 정보
	@Override
	public PayedPostDto getPayedPostFromReview(int payment_id) {
		
		return session.selectOne("post.getPayedPostFromReview", payment_id);
	}	
	
}


