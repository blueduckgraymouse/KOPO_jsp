package com.webMarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webMarket.domain.model.Product;
import com.webMarket.domain.repository.ProductRepository;

@WebServlet(name = "ProductController", urlPatterns = {"/products.do", "/processAddProduct.do"})		// 서블릿을 사용하기 위해서 명시, 무지성?
public class ProductController extends HttpServlet {
	
	private static final long serialVersionUID = 6452847636295066017L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("!");
		if (command.equals("/products.do")) {
			ProductRepository repository = ProductRepository.getInstance();		// 싱글톤 패턴
	        List<Product> products = repository.getAllProducts();
	        req.getSession().setAttribute("products", products);
	        
	        req.getRequestDispatcher("products.jsp").forward(req, resp);
		} else if (command.equals("/processAddProduct.do")) {
			req.setCharacterEncoding("UTF-8");

		  	//Post로 넘어온 것
			String productId = req.getParameter("productId");
			String name = req.getParameter("name");
			String unitPrice = req.getParameter("unitPrice");
			String description = req.getParameter("description");
			String manufacturer = req.getParameter("manufacturer");
			String category = req.getParameter("category");
			String unitsInStock = req.getParameter("unitsInStock");
			String condition = req.getParameter("condition");

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

			req.getRequestDispatcher("./products.do").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
