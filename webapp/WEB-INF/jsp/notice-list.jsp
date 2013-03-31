<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">

<c:forEach items="${notices}" var="n">
		<div class="post">
		<p class="meta"><span class="date">January 26, 2012  ${id}</span></p>
		<div class="entry">
						<p>${n.title}</p>
						<p class="links"><a href="#" class="more">编辑</a><a href="#" title="b0x" class="comments">广播</a></p>
					</div>
	
		</div>
		
</c:forEach>
  ${page}
				<div style="clear: both;">&nbsp;</div>		
</div>