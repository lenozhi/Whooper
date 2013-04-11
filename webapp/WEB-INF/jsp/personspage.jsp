<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="<c:url value='/js/jquery/1.7.1/jquery.min.js'/>"></script>
<script>
	 $(document).ready(function() {
		$("#message").fadeOut(3000);
	});
</script>

	<div id="message" class="success"></div>	
<h1>Persons</h1>
<input type=button name="ff" id="ff" value="ajax post get"  />
<input type=button name="fff" id="fff" value="ajax post add"  />
<input type=button name="add" id="add" value="post add"  />
<input type=button name="c" id="c" value="post get"  />
<input type=text id="id" name="id"/>

${header["host"]}
${header["accept"]}
${header["user-agent"]}
${requestScope.persons}
<table>
	<tr>
		<td width="50">Id</td>
		<td width="150">First Name</td>
		<td width="150">Last Name</td>
		<td width="100">Money</td>
		<td width="50">Currency</td>
	</tr>
	<c:forEach items="${persons}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
			<td>${person.money}</td>
			<td>${person.currency}</td>
		</tr>
	</c:forEach>
</table>

<table>
	<tr>
		<td width="50">Currency</td>
	</tr>
	<c:forEach items="${currencies}" var="v">
		<tr>
			<td><c:out value="${v}" /></td>
		
		</tr>
	</c:forEach>
</table>

<span id="info">(Result will be shown here)</span>
<script>

$("#add").click(
function (){
	
	$.post("${pageContext.request.contextPath}/ajax/add",
				{inputNumber1: 8,
			  	 inputNumber2: 7,
			  	 cnName:$("#id").val()
			  	},
				function(data){							  													
												   
				});
});


$("#c").click(
		function (){
			var userId = $("#id").val()
			$.post("${pageContext.request.contextPath}/ajax/get/"+userId,
						
						function(data){							  													
							alert(data);							   
						});
		});

function c(){
	var userId = $("#id").val();
	$.post("${pageContext.request.contextPath}/ajax/get/"+userId,
				null,
				function(data){		
					var info = "firstName:"+data.firstName+" id:"+data.id;		
					$("#info").html(info);							   
				});
}

$("#ff").click(function(){	 
	var $this = $(this);
	var userId = $("#id").val();
	 jQuery.ajax({   
         type : 'POST', 
         contentType: "application/x-www-form-urlencoded", 
      	 url : '${pageContext.request.contextPath}/ajax/get/'+userId,   
      	 
      	success : function(data) {   
        	
          	$('#info').html("共" + data.friend.firstName + "条数据。<br/>");   
        	
      	},   
      	error : function(data) {   
      		//$.each(data,function(n,value) { 
          //      alert(n+' '+value);  
          //      });

      	}   
});
});


$("#fff").click(function(){	 
	var $this = $(this);
	var userId = $("#id").val();
	 jQuery.ajax({   
         type : 'POST', 
         contentType: "application/x-www-form-urlencoded", 
      	 url : "${pageContext.request.contextPath}/ajax/add",
		 data:	{inputNumber1: 8,
		  	 inputNumber2: 7,
		  	 cnName:$("#id").val()},   
      	 
      	success : function(data) {   
        	
          	$('#info').html("共" + data.firstName + "条数据。<br/>");   
        	
      	},   
      	error : function(data) {   
      		//$.each(data,function(n,value) { 
          //      alert(n+' '+value);  
          //      });

      	}   
});
});
</script>
</body>
</html>