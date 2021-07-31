<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

							<div class="row max-width-1300 div-center">
								<div class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-1 mar-top-20">
									<div class="row">
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<h3 class="font-DH mar-bottom-20">마감이<span class="text-main-color text-underline"> 임박된 </span> 공동구매 상품!</h3>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<div class="mainPostImag">
													<a href="/gonggu/posts/post?post_id=${hitPostDto[0].post_id}">		
														<img src="${hitPostDto[0].image}" class="mainPostImag">	
													</a>		
												</div>	
																
												<div class="font-GD mar-top-5"> 
													<span class="mainProdName">[${hitPostDto[0].product_name}]<br></span>
													<span class="mainPostTitle">${hitPostDto[0].post_title}<br></span>
													<span class="mainPostMount">${hitPostDto[0].current_amount}개 <span style="color: grey;">신청</span></span>
												</div>
											</div>			
										</div>	
										
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<div class="mainPostImag">
													<a href="/gonggu/posts/post?post_id=${hitPostDto[1].post_id}">		
														<img src="${hitPostDto[1].image}" class="mainPostImag">		
													</a>	
												</div>	
																
												<div class="font-GD mar-top-5"> 
													<span class="mainProdName ">[${hitPostDto[1].product_name}]<br></span>
													<span class="mainPostTitle">${hitPostDto[1].post_title}<br></span>
													<span class="mainPostMount">${hitPostDto[1].current_amount}명 <span style="color: grey;">신청</span></span>
												</div>	
											</div>		
										</div>
										
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<div class="mainPostImag">	
													<a href="/gonggu/posts/post?post_id=${hitPostDto[2].post_id}">		
														<img src="${hitPostDto[2].image}" class="mainPostImag">
													</a>			
												</div>	
																
												<div class="font-GD mar-top-5"> 
													<span class="mainProdName ">[${hitPostDto[2].product_name}]<br></span>
													<span class="mainPostTitle">${hitPostDto[2].post_title}<br></span>
													<span class="mainPostMount">${hitPostDto[2].current_amount}명 <span style="color: grey;">신청</span></span>
												</div>
											</div>		
										</div>	
									</div>
								</div>				
							</div>
							
							<div class="row max-width-1300 div-center">
								<div class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-1 mar-top-40 mar-bottom-20">
									<div class="row">
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<div class="mainPostImag">	
													<a href="/gonggu/posts/post?post_id=${hitPostDto[3].post_id}">		
														<img src="${hitPostDto[3].image}" class="mainPostImag">		
													</a>	
												</div>	
																
												<div class="font-GD mar-top-5"> 
													<span class="mainProdName ">[${hitPostDto[3].product_name}]<br></span>
													<span class="mainPostTitle">${hitPostDto[3].post_title}<br></span>
													<span class="mainPostMount">${hitPostDto[3].current_amount}명 <span style="color: grey;">신청</span></span>
												</div>			
											</div>
										</div>
										
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<div class="mainPostImag">		
													<a href="/gonggu/posts/post?post_id=${hitPostDto[4].post_id}">	
														<img src="${hitPostDto[4].image}" class="mainPostImag">			
													</a>
												</div>	
																
												<div class="font-GD mar-top-5"> 
													<span class="mainProdName ">[${hitPostDto[4].product_name}]<br></span>
													<span class="mainPostTitle">${hitPostDto[4].post_title}<br></span>
													<span class="mainPostMount">${hitPostDto[4].current_amount}명 <span style="color: grey;">신청</span></span>
												</div>			
											</div>
										</div>
										
										<div class="col-md-4 col-xs-4">
											<div class="div-center max-width-400">
												<div class="mainPostImag">
													<a href="/gonggu/posts?category_id=0">
														<img src="https://cdn.wadiz.kr/ft/images/green001/2020/0519/20200519112516982_null.png/wadiz/optimize/" class="mainPostImag">
													</a>					
												</div>	
																
												<div class="font-GD mar-top-5 text-right"> 
													<span class="mainProdName hf"><a href="/gonggu/posts?category_id=0">더 많은 상품 보러가기 ▶</a><br></span>
												</div>		
											</div>
										</div>
									</div>	
								</div>				
							</div>