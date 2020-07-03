<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/26 0026
  Time: 下午 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<link rel="stylesheet" href="css/test1.css">
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/DepartmentMembers.css" />
<link rel="stylesheet" href="layui-v2.5.6/layui/css/layui.css" media="all">

<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<body onload="startTime()">
<style>
    p{

        margin-left:10px;
        margin-top:10px;
    }
</style>

<!-- 页面头部 -->
<div class="div1">
    <div class="div2_1">
        <div class="div3_2">
            <span>签到考勤系统</span>
        </div>
        <div class="time">
            <font color="#FFF"><span id="nowDateTimeSpan"></span></font>
        </div>
    </div>



    <div class="contain" style="margin: 0 auto;padding: 20px;">
        <!-- 四个选项 -->
        <ul id="myTab" class="nav nav-tabs">
            <!--   <li class="active"> -->
            <li>
                <a href="admin.jsp">签到设置</a>
            </li>
            <li class="active">
                <a href="#lol1" data-toggle="tab">员工信息管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/LeaveServlet?method=listLeave" >待审核请假申请</a>
            </li>



            <li class="dropdown">
                <a href="#" id="myTabDrop1" class="dropdown-toggle"
                   data-toggle="dropdown">出勤查询
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                    <li><a href="signRecord_datesearch.jsp" >按照日期</a></li>
                    <li><a href="signRecord_timesearch.jsp" >按照时间区间</a></li>

                </ul>
            </li>
        </ul>



        <!--  控制面板部分 -->
        <div id="myTabContent" class="tab-content">


            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="utf-8">
                <title>Bootstrap 实例 - 上下文类</title>

            </head>

            <!--  签到设置页面  -->
            <!-- tab-pane fade in active -->
            <div class="tab-pane fade  " id="lol0">


                <div class="box" style="margin-top :20px;margin:auto;">



                    <!-- 签到表格部分 -->
                    <div class="content">
                        <div class="buttons" style="margin-left: 120px;">
                            <a href="form.html"><button type="button" id="add" style="background-color: #303e48">新建签到</button></a>
                        </div>
                        <table style="background-color: #e2e2e296;text-align: center;vertical-align: middle!important;">
                            <form action="" method="get">
                                <tr>
                                    <th style="width:100px;">序号</th>
                                    <th>日期</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <!-- <th></th>
                                    <th></th>
                                    <th></th> -->
                                    <th></th>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>

                                    <!--  <td></td>
                                     <td></td>  -->

                                    <td>
                                        <a href="#" title="删除">
                                            <img style="width:20px;margin-left: 15px;" src="img/delete.jpg"  title="delete" />
                                        </a>
                                        <a href="update1.html" title="修改" >
                                            <img style="width:20px;margin-left: 15px;" src="img/edit.png" title="edit" />
                                        </a>
                                    </td>
                                </tr>
                            </form>
                        </table>

                    </div>
                </div>

                <!-- 日期控件 -->
                <script src="layui-v2.5.6/layui/layui.js"></script>
                <script>
                    layui.use('laydate', function(){
                        var laydate = layui.laydate;

                        //执行一个laydate实例
                        laydate.render({
                            elem: '#test1' //指定元素
                        });
                    });
                </script>
            </div>







            <!-- 选项二 -->
            <!--   tab-pane fade -->

            <div class="tab-pane fade in active" id="lol1">

                <div class="box" style="margin-top :20px;margin:auto;">



                    <!-- 员工表格部分 -->
                    <div class="content">
                        <div class="buttons" style="margin-left: 120px;">
                            <a href="addUser.jsp"><button type="button" id="add" style="background-color: #303e48">添加信息</button></a>
                        </div>
                        <table style="background-color: #e2e2e296;text-align: center;vertical-align: middle!important;">
                            <form action="" method="get">
                                <tr>
                                    <th>序号</th>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <!-- <th></th>
                                    <th></th>
                                    <th></th> -->
                                    <th></th>
                                </tr>
                                <% int j=1; %>
                                <sf:forEach items="${sessionScope.list3}" var="s3" varStatus="status">
                                    <tr>
                                        <td><%=j++%></td>
                                        <td>${s3.userID}</td>
                                        <td>${s3.name}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/Servlet?s=deleteUser&userID=${s3.userID}&name=${s3.name}" title="删除">
                                                <img src="img/delete.jpg"  title="delete" />
                                            </a>
                                            <a href="${pageContext.request.contextPath}/Servlet?s=update2&userID=${s3.userID}&name=${s3.name}" title="修改" >
                                                <img src="img/edit.png" title="edit" />
                                            </a>
                                        </td>

                                    </tr>
                                </sf:forEach>
                            </form>
                        </table>

                    </div>
                </div>
            </div>


            <!-- 选项三 ——丁静 -->
            <div class="tab-pane fade" id="lol2">
                <div class="apply">
                    <table style="background-color: #e2e2e296;text-align: center;vertical-align: middle!important;">
                        <form action="" method="get">
                            <tr>
                                <th style="width: 100px;">序号</th>
                                <th style="width: 120px;">工号</th>
                                <th>姓名</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>请假理由</th>
                                <th>操作</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <a href="" title="批准">
                                        <input type="submit" value="批准" name="ok" class="allow" />
                                    </a>
                                    <a href="" title="不批准" >
                                        <input type="submit" value="不批准" name="no" class="noallow" />
                                    </a>
                                </td>
                            </tr>
                        </form>
                    </table>
                </div>
            </div>
            <!--   查询选项跳转 -->

            </html></div></div></div></body>

        </div>


    </div>

    <!-- 时钟控件 -->
    <script type="text/javascript">
        function startTime()
        {
            var today=new Date();//定义日期对象
            var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
            var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年
            var dd = today.getDate();//通过日期对象的getDate()方法返回年
            var hh=today.getHours();//通过日期对象的getHours方法返回小时
            var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟
            var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒
            // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
            MM=checkTime(MM);
            dd=checkTime(dd);
            mm=checkTime(mm);
            ss=checkTime(ss);
            document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd + " " +hh+":"+mm+":"+ss;

            setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法
        }

        function checkTime(i)
        {
            if (i<10){
                i="0" + i;
            }
            return i;
        }
    </script>
</div></body>
