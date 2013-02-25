<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglibs.jsp" %>
 
<script type="text/javascript"> 
var User = Backbone.Model.extend({
	idAttribute: "id", 
	url : "/groos-web/rest/users"	   
}); 
 
var UserList = Backbone.Collection.extend({
	url: function() { return "/groos-web/rest/users"; }
});
	
var userList = new UserList();
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));
userList.add(new User({"id" : null, "name" : "kim"}));  

userList.fetch({data: { page: 1}});  
</script>  

<c:forEach var="user" items="${userList}">
	<div>${user.id} : ${user.name}</div>
</c:forEach>
=========================
<c:forEach var="user" items="${allUserList}">
	<div>${user.id} : ${user.name}</div>
</c:forEach>