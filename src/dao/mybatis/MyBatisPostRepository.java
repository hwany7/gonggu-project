package dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.PostRepository;
import dto.join.PostContentDto;
import util.PageInfo;

@Repository
public class MyBatisPostRepository implements PostRepository {
	
	private final SqlSession session;
	
	@Autowired
	public MyBatisPostRepository(SqlSession session) {
		
		this.session = session;
	}
	
	//마감 임박 게시글 정보 가져오기
	@Override
	public List<PostContentDto> getPostsTopFive(){
		
		return session.selectList("post.getPostsTopFive");
	}
	
	//포스트 리스트 뿌리기
	@Override
	public List<PostContentDto> getPostsByInfo(PageInfo info){
		
		return session.selectList("post.getPostsByInfo", info);
	}
	
	//카테고리별 포스트 리스트 뿌리기
	@Override
	public List<PostContentDto> getPostsByInfoAboutCategory(PageInfo info) {
		
		return session.selectList("post.getPostsByInfoAboutCategory", info);
	}
	
	//종료된 포스트 리스트 뿌리기
	@Override
	public List<PostContentDto> getPostsByInfoAboutFinishedStatus(PageInfo info) {
		
		return session.selectList("post.getPostsByInfoAboutFinishedStatus", info);
	}	
		
	//결제한 포스트 리스트(구매내역)
	@Override
	public List<PostContentDto> getMyPostsByInfoAboutpayement(PageInfo info) {

		return session.selectList("post.getMyPostsByInfoAboutpayement", info);
	}	
	
	//상태에 따른 내 포스트 리스트 가져오기
	@Override
	public List<PostContentDto> getMyPostsByInfoAboutStatus(PageInfo info) {

		return session.selectList("post.getMyPostsByInfoAboutStatus", info);
	}
	
	// 게시글 콘텐트 보기
	@Override
	public PostContentDto getPost(int post_id){
		
		return session.selectOne("post.getPost", post_id);
	}	
	
	//전체 포스트 개수
	@Override
	public int getPostCount() {
		
		return session.selectOne("post.getPostCount");
	}
	
	//검색된 전체 포스트 개수
	@Override
	public int getPostCountBySearch(String search) {

		return session.selectOne("post.getPostCountBySearch", search);
	}
	
	//종료된 전체 포스트 개수
	@Override
	public int getPostCountAboutFinishedStatus() {
		
		return session.selectOne("post.getPostCountAboutFinishedStatus");
	}
	
	//검색, 종료된 전체 포스트 개수
	@Override
	public int getPostCountAboutFinishedStatusBySearch(String search) {

		return session.selectOne("post.getPostCountAboutFinishedStatusBySearch", search);
	}

	//카테고리별 전체 포스트 개수
	@Override
	public int getPostCountByCategory(int category_id) {
		
		return session.selectOne("post.getPostCountByCategory", category_id);
	}
	
	//검색, 카테고리별 전체 포스트 개수
	@Override
	public int getPostCountByCategoryAndSerarch(Map<String, Object> map) {
		return session.selectOne("post.getPostCountByCategoryAndSerarch", map);
	}
	
	//내가 결제한 포스트 리스트 전체 개수 가져오기
	@Override
	public int getMyPostCountAboutPayment(int member_id) {
		
		return session.selectOne("post.getMyPostCountAboutPayment", member_id);
	}
	
	//상태에 따른 내 포스트 전체 개수 가져오기
	@Override
	public int getMyPostCountByStatusAndMemberId(Map<String, Object> map) {
		
		return session.selectOne("post.getMyPostCountByStatusAndMemberId", map);
	}
	
	//현재 신청 수량	
	@Override
	public int getCurrentAmount(int post_id) {
		
		return session.selectOne("post.getCurrentAmount", post_id);
	}	
	
	//모집수량
	@Override
	public int getMinAmount(int post_id) {
		
		return session.selectOne("post.getMinAmount", post_id);
	}

	//신청수량 업데이트
	@Override
	public int updateCurrentAmount(Map<String, Object> map) {
		
		return session.update("post.updateCurrentAmount", map);
	}
	
	//reviewContent 에서 post 정보 (미사용 - 리팩토리후)
	@Override
	public PostContentDto getPostByPayedStatus(int payment_id) {
		
		return session.selectOne("post.getPostByPayedStatus", payment_id);
	}	

}


