<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/17 0017
  Time: 上午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD 	XHTML 4.01 Transitional//EN">
<html lang="en">

<head>
    <%@ page isELIgnored="false" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>user</title>
    <link rel="stylesheet" type="text/css" href="css/user.css" />
    <script type="text/javascript" src="js/user.js" ></script>

    <%--获取signMessage，设置用户签到提示--%>
    <%
        if (request.getSession().getAttribute("signMessage")=="签到未开始！"){
    %>
    <script>
        window.alert("当前签到尚未开始！请稍后再试！")
    </script><%}%>
    <%
        if (request.getSession().getAttribute("signMessage")=="签到已结束！"){
    %>
    <script>
        window.alert("当前签到已经截止！请稍后再试！")
    </script><%}%>
    <%
        if (request.getSession().getAttribute("signMessage")=="签到----成功！"){
    %>
    <script>
        window.alert("签到----成功！")
    </script><%}%>
    
    <%
        if (request.getSession().getAttribute("signMessage")=="请假已提交"){
    %>
    <script>
        window.alert("请假已提交")
    </script><%}%>
</head>

<body onload="startTime()">

<div class="div1">
    <div class="div2_1">
        <div class="div3_2">
            <span>签到考勤系统</span>
        </div>
        <div class="welcom">
            <font color="#FFF"><span>欢迎使用</span></font>
            <font color="#FFF"><span style="float: right"><a href="login.html" class="a1">退&nbsp;&nbsp;出</a></span></font>
        </div>
    </div>
    <c:set value="${sessionScope.user}" var="u"/>
    <div class="back">
        <div class="zuo">
            <div class="left">
                <div class="time">
                    <font color="black"><span id="nowDateTimeSpan"></span></font>
                </div>
                <div class="shimg">

                </div>
            </div>

            <div class="bottom">
                <div class="content">
                    <table class="table1" border="0px">
                        <tr>
                            <td class="td1">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                            <td style="text-align:left;">
                                <label class="in1" id="nid">${u.userID}</label>
                                <!--<input id="tid" type="text" class="in1" name="tid" onblur="checkId()" />-->
                            </td>
                        </tr>
                        <tr>
                            <td class="td1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                            <td style="text-align:left;">
                                <label class="in2" id="nsername">${u.name}</label>
                                <!--<input id="username" type="username" class="in1" name="username" onblur="checkNM()"/>-->
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <div class="right">
            <div class="biao">
                <span>今日签到</span>
            </div>
            <div class="qian">
                <table class="table2">
                    <form action="" method="get">
                        <tr>
                            <th class="th">开始时间</th>
                            <th class="th">结束时间</th>
                            <th class="th">签&nbsp;到&nbsp;/&nbsp;请&nbsp;假</th>
                            <!--<th class="th">签到状态</th>-->
                        </tr>
                        <sf:forEach items="${sessionScope.list}" var="s" varStatus="status">
                            <tr>
                                <td class="td">${s.beginTime}</td>
                                <td class="td">${s.endTime}</td>

                                <td class="td">
                                    <div>
                                        <sf:set var="num" value="0"/>
                                        <sf:set var="num2" value="0"/>
                                            <%--                                    <button class="sign">--%>
                                            <%--                                        <a href="user.html" title="签到" onclick="suc()" class="a2">签到</a>--%>
                                            <%--                                    </button>--%>

                                        <!--<button class="yisign">
                                            <a href="user.html" title="请勿重签"	class="a3">已签到</a>
                                            <a href="#" style="color: #FD482C" class="a3">已签到</a>
                                        </button>-->

                                            <%--遍历该用户今日的签到记录--%>
                                        <sf:forEach items="${sessionScope.list4}" var="t" varStatus="status">
                                        
                                            <%--若该用户的签到记录中有该签到项，则显示已签到--%>
                                            <sf:if test="${t.userID.equals(u.userID) && t.name.equals(u.name) && t.beginTime.equals(s.beginTime) && t.endTime.equals(s.endTime)}">
                                                <button class="yisign">
                                                    <a href="#" style="color: #FD482C" class="a3">已签到</a>
                                                </button>
                                                <sf:set var="num" value="1"/>
                                            </sf:if>
                                        </sf:forEach>
                                        
                                        
                                        <sf:forEach items="${sessionScope.leaves}" var="t" varStatus="status">
                                        	<sf:if test="${num != 1 && t.userID.equals(u.userID) && t.name.equals(u.name) && t.beginTime.equals(s.beginTime.toString()) && t.endTime.equals(s.endTime.toString()) && t.state == 3}">
                                                <button class="jia">
                                                    <a href="#" style="color: #FD482C" class="a3">待审核</a>
                                                </button>
                                                
                                                <sf:set var="num2" value="2"/>
                                            </sf:if>
                                            <sf:if test="${num != 1 && t.userID.equals(u.userID) && t.name.equals(u.name) && t.beginTime.equals(s.beginTime.toString()) && t.endTime.equals(s.endTime.toString()) && t.state == 1}">
                                                <button class="jia">
                                                    <a href="#" style="color: #FD482C" class="a3">已请假</a>
                                                </button>
                                                
                                                <sf:set var="num2" value="2"/>
                                            </sf:if>
                                            <sf:if test="${num != 1 && t.userID.equals(u.userID) && t.name.equals(u.name) && t.beginTime.equals(s.beginTime.toString()) && t.endTime.equals(s.endTime.toString()) && t.state == 2}">
                                                <button class="jia">
                                                    <a href="#" style="color: #FD482C" class="a3">未通过</a>
                                                </button>
                                                
                                                <sf:set var="num2" value="2"/>
                                            </sf:if>
                                        </sf:forEach>

                                        <sf:if test="${num != 1  && num2 != 2}">
	                                        <button class="yisign">
	                                            <a href="${pageContext.request.contextPath}/Servlet?s=userSign&beginTime=${s.beginTime}&endTime=${s.endTime}" class="a2">签到</a>
	                                        </button>
                                        </sf:if>

                                    </div>
                                    
                                    <div>
                                    
                                    	<sf:if test="${num == 1}">
                                            <button class="njia">
                                                <a href="#" title="无法请假" class="a4">请假</a>
                                            </button>
                                        </sf:if>
                                        <sf:if test="${num2 == 2}">
                                            <button class="yisign">
                                                <a href="#" title="无法签到" class="a4">签到</a>
                                            </button>
                                        </sf:if>
                                        <sf:if test="${num != 1 && num2 != 2}">
                                        
                                            <button class="jia">
                                                <a href="${pageContext.request.contextPath}/LeaveServlet?method=takeLeave&beginTime=${s.beginTime}&endTime=${s.endTime}" title="请假" onclick="diag()" class="a2">请假</a>
                                            </button>
                                        </sf:if>

                                        
                                        <!--<button class="njia">
                                        <a href="user.html" title="无法请假" class="a4">请假</a>
                                    </button>-->

                                    </div>
                                </td>
                                <!--<td class="td"></td>-->
                            </tr>
                        </sf:forEach>
                    </form>
                </table>
            </div>
        </div>


    </div>
</div>
</body>
</html>
