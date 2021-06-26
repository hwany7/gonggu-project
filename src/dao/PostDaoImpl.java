package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.PostDao;
import dto.join.HitPostDto;

@Repository
public class PostDaoImpl implements PostDao {
	
	@Resource
	SqlSession session;
	
	@Override
	//마감 임박 게시글 정보 가져오기
	public List<HitPostDto> getHitPostFromMain(){
		
		return session.selectList("post.getHitPostFromMain");
	}
}


