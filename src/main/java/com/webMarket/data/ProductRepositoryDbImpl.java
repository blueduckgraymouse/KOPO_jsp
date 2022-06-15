package com.webMarket.data;

import java.util.List;

import com.webMarket.data.dao.ProductDao;
import com.webMarket.domain.model.Product;
import com.webMarket.domain.repository.ProductRepository;

public class ProductRepositoryDbImpl implements ProductRepository {
	private ProductDao dao;
	
	public ProductRepositoryDbImpl(ProductDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return dao.getAll();
	}

	@Override
	public Product getProductById(String id) {
		return dao.getAll().stream()
				.filter((product) -> product.getId().equals(id))	// 조
				.findFirst()	// 첫번쨰
				.get();			// 얻어
	}

	@Override
	public void addProduct(Product product) {
		dao.insert(product);
	}

}
