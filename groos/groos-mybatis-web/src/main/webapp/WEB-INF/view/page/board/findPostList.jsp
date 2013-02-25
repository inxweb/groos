<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglibs.jsp" %> 
<c:forEach var="post" items="${postPage.content}">
	<li>${post.title}) ${post.content}</li> 
</c:forEach> 