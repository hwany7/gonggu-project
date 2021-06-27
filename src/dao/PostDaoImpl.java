package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.PostDao;
import dto.join.HitPostDto;
import dto.join.PostContentDto;

@Repository
public class PostDaoImpl implements PostDao {
	
	@Resource
	SqlSession session;
	
	//마감 임박 게시글 정보 가져오기
	@Override
	public List<HitPostDto> getHitPostFromMain(){
		
		return session.selectList("post.getHitPostFromMain");
	}
	
	// 게시글 콘텐트 보기
	@Override
	public PostContentDto getPostContentFromContent(int post_id){
		
		return session.selectOne("post.getPostContentFromContent", post_id);
	}	
}


