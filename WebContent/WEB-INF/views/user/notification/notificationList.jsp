<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

		<div class="max-width-1500 div-center">
			<div class="container-fluid">
								
				<!-- 내역이 없을경우 -->
				<c:if test="${notifications[0].manager_id eq null }">
					<div class="row">
						<div class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-2">	
							<div class="col-md-12">
								<h5 class="font-DH mar-top-20 text-color-g2">알림이 없습니다</h5>
							</div>
						</div>
					</div>
				</c:if>
				
				<!-- 리스트 박스 -->
				<c:forEach var="notification" items="${notifications}">
				<div class="row">			
					<div class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-2">
						<div class="col-md-12 col-xs-12">				
							<h5>${notification.content}</h5>	
							<h5 class="text-color-g2">
							<fmt:formatDate value="${notification.notify_time}" type="both" pattern="MM-dd-hh:mm"/></h5>			
						</div>	

						<hr>				
					</div>
				</div>		
				</c:forEach>
			</div>
			
			<c:if test="${notifications[0].manager_id ne null }">
				<div class="container-fluid">
					<input type="button" class="btn btn-default form-control" value="전체삭제" onclick="deleteAllNotification()">
				</div>
			</c:if>
		</div>
