<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="${ctx}/js/jquery-validation/1.9.0/validate.css" type="text/css" rel="stylesheet" /></head>
	<script src="${ctx}/js/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery-validation/1.9.0/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery-validation/1.9.0/messages_cn.js" type="text/javascript"></script>
	<script src="${ctx}/js/example/js/jquery.maskedinput.js"></script>
	<script src="${ctx}/js/example/js/personFormValid.js" type="text/javascript"></script>
	<script src="${ctx}/js/example/js/jquery.form.js" type="text/javascript"></script>
	

	
<body>

<c:out value="${persons}"/>
<h1>Edit Person</h1>

<c:url var="saveUrl" value="/main/edit/${personAttribute.id}" />

<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}" >
	<table>
		<tr>
			<td><form:label path="id">Id:</form:label></td>
			<td>
			<c:if test="${personAttribute.id == null}">
				<form:input path="id" disabled="false" class="required" />
			</c:if>
			<c:if test="${personAttribute.id != null}">
				<form:input path="id" disabled="true"/>
			</c:if>
			</td>
		</tr>
	
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:input path="firstName" class="required" /></td>
		</tr>

		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input path="lastName" class="required" /></td>
		</tr>
		
		<tr>
			<td><form:label path="money">Money</form:label></td>
			<td><form:input path="money" class="required" /></td>
		</tr>
		
		<tr>
			<td><form:label path="currency">Currency:</form:label></td>
			<td><form:select path="currency"  items="${currencies}"/></td>
		</tr>
		
		
		<tr>
			<td><form:label path="check">Currency:</form:label></td>
			
		</tr>
		
	</table>
	
	<input type=submit  id="s" value="ff"  ></input>
</form:form>

</body>
</html>