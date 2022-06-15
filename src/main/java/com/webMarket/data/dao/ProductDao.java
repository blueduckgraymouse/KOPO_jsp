package com.webMarket.data.dao;

import java.util.List;

import com.webMarket.domain.model.Product;

// Data Access Object
public interface ProductDao {
	// interface 안에 작성한 멤버는 public final static이 생략되어있다.(default)
	String TABLE_NAME = "product";
	String COLUMN_ID = "p_id";
	
	// interface 안에서는 public abstract가 default
	List<Product> getAll();
	
	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
}
