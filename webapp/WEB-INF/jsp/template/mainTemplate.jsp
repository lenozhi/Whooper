<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>微提醒</title>
<link href='http://fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Marvel' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Marvel|Delius+Unicase' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Arvo' rel='stylesheet' type='text/css'/>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="screen" />

<script type="text/javascript" src="${ctx}/js/jquery/1.7.1/jquery.min.js"></script>


<script type="text/javascript">
	
	function loadPage(url){
		//$("#test").load(href);
	
		
	$.ajax({ 
	type: "get", 
	url: url, 
	cache: false, 
	error: function() {alert('加载页面' + url + '时出错！');}, 
	success: function(msg) { 
	$("#test").empty().append(msg); 
	alert("sdF");
	} 
	}); 
	
	}

</script>

</head>
<body>

<div id="wrapper">
	<div id="wrapper2">
		<!-- start #header -->
		<tiles:insertAttribute  name="header"/>
		<!-- end #header -->
		
		<div id="page">
			<!-- start #content -->
			<tiles:insertAttribute  name="content"/>
			<!-- end #content -->

			<!-- start #sidebar -->
		    <tiles:insertAttribute  name="sidebar"/>
			<!-- end #sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->
		<div id="footer">
			<p>Copyright (c) 2012 微提醒.</p>
		</div>
	</div>
</div>
<!-- end #footer -->


</body>
</html>




