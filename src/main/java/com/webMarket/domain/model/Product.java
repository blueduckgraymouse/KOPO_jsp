package com.webMarket.domain.model;

import java.io.Serializable;
import java.util.Objects;

// 1. private 맴버 변수
// 2. 필요하면 생성자 추가
// 3. getter / setter
// 4. toString()
// 5. 추가) equals / haseCode 재정의 (오버라이드)
public class Product implements Serializable {
		/* equals와 == 비교 확인 */
		public static void main(String[] args) {
			String a = "apple";
			//String b = "b";
			String b = new String("apple");
			String c = new String("apple");
			System.out.println(a.equals(b));	// true	, 변수 a와 b가 참조하는 데이터의 내용이 같은가?
			System.out.println(a.equals(c));	// true , 변수 a와 c가 참조하는 데이터의 내용이 같은가?
			System.out.println(a==b);			// false , 변수 a와 변수 b가 같은 데이터(주소)를 참조하는가?
			System.out.println(a==c);		 	// false , 변수 a와 변수 b가 같은 데이터(주소)를 참조하는가?
			System.out.println(b==c);		 	// false , 변수 a와 변수 b가 같은 데이터(주소)를 참조하는가?
			System.out.println(a.hashCode());
			System.out.println(b.hashCode());
			System.out.println(c.hashCode());
			System.out.println(a == b);			
			System.out.println(a == c);			
			System.out.println(b == c);			
			
			Product product1 = new Product("12", "11", 11);
			Product product2 = new Product("12", "11", 11);
			Product product3 = product2;
			System.out.println(product1.hashCode());
			System.out.println(product2.hashCode());
//			System.out.println(product1 == product2);						// false, 데이터 영역 비교
//			System.out.println(product1.hashCode() == product2.hashCode());	// true, 힙 영역 비교 => 원래 객체 내 데이터가 일치하면 hashcode가 같은건가??
//			System.out.println(product2 == product3);						// false, 데이터 영역 비교
//			System.out.println(product2.hashCode() == product3.hashCode());	// true, 힙 영역 비교 => 원래 객체 내 데이터가 일치하면 hashcode가 같은건가??
//			System.out.println(product1.equals(product2));
//			
//			product1.setId("13");		
//			System.out.println(product1.hashCode());
//			System.out.println(product2.hashCode());
//			System.out.println(product1.hashCode() == product2.hashCode());	// false, 힙 영역 비교
//			
//			product1.setId("12");
//			System.out.println(product1.equals(product2));	// true, override를 통해서 내용비교를 통한 일치여부 메서드로 바꿔줬으므로
//			System.out.println(product1.hashCode() == product2.hashCode());	// true, 앞의 equals메서드에서 비교를 하며 같으면 hashcode를 일치시키는 코드가 존재했으므로 -> 라고 필기한거 같은데 위에서 그냥 객쳋 내 데이터가 같으면 hashcode가 일치해버림
//			System.out.println(product1 == product2);	// false, stack 영역에 존재하는 "product1", "product2"라는 객체 명을 비교하는 것이므로  
		}
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
	public int hashCode() {
		return Objects.hash(category, condition, description, manufacturer, name, id, unitPrice, unitsInStock);
	}

//	@Override
//	public boolean equals(Object obj) {			// 기존에 동일한 필드값의 두 객체지만 hashcode가 달랐지만
//		if (this == obj)						// equals메서드를 거치면서 hashcode가 동일하게 수정되어 진다.
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return Objects.equals(category, other.category) && Objects.equals(condition, other.condition)
//				&& Objects.equals(description, other.description) && Objects.equals(manufacturer, other.manufacturer)
//				&& Objects.equals(name, other.name) && Objects.equals(id, other.id)
//				&& unitPrice == other.unitPrice && unitsInStock == other.unitsInStock;
//	}
	
	
}
