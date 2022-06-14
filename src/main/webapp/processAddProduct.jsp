<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.webMarket.data.ProductRepository" %>
<%@ page import="com.webMarket.domain.model.Product" %>
<%
  	// 한글깨짐 처리 - java버전에 따라 필요하다
  	request.setCharacterEncoding("UTF-8");

  	//Post로 넘어온 것
	String productId = request.getParameter("productId");
	String name = request.getParameter("name");
	String unitPrice = request.getParameter("unitPrice");
	String description = request.getParameter("description");
	String manufacturer = request.getParameter("manufacturer");
	String category = request.getParameter("category");
	String unitsInStock = request.getParameter("unitsInStock");
	String condition = request.getParameter("condition");

	// getInstance() 메서드는 static
	// tomcat서버가 서버 메모리에 올라가면 instance는 자동으로 할당되고 서버가 내려갈 때까지 생명주기를 유지
	// instance 객체에 add한 상품 정보는 서버가 내려갈 때까지 유지
	// 서버가 내려가면 기존에 ProductRepository 내 저장된 데이터로 초기화되는 것처럼 동작한다.
	// 또한 instance 객체는 서버의 메모리에 존재하므로 추가한 상품은 모든 클라이언트에 대해 동기화되어 보여진다.
 	ProductRepository dao = ProductRepository.getInstance();

	Product newProduct = new Product();
	
	newProduct.setId(productId);
	newProduct.setName(name);
	newProduct.setUnitPrice(Integer.valueOf(unitPrice));
	newProduct.setDescription(description);
	newProduct.setManufacturer(manufacturer);
	newProduct.setCategory(category);
	newProduct.setUnitsInStock(Long.valueOf(unitsInStock));
	newProduct.setCondition(condition);

	dao.addProduct(newProduct);

	response.sendRedirect("./products.jsp");
%>