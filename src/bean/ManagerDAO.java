package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ManagerDAO {
	private ManagerDAO() {}
	private static ManagerDAO instance = new ManagerDAO();
	public static ManagerDAO getInstance() { return instance; }
	
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
	// 회원 수 가져오기
	public int getCustomerCnt() {
		int cnt = 0;
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
		return cnt;
	}	
	// 등록된 상품 수 가져오기
	public int getItemCnt() {
		int cnt = 0;
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
		return cnt;
	}
	// 누적 주문량 가져오기
	public int getOrderCnt() {
		int cnt = 0;
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM buy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
		return cnt;
	}	
	// 관리자 로그인 체크
	public int checkManager(String id, String pw) {
		int check = 0;
		try {
			conn = getConnection();
			System.out.println("id = " + id);
			System.out.println("pw = " + pw);
			
			String sql = "SELECT * FROM manager WHERE id=? AND pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
		
		return check;
	}
	// 아이템 파일 업로드
	public void insertNewItem(ItemDTO dto) {
		try {
			conn = getConnection();
			
			int maxNum = 0;
			String sql = "SELECT MAX(item_number) FROM item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
			
			sql = "INSERT INTO item (item_number, item_category, item_name, item_price, item_stock, item_image, item_info, discount_rate, reg_date, sold)";
			sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, now(), 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxNum+1);
			pstmt.setString(2, dto.getItem_category());
			pstmt.setString(3, dto.getItem_name());
			pstmt.setInt(4, dto.getItem_price());
			pstmt.setInt(5, dto.getItem_stock());
			pstmt.setString(6, dto.getItem_image());
			pstmt.setString(7, dto.getItem_info());
			pstmt.setInt(8, dto.getDiscount_rate());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
	}
	
	public ArrayList<ItemDTO> getOneItem(int item_number) {
		ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM item WHERE item_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ItemDTO dto = new ItemDTO();
				
				dto.setItem_number(rs.getInt("item_number"));
				dto.setItem_category(rs.getString("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setItem_info(rs.getString("item_info"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSold(rs.getInt("sold"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
		
		return list;
	}
	// 파일 수정시 사진 선택안하면 기존 아이템 파일사진 가져오기
	public String getItemImage(int item_number) {
		
		String item_image = "";
		
		try {
			conn = getConnection();
			
			String sql = "SELECT item_image FROM item WHERE item_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				item_image = rs.getString(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}
		
		return item_image;
	}
	// 파일 수정
	public void updateItem(ItemDTO dto) {
		try {
			conn = getConnection();
			String sql = "UPDATE item SET item_category=?, item_name=?, item_price=?, item_stock=?, item_image=?, item_info=?, discount_rate=? WHERE item_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getItem_category());
			pstmt.setString(2, dto.getItem_name());
			pstmt.setInt(3, dto.getItem_price());
			pstmt.setInt(4, dto.getItem_stock());
			pstmt.setString(5, dto.getItem_image());
			pstmt.setString(6, dto.getItem_info());
			pstmt.setInt(7, dto.getDiscount_rate());
			pstmt.setInt(8, dto.getItem_number());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
		}
	}
	// 상품 삭제
	public void deleteItem(int item_number) {
		
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM item WHERE item_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
		}
		
	}
	// 주문현황 가져오기
	public ArrayList<BuyDTO> getAllOrderList() {
		ArrayList<BuyDTO> orderList = new ArrayList<BuyDTO>();
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM buy";
			
			pstmt = conn.prepareStatement(sql);
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
				
				orderList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(rs != null) { try { rs.close(); } catch(SQLException e) {} }
		}	
		
		return orderList;
	}
	
}




























