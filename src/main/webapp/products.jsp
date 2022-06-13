<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.webMarket.domain.model.Product"%>
<!DOCTYPE html>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  
  <jsp:useBean id="repository" class="com.webMarket.data.ProductRepository" scope="session"></jsp:useBean>
			<!-- new연산자를 이용한 객체 생성과 비슷한 동작, scope는 lifeCycle 지정 -->
<html>

<head>
  <meta charset="UTF-8">
  <title>상품 목록</title>
</head>

<body>
  <jsp:include page="menu.jsp"></jsp:include>

  <div class="p-5 bg-primary text-white">
    <div class="container">
      <h1>상품 목록</h1>
    </div>
  </div>
  <div class="container">
    <div class="row" align="center">
      <%
        List<Product> products = repository.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
      %>
        <div class="col-md-4">
          <h3><%= products.get(i).getName() %></h3>
          <p><%= products.get(i).getDescription() %></p>
          <p><%= products.get(i).getUnitPrice() %></p>
          <p><a href="product.jsp?id=<%= products.get(i).getId() %>" class="btn btn-secondary">상세정보 &raquo; </a>
        </div>
      <%
        }
      %>
    </div>
  </div>

	
  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>