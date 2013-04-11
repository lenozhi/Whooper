<%@page contentType="text/html" pageEncoding="UTF-8"%>	
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<div id="sidebar">
				<ul>
					<li>
						<div id="search" >
						   <input type="button" value="加载" onclick="loadPage('http://bbs.csdn.net/topics/310079535')"/>
							<form method="get" action="#">
								<div>
									<input type="text" name="s" id="search-text" value="" />
									<input type="submit" id="search-submit" value="GO" />
								</div>
							</form>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</li>
					<li>
						<h2></h2>
						<ul>
							<li><a href="${ctx}/list/1">我的提醒</a></li>
							<li><a href="test">提醒我的</a></li>
							<li><a href="#">广场</a></li>
							<li><a href="#">捞捞看</a></li>
						</ul>
					</li>
					
				</ul>
			</div>