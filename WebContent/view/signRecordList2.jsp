<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询1</title>
<link rel="stylesheet" href="seek1.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function base64 (content) {
       return window.btoa(unescape(encodeURIComponent(content)));         
    }
    function tableToExcel(tableID,fileName){
        var table = document.getElementById(tableID);
      var excelContent = table.innerHTML;
      var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
      excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
      excelFile += "<body><table>";
      excelFile += excelContent;
      excelFile += "</table></body>";
      excelFile += "</html>";
      var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
      var a = document.createElement("a");
      a.download = fileName+".xls";
      a.href = link;
      a.click();
    }
</script>

</head>
<body onload="startTime()">

	<%
        String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null
                && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="
                    + "excel.xls");
 
        }
    %>

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

		<a href="admin.jsp"><button
				class="btn">返回首页</button></a>

		<form class="form-search" style="width: 800px; margin: auto;">
			<!--  表单功能键 查询 排序 -->

			<div style="float:left; margin-top: 40px; margin-bottom: 40px;">
				<button class="btn" type="button" onclick="tableToExcel('table','data')">导出</button>
			</div>

			<div class="input-append"
				style="float: right; margin-top: 40px; margin-bottom: 40px;">
				
				
			
 
				<a href="${pageContext.request.contextPath}/SignRecordServlet?method=getSelectedTimeOrderByID">
					按工号排序 
				</a> 
				<a href="${pageContext.request.contextPath}/SignRecordServlet?method=getSelectedTimeOrderByCount">
					按出勤次数排序
				</a>
			</div>



			<!-- 表格部分 -->
			<table class="table" id="table">

				<thead>
					<tr>
						<th>工号</th>
						<th>姓名</th>
						<th>出勤次数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${signRecordList}" var="signrecord"
						varStatus="st">
						<tr>
							<td>${signrecord.userID}</td>
							<td>${signrecord.name}</td>
							<td>${signrecord.signCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</form>
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

		



		<%
        if (exportToExcel == null) {
    %>
		<!--      <a href="signRecordList.jsp?exportToExcel=YES">Export to Excel</a>-->
		<%
        }
    %>
	
</body>
</html>


