<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"> 
    <title>查询测试</title>
     <link rel="stylesheet" href="layui-v2.5.6/layui/css/seek1.css">  
     <link rel="stylesheet" href="layui-v2.5.6/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body onload="startTime()">

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

 <a href="admin.jsp"><button class="btn">返回首页</button></a>

<form class="form-search" action="${pageContext.request.contextPath}/SignRecordServlet?method=getSelectedDate" method="post" style="width:800px;margin:auto;" >
   <!--  表单功能键 查询 排序 -->
   <div class="box" style="margin-top :20px;margin:auto;width: 400px;height: 234px;background-color:#f5f5f5;border-radius: 13px;" >

	
          <div class="input-append" style="float: right;margin-top: 40px;margin-bottom: 40px;margin-right: 100px; margin-left: 78px;">
           <!--  <input type="text" class="span2 search-query" > -->
           <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
              <input type="text" class="layui-input" id="test1" name="signDate" style="margin-left:20px">
            </div>
<!--            <input type="submit" class="btn" >查询</input>
            
                 <button style="margin-top: 56px;
                    height: 46px;
                    color: #f5f5f5;
                    border-radius: 5px;
                    background-color: #337ab7e8;
                    margin-left: 76px;">
                查询结果</button> -->
                <input name="check" type ="submit" id = "check" value="查看结果"  onclick="serach()" style="margin-left: 51px;
                    height: 61px;
                    margin-top: 31px;
                    margin-right: 21px;
                    width: 100px;
                    border-radius: 5px;
                    background-color:#3c404b;
                    font-size: 18px;
                    font-style: initial;
                       color: white;" />
		

          
            
          </div>
    </div>
   
 
</form>

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

</body>
</html>
