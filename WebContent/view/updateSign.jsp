<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/22 0022
  Time: 上午 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
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
    <title>签到管理</title>
</head>
<body style="background-color: #1f4558de"><!-- #19455aeb -->
<!--公共部分-->
<div id="title">
    <div id="title_words">
        <a href="admin.jsp"><span>回首页</span></a>
    </div>

</div>
<div id="registration_form_title" style="color: white;">
    <span>签到项目修改</span>
</div>


<!--    签到时间设置部分 -->
<div class="box" style="margin-top :20px;margin:0 auto;width: 600px;height: 434px;background-color:#f5f5f5;border-radius: 13px;padding: 40px" >
    <form  action="${pageContext.request.contextPath}/Servlet?s=updateSign&signDate=${sessionScope.signDate}&beginTime=${sessionScope.beginTime}&endTime=${sessionScope.endTime}" method="post" class="form-search" style="width:800px;margin:auto;">
        <div class="input-append" style=" width: 320px; margin-left: 70px;margin-right: 80px;">

            <div class="layui-inline" style="margin-top: 20px;">


                <label class="layui-form-label" style="width: 90px">日期</label>


                <div class="layui-input-inline" style="width: 220px;">
                    <input name="signDateNew" type="text" class="layui-input" id="test1" placeholder="${sessionScope.signDate}">
                </div>


            </div>

            <div class="layui-inline" style="margin-top: 20px;">


                <label class="layui-form-label" style="width: 90px">开始时间</label>


                <div class="layui-input-inline" style="width: 220px;">
                    <input name="beginTimeNew" type="text" class="layui-input" id="test4" placeholder="${sessionScope.beginTime}">
                </div>


            </div>

            <div class="layui-inline" style="margin-top: 20px;">


                <label class="layui-form-label" style="width: 90px">结束时间</label>
                <div class="layui-input-inline" style="width: 220px;">
                    <input  name="endTimeNew" type="text" class="layui-input" id="test5" placeholder="${sessionScope.endTime}">
                </div>

            </div>
            <button type="submit" class="layui-btn layui-btn-fluid" style="margin-left: 20px;margin-top:50px;background-color: #3b5d6da6">确认修改</button>



        </div>
    </form>
</div>
</body>
<script src="layui-v2.5.6/layui/layui.js"></script>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
    });



    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //时间选择器
        laydate.render({
            elem: '#test4'
            ,type: 'time'
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //时间选择器
        laydate.render({
            elem: '#test5'
            ,type: 'time'
        });
    });
</script>
</html>
