package com.hanul.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class bookDAO {

	private Connection conn;		
	private PreparedStatement ps;
	private ResultSet rs;
	
	//DB 접속 메소드
	public Connection getConn() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "hanul";
			String password = "0000";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn  = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn 에러");
		}
		return conn;
	}//getConn()
		
	//DB 접속 해제 메소드
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose 에러");
		}
	}//dbClose()
	
	//전체회원 목록 검색
	public ArrayList<bookDTO> bookSearchAll() {
		conn = getConn();
		String sql = " select * from tblbook ";
		ArrayList<bookDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				bookDTO dto = new bookDTO();
				dto.setBooktitle(rs.getString("booktitle"));
				dto.setBookwriter(rs.getString("bookWriter"));
				dto.setBookisbn(rs.getString("bookIsbn"));
				dto.setBookcompany(rs.getString("bookCompany"));
				dto.setBookcost(rs.getInt("bookCost"));
				dto.setBookqty(rs.getInt("bookQty"));
				dto.setBookprice(rs.getInt("bookPrice"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("bookSearchAll 에러");
		}finally {
			dbClose();
		}
		return list;
	}//bookSearchAll
	
	//도서추가
	public int bookInsert(bookDTO dto) {
		conn = getConn(); // DB 접속
		String sql = " INSERT INTO tblbook values ( ?,?,?,?,?,?,?) ";
		int succ = 0;		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBooktitle());
			ps.setString(2, dto.getBookwriter());
			ps.setString(3, dto.getBookisbn());
			ps.setString(4, dto.getBookcompany());
			ps.setInt(5, dto.getBookcost());
			ps.setInt(6, dto.getBookqty());
			ps.setInt(7, dto.getBookprice());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("bookInsert 에러");
		}finally {
			dbClose();	
		}
		return succ;	
	}//bookInsert
	
	//회원정보 삭제
	public int bookDelete(String Bookisbn) {
			conn = getConn();
			String sql = " delete from tblbook where bookIsbn= ? ";
			int succ = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, Bookisbn);
				succ = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("bookDelete 에러");
			}finally {
				dbClose();
			}
			return succ;
		}
}
