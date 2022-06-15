package com.webMarket.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webMarket.domain.model.Product;

public class MysqlProductDaoImpl implements ProductDao {
//	private final static String TABLE_NAME = "product";
//	private final static String COLUMN_ID = "p_id";
	
	public MysqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
		} catch (Exception e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");	// 앱을 끝냄
		}
	}
	
	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		String sql = "select * from product";
		
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "abcd1234");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			) {
			while (rs.next()) {
				String id = rs.getString(COLUMN_ID);
				String name = rs.getString("p_name");
				int unitPrice = rs.getInt("p_unitPrice");
				String description = rs.getString("p_description");
				String manufacturer = rs.getString("p_manufacturer");
				String category = rs.getString("p_category");
				Long unitsInStock = rs.getLong("p_unitsInStock");
				String condition = rs.getString("p_condition");
				
				Product product = new Product(id, name, unitPrice);
				product.setDescription(description);
				product.setCategory(category);
				product.setManufacturer(manufacturer);
				product.setUnitsInStock(unitsInStock);
				product.setCondition(condition);
				
				products.add(product);
			}
		} catch(SQLException e) {
			//e.printStackTrace(); // 에러 stack 콘솔에 출력, 프로그램은 그대로 진행
			
			//throw new IllegalStateException("db 연결 실패");
			//	-> 에러 메세지가 에러를 찾기 어렵게 알려준다. (거의 결과만 알려줌)
			
			throw new IllegalStateException("db 연결 실패" + e.getMessage());	// 프로그램 종료, 에러 메세지 출력
			
		}
		
		return products;
	}

	
	@Override
	public void insert(Product product) {
		// PreparedStatement 동적 쿼리 : DML(insert, update, delete) 여러 번 할 때 고속
		String sql = "insert into product values(?, ?, ?, ?, ?, ?, ?, ?)";
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "abcd1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, product.getId());
				pstmt.setString(2, product.getName());
				pstmt.setInt(3, product.getUnitPrice());
				pstmt.setString(4, product.getDescription());
				pstmt.setString(5, product.getCategory());
				pstmt.setString(6, product.getManufacturer());
				pstmt.setLong(7, product.getUnitsInStock());
				pstmt.setString(8, product.getCondition());
				
				pstmt.executeUpdate();	// 업데이트 된 레코드 수 리턴
		} catch(SQLException e) {
			throw new IllegalStateException("insert 실패 : " + e.getMessage());
		}
	}

	
	@Override
	public void update(Product product) {
		// PreparedStatement 동적 쿼리 : DML(insert, update, delete) 여러 번 할 때 고속
		String sql = "update ? set p_name=?, p_unitPrice=?, p_description=?, p_manufacturer=?, p_category=?, p_unitsInStock=?, p_condition=?";
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "abcd1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, TABLE_NAME);
				pstmt.setString(2, product.getName());
				pstmt.setInt(3, product.getUnitPrice());
				pstmt.setString(4, product.getDescription());
				pstmt.setString(5, product.getCategory());
				pstmt.setString(6, product.getManufacturer());
				pstmt.setLong(7, product.getUnitsInStock());
				pstmt.setString(8, product.getCondition());
			
				pstmt.executeUpdate();	// 업데이트 된 레코드 수 리턴
		} catch(SQLException e) {
			throw new IllegalStateException("update 실패 : " + e.getMessage());
		}
	}

	
	@Override
	public void delete(Product product) {
		// PreparedStatement 동적 쿼리 : DML(insert, update, delete) 여러 번 할 때 고속
		String sql = "delete from ? where p_id=?";
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "abcd1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, TABLE_NAME);
				pstmt.setString(2, product.getId());
			
				pstmt.executeUpdate();	// 업데이트 된 레코드 수 리턴
		} catch(SQLException e) {
			throw new IllegalStateException("delete 실패 : " + e.getMessage());
		}
	}

}
