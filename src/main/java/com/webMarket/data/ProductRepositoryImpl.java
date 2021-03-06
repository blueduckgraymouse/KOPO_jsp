package com.webMarket.data;

import java.util.ArrayList;
import java.util.List;

import com.webMarket.domain.model.Product;
import com.webMarket.domain.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
	private List<Product> products = new ArrayList<>();	
	
	// 싱글턴 패턴
	// 1. static 인스턴스 준비
	// 2. static 메서드로 인스턴스 리턴 (getInstance() 이름을 주로 씀)
	// 3. 생성자 막기 (private)
	private static ProductRepositoryImpl instance = new ProductRepositoryImpl();
	
	public static ProductRepositoryImpl getInstance() {
		return instance;
	}
	
	private ProductRepositoryImpl() {		// 생성자를 private로 변경, static인 instance를 이용하도록 유도 -> "singleton pattern"
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334X750 Renina HD display, 8-megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");

		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("13.3-inch, IPS LED display, 5rd Generation Intel Core processors");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("LG");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refurbished");

		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("212.8*125.6*6.6mm,  Super AMOLED display, Octa-Core processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Samsung");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");

		products.add(phone);
		products.add(notebook);
		products.add(tablet);
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}
	
	
//	public Product getProductById(String id) {
//		Product productById = null;
//
//		for (int i = 0; i < products.size(); i++) {
//			Product product = products.get(i);
//			if (product != null && product.getId() != null && product.getId().equals(id)) {
//				productById = product;
//				break;
//			}
//		}
//	}
//	=>	
	@Override
	public Product getProductById(String id) {
		// List를 stream(데이터의 흐름)으로 변환
		return products.stream()
			.filter((product) -> product.getId().equals(id))	// 조
			.findFirst()	// 첫번쨰
			.get();			// 얻어
	}
	
	@Override
	public void addProduct(Product product) {
		products.add(product);
	}

//	public static void main(String[] args) {
//        // 삽입, 삭제가 빈번할 때 항상 동일 성능, but ArrayList보다 검색이 느려
//        // 메모리 조금 더 많이 먹어
//        List<Product> products = new LinkedList<>();
//
//        // 크기가 커질수록 삽입, 삭제가 느려짐, 내부적으로 배열이라 성능이 일단 빨라
//        List<Product> products2 = new ArrayList<>();
//
//        Product[] product3 = new Product[3];
//
//        sort(Arrays.asList(product3));
//
//        sort(products);
//        Stack stack = (Stack) sort(products2);
//    }
//
//    public static List<Product> sort(List<Product> products) {
//        // 정렬.....
//        return new LinkedList<>();
//    }
}
