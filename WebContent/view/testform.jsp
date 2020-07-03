<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><%=request.getAttribute("userID")%></p>
<p><%=request.getAttribute("beginTime")%></p>
<p><%=request.getAttribute("endTime")%></p>
<form action="${pageContext.request.contextPath}/LeaveServlet?method=doLeave&userID=<%=request.getAttribute("userID")%>&beginTime=<%=request.getAttribute("beginTime")%>&endTime="<%=request.getAttribute("endTime")%>"" method="post">
	<input type="text" name="reason">
	<input type="hidden" value="<%=request.getAttribute("userID")%>" name="userID">
	<input type="hidden" value="<%=request.getAttribute("beginTime")%>" name="beginTime">
	<input type="hidden" value="<%=request.getAttribute("endTime")%>" name="endTime"> 
	<input type="submit">
</form>
</body>
</html>