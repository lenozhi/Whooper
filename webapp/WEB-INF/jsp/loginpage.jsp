<%-- 
    Document   : loginpage
    Created on : 2013-3-15, 10:39:47
    Author     : joephoenix
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" type="text/css" href="css/frame.css" />
            <link rel="stylesheet" type="text/css" href="css/register.css" />
            <title>灵感--随时随地的记录</title>
    </head>
    <body>
        <div id="header">
            <div id="userpanel">
                <a href="register">注册</a>
                <span style="color: #ccc;">•</span>
                <a href="/Whooper">首页</a>
            </div>
            <h1 id="logo">
                <a class="logo" href="/">随时记</a>
            </h1>
            <div style="font-size: 14px; margin-top: 8px;">随时随地记录您的灵感和安排</div>
        </div>
        <div id="content">
            <div id="explanation">
                <div id="loginarea">
                    <div id="useremail">您的邮箱：</div>
                    <div id="emailinput"><input type="text" style="width: 200px;height: 20px"/></div>
                    <div id="password">输入密码：</div>
                    <div id="pwdInput"><input type="password" style="width: 200px;height: 20px"/></div>
                    <div id="loginButton">
                        <a href="userview">登录</a>
                    </div>
                </div>
                <div id="outputdevices">
                    <h2 class="section_header">随时随地记录和提醒</h2>
                    <div class="outputdevice">
                        <img src="images/computer-icon.png"></img><p>计算机</p>
                    </div>
                    <div class="outputdevice">
                        <img src="images/paper-icon.png"></img><p>纸</p>
                    </div>
                    <div class="outputdevice">
                        <img src="images/ipad-iphone-icon.png"></img><p>手机</p>
                    </div>
                    <div class="outputdevice">
                        <img src="images/kindle2-icon.png"></img><p>阅读器</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <a href="/faq">问题解答</a>•<a href="/faq">技术支持</a>•<a href="/faq">Ipad下使用</a>•<a href="/faq">Android下使用</a>
            <div style="margin-top: 1em;">
                © 2008-2013 随时记, 公司.联系<a href="http://www.sina.com/">新浪微博</a>,解释权归新浪微博所有
            </div>
        </div>
    </body>
</html>