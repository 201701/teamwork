<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/24 0024
  Time: 上午 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/DepartmentMembers.css" />
    <link rel="stylesheet" href="layui-v2.5.6/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>员工管理</title>
</head>
<body style="background-color: #1f4558de"><!-- #19455aeb -->
<!--公共部分-->
<div id="title">
    <div id="title_words">
        <a href="admin.jsp"><span>回首页</span></a>
    </div>

</div>
<div id="registration_form_title" style="color: white;">
    <span>员工信息修改</span>
</div>


<!--    签到时间设置部分 -->
<div class="box" style="margin-top :20px;margin:0 auto;width: 500px;height: 434px;background-color:#f5f5f5;border-radius: 13px;padding: 100px" >
    <form method="post" action="${pageContext.request.contextPath}/Servlet?s=updateUser&userID=${sessionScope.userID}&name=${sessionScope.name}" class="form-horizontal" style="margin-left: 40px;">
        <div class="control-group" style="margin-top: 10px;width: 200px;">
            <label class="control-label" for="inputEmail">工号</label>
            <div class="controls" style="width: 200px;">
                <input name="userID2"
                        style="    width: 200px;
                    height: 36px;
                    margin-top: 10px;
                    border-radius: 4px;" type="text" id="inputEmail" placeholder="${sessionScope.userID}">
            </div>
        </div>
        <div class="control-group" style="margin-top: 10px;width: 200px;">
            <label class="control-label" for="inputEmail">姓名</label>
            <div class="controls" style="width: 200px;">
                <input name="name2"
                        style="    width: 200px;
                    height: 36px;
                    margin-top: 10px;
                    border-radius: 4px;" type="text" id="inputEmail" placeholder="${sessionScope.name}">
            </div>
        </div>
        <div class="control-group">
            <div class="controls" style="margin-top: 20px;">

                <button type="submit" class="btn">确定</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>

