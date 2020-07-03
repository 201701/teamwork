<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD 	XHTML 4.01 Transitional//EN">
<html lang="en">
	
  	<head>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1" />
    	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>user</title>
		<link rel="stylesheet" type="text/css" href="css/reason.css" />
		<script type="text/javascript" src="js/user.js" ></script>
		

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
				<span>请假理由</span>
			</div>
			<div class="cont">
		    	<form action="${pageContext.request.contextPath}/LeaveServlet?method=doLeave&userID=${sessionScope.userID}&beginTime=${sessionScope.beginTime}&endTime=${sessionScope.endTime}" method="post" accept-charset="UTF-8">
		    		<%request.setCharacterEncoding("UTF-8"); 	 %>
		    		<input type="text" name="reason" style="width:330px;height:230px">
		    		<!--  <textarea class="area" name="reason"></textarea> -->
		    		<input type="hidden" value="${sessionScope.userID}" name="userID">
					<input type="hidden" value="${sessionScope.beginTime}>" name="beginTime">
					<input type="hidden" value="${sessionScope.endTime}>" name="endTime">
			<%-- 	<input type="hidden" value="<%=request.getAttribute("endTime")%>" name="endTime">
		   --%> 		<button class="up"><input type="submit"></button>
		    	</form>
		    </div>
			
		
		</div>
	</div>
	</body>
</html>
