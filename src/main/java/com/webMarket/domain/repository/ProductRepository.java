package com.webMarket.domain.repository;

import java.util.List;

import com.webMarket.data.ProductRepositoryDbImpl;
import com.webMarket.data.ProductRepositoryImpl;
import com.webMarket.data.dao.MysqlProductDaoImpl;
import com.webMarket.data.dao.ProductDao;
import com.webMarket.domain.model.Product;

/*
 * view인 products.jsp에서
 * "ProductRepository repository = ProductRepository.getInstance();"를
 * 그대로 사용하여 view단에서 model(repository)의 구현 방식 변경에 영향을 받지않도록 하기 위해서
 * 이런 식으로 설계.
 * 이 인터페이스 ProductRepository를 상속받는
 * 		기존 방식 - ProductRepositoryImpl
 * 		DB연동 방식 - ProeductRepositoryDbImpl
 * 	 2가지로 구현.
 */
public interface ProductRepository {
	/* 
	 * - 인터페이스 -
	 * 인터페이스는 일반메서드와 맴버변수를 갖을 수 없다.
	 * 오직 추상메서드와 상수만을 맴버로 갖는다. (static, default 제외)
	 * 인터페이스의 모든 메서드의 default는 public static 
	 */
//	public static ProductRepository getInstance() {	// 인터페이스이므로 구현부를 작성하지 않는게 맞다.
//		return ProductRepositoryImpl.getInstance();	// 하지만 싱글톤패턴을 위해 static으로 선언해야하고 
//	}												// static은 추상메서드에 사용할 수 없으므로 임시로
//													// 메서드를 구현해야 한다.

	public static ProductRepository getInstance() {	
		/* repository 구현(2) */
		ProductDao dao = new MysqlProductDaoImpl();	// mysql DBMS에 접속하여 DB를 사용하는 두번째 방법
		//ProductDao dao = new OracleProductDaoImpl();	// DBMS를 mysql 대신 orcle을 사용한다고 가정했을 때.
		return new ProductRepositoryDbImpl(dao);
		
		/* repository 구현(1) */
		//return ProductRepositoryImpl.getInstance(); // repository 객체를 static으로 메모리에 올려서 사용하는 첫번째 방법
	}												
	// 메서드를 구현해야 한다.
	public List<Product> getAllProducts();
	
	public Product getProductById(String id);
	
	public void addProduct(Product product);
}
