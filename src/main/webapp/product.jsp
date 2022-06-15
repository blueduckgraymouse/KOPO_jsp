<%@page import="com.webMarket.domain.repository.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.webMarket.domain.model.Product"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>상품 정보</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  
<%--   <jsp:useBean id="repository" class="com.webMarket.data.ProductRepository" scope="session"></jsp:useBean>
		<!-- new연산자를 이용한 객체 생성과 비슷한 동작, scope는 lifeCycle 지정 -->
		<!-- 스코프 설정에 따라 해당 빈의 라이브사이클이 정해진다. 따라서 new연산자를 이용할 떄는 매 페이지 로드마다 -->
		<!-- 객체를 생성하지만 jsp useBean을 사용하면 매번 객체를 생성하지 않도록 설계할 수 있다.  --> --%>
</head>

<body>
  <jsp:include page="menu.jsp"></jsp:include>

  <div class="p-5 bg-primary text-white">
    <div class="container">
      <h1>상품 정보</h1>
    </div>
  </div>
  
  <%
    	ProductRepository repository = ProductRepository.getInstance();		// 싱글톤 패턴
      	String id = request.getParameter("id");
      	Product product = repository.getProductById(id);
    %>
  
  <div class="container">
    <div class="col-md-6">
      <h3><%=product.getName()%></h3>
				<p><%=product.getDescription()%>
				<p><b>상품 코드 : </b><span class="badge badge-danger"> <%=product.getId()%></span>
				<p><b>제조사</b> : <%=product.getManufacturer()%>
				<p><b>분류</b> : <%=product.getCategory()%>
				<p><b>재고 수</b> : <%=product.getUnitsInStock()%>
				<h4><%=product.getUnitPrice()%>원</h4>
				<p><a href="#" class="btn btn-info"> 상품 주문 &raquo;</a> <a href="./products.jsp" class="btn btn-secondary"> 상품 목록 &raquo;</a>
    </div>
  </div>

	
  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>