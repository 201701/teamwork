

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta charset="UTF-8">
    <title>login</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src="js/login.js" ></script>
</head>

<body onload="startTime()">
<div class="body">
    <!--<img src="img/背景3.jpg" />-->
</div>
<div class="div1">
    <div class="div2_1">
        <div class="div3_2">
            <span>签到考勤系统</span>
        </div>
        <div class="time">

            <!--在这里改了时间颜色-->
            <font color="#FFF"><span id="nowDateTimeSpan"></span></font>

        </div>
    </div>

    <div class="div2_2">
        <center>
            <div class="put">
                <form id="form2" action="${pageContext.request.contextPath}/Servlet?s=login" method="post" onsubmit="return checkForm()">
                    <table class="table1" border="0px" >
                        <tr>
                            <td style="text-align:center; font-size: 25px;" colspan="3">登录</td>
                        </tr>
                        <tr>
                            <td class="td1">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                            <td style="text-align:left;">
                                <input name="userID" id="tid" type="text" class="in1" name="tid" onblur="checkId()" />
                            </td>
                            <td style="text-align:right; width: 120px;"><span id="idspan"></span></td>
                        </tr>
                        <tr>
                            <td class="td1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                            <td style="text-align:left;">
                                <input name="uname" id="username" type="username" class="in1" name="username" onblur="checkNM()"/>
                            </td>
                            <td style="text-align:right; width: 120px;"><span id="nmspan"></span></td>
                        </tr>
                    </table>
                    <button class="in3" type="submit">登录</button>
                </form>
                <!--<button class="in2" type="submit"><a href="	">管理员登录</a></button>-->
            </div>
        </center>

        </div>
        </center>
<%--        <span id="errspan" style="test"><s:actionerror/></span>--%>
    </div>
</div>
</body>
</html>





<%--<html lang="en">--%>


<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>login</title>--%>

<%--    <meta http-equiv="pragma" content="no-cache">--%>
<%--    <meta http-equiv="cache-control" content="no-cache">--%>
<%--    <meta http-equiv="expires" content="0">--%>
<%--    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">--%>
<%--    <meta http-equiv="description" content="This is my page">--%>
<%--    <link rel="stylesheet" type="text/css" href="./css/login.css">--%>
<%--    <script type="text/javascript" src="./js/login.js" ></script>--%>
<%--</head>--%>

<%--<body onload="startTime()">--%>
<%--<div class="body">--%>
<%--    <img src="img/背景3.jpg" />--%>
<%--</div>--%>
<%--<div class="div1">--%>
<%--    <div class="div2_1">--%>
<%--        <div class="div3_2">--%>
<%--            <span>签到考勤系统</span>--%>
<%--        </div>--%>
<%--        <div class="time">--%>
<%--            <font color="#FFF"><span id="nowDateTimeSpan"></span></font>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="div2_2">--%>
<%--        <center>--%>
<%--            <div class="put">--%>
<%--                <form id="form2" action="Servlet?s=login" method="post" onsubmit="return checkForm()">--%>
<%--                    <table class="table1" border="0px" >--%>
<%--                        <tr>--%>
<%--                            <td style="text-align:center; font-size: 25px;" colspan="3">登录</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td class="td1">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>--%>
<%--                            <td style="text-align:left;">--%>
<%--                                <input id="tid" type="text" name="userID" class="in1"onblur="checkId()" />--%>
<%--                            </td>--%>
<%--                            <td style="text-align:right; width: 120px;"><span id="idspan"></span></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td class="td1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>--%>
<%--                            <td style="text-align:left;">--%>
<%--                                <input id="username" type="text" name="uname" class="in1" onblur="checkNM()"/>--%>
<%--                            </td>--%>
<%--                            <td style="text-align:right; width: 120px;"><span id="nmspan"></span></td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
<%--                    <button class="in2" type="submit">用户登录</button>--%>
<%--                </form>--%>
<%--                <button class="in2" type="submit"><a href="	">管理员登录</a></button>--%>
<%--            </div>--%>
<%--        </center>--%>
<%--        <span id="errspan" style="test"><s:actionerror/></span>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
