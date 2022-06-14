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