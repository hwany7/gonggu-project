package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.PostDao;
import dto.join.HitPostDto;
import service.inter.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Resource
	private PostDao postDao;
	
	//메인페이지 - 게시글 얻기
	@Override
	public List<HitPostDto> getMainPost() {
		return postDao.getHitPostFromMain();
	}
}
