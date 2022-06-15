package com.webMarket.domain.model;

import java.util.Objects;

// 1. private 맴버 변수
// 2. 필요하면 생성자 추가
// 3. getter / setter
// 4. toString()
// 5. 추가) equals / haseCode 재정의 (오버라이드)
public class Product {	//	Serializable implements 생략 가능 - beans사용시 필요
	private String id;	// 상품 아이디
	private String name;		// 상품 명
	private int unitPrice;		// 상품 가격
	private String description;	// 상품 설명
	private String manufacturer;// 제조사
	private String category;	// 분류
	private long unitsInStock;	// 재고 수
	private String condition;	// 신상품 or 중고품 or 재생품
	
	public Product() {
		
	}
	
	public Product(String id, String name, int unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		this.id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", condition=" + condition + "]";
	}

	@Override
	public int hashCode() {		// override된 hashCode()는 같은 필드값으로 구성된 모든 Product 객체의 hashCode를 동일한 hashcode로 재정의
		return Objects.hash(category, condition, description, manufacturer, name, id, unitPrice, unitsInStock);
	}

	@Override
	public boolean equals(Object obj) {			
		if (this == obj)						
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(condition, other.condition)
				&& Objects.equals(description, other.description) && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(name, other.name) && Objects.equals(id, other.id)
				&& unitPrice == other.unitPrice && unitsInStock == other.unitsInStock;
	}
	
}
