<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglibs.jsp" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title></title> 
<%@ include file="/WEB-INF/include/stylesheets.jsp"%>
<%@ include file="/WEB-INF/include/scripts.jsp"%>
</head>
<body> 
	<div id="wrap">
	   <div id="header"><tiles:insertAttribute name="header"/></div>
	   <div id="content"><tiles:insertAttribute name="content"/></div>
	   <div id="footer"><tiles:insertAttribute name="footer" /></div>
	</div>	
</body>
</html>