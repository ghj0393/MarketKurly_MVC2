package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDAO {
	private BuyDAO() {}
	private static BuyDAO instance = new BuyDAO();
	public static BuyDAO getInstance() { return instance; }
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool");
		conn = ds.getConnection();
		return conn;		
	}
	// 구매목록에 상품 추가
	public void insertOrderList(BuyDTO dto) {
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO buy(customer_id, customer_name, cart_number, item_name, buy_price, buy_count, item_image, buy_date, howpay, address)"
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, now(), ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_id());
			pstmt.setString(2, dto.getCustomer_name());
			pstmt.setInt(3, dto.getCart_number());
			pstmt.setString(4, dto.getItem_name());
			pstmt.setInt(5, dto.getBuy_price());
			pstmt.setInt(6, dto.getBuy_count());
			pstmt.setString(7, dto.getItem_image());
			pstmt.setString(8, dto.getHowpay());
			pstmt.setString(9, dto.getAddress());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {conn.close();}catch(SQLException sql) {}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException sql) {}}
		}
	}
	// 상품 구매 후 업데이트 - 판매량 증가
	public void updateSold(String item_name, int buy_count) {
		int soldCnt = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT sold FROM item WHERE item_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				soldCnt = rs.getInt(1);
			}
			
			sql = "UPDATE item SET sold=? WHERE item_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, soldCnt+buy_count);
			pstmt.setString(2, item_name);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {conn.close();}catch(SQLException sql) {}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException sql) {}}
			if(rs != null) {try {rs.close();}catch(SQLException sql) {}}
		}
	}
	// 구매 완료 후 장바구니 비우기
	public void deleteCartList(String id) {
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM cart WHERE buyer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {conn.close();}catch(SQLException sql) {}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException sql) {}}
		}
	}
	// 해당id 구매내역 가져오기
	public ArrayList<BuyDTO> getBuyList(String id){
		
		ArrayList<BuyDTO> buyList = new ArrayList<BuyDTO>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM buy WHERE customer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BuyDTO dto = new BuyDTO();
				
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setCart_number(rs.getInt("cart_number"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setBuy_price(rs.getInt("buy_price"));
				dto.setBuy_count(rs.getInt("buy_count"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setBuy_date(rs.getString("buy_date"));
				dto.setHowpay(rs.getString("howpay"));
				dto.setAddress(rs.getString("address"));
				
				buyList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {conn.close();}catch(SQLException sql) {}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException sql) {}}
			if(rs != null) {try {rs.close();}catch(SQLException sql) {}}
		}
		
		return buyList;
	}
	
}
