package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.ReviewDao;
import service.inter.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Resource
	ReviewDao reviewDao;
	
	
	
}
