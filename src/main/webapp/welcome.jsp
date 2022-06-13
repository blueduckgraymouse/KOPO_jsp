<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <%
	Date now = new Date();
  	SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
  %> 
</head>

<body>
  <jsp:include page="menu.jsp"></jsp:include>

  <div class="p-5 bg-primary text-white">
    <div class="container">
      <h1>Welcome to Web Shopping Mall</h1>
    </div>
  </div>
  <div class="container">
    <div class="text-center">
      <h3>Welcome to Web market!</h3>
      현재 접속 시간 : <%= format.format(now) %> 
    </div>
  </div>
  
  <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>