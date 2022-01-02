package com.hanul.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class bookDAO {

	private Connection conn; 		//연결객체
	private PreparedStatement ps; 	//전송객체
	private ResultSet rs; 			//결과객체(select)
	
	//DB 접속 메소드
		public Connection getConn() {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
				String user = "hanul";
				String password = "0000";
				Class.forName("oracle.jdbc.driver.OracleDriver"); //동적로딩
				conn  = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getConn() Exception!!");
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
				System.out.println("dbClose() Exception !!");
			}
		}//dbClose()
		
		//전체회원 목록 검색
		public ArrayList<bookDTO> bookSearchAll() {
			conn = getConn();
			String sql = " select * from tblbook ";
			ArrayList<bookDTO> list = new ArrayList<>(); //최종결과를 저장할 자료구조를 생성
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					/* DTO 클래스의 초기화된  생성자 메소드를  이용하여 DTO객체를 생성하는 방법
					String memberName = rs.getString("memberName");
					String memberId = rs.getString("memberId");
					String memberPw = rs.getString("memberPw");
					int memberAge = rs.getInt("memberAge");
					String memberAddr = rs.getString("memberAddr");
					String memberTel = rs.getString("memberTel");
					MemberDTO dto = new MemberDTO(memberName, memberId, memberPw, memberAge, memberAddr, memberTel);
					*/
					
					//디폴트생성자메소드를 이용하여 DTO객체를 생성하는 방법
					bookDTO dto = new bookDTO();
					dto.setBooktitle(rs.getString("booktitle"));
					dto.setBookwriter(rs.getString("bookWriter"));
					dto.setBookisbn(rs.getString("bookIsbn"));
					dto.setBookcompany(rs.getString("bookCompany"));
					dto.setBookcost(rs.getInt("bookCost"));
					dto.setBookqty(rs.getInt("bookQty"));
					dto.setBookprice(rs.getInt("bookPrice"));
					
					list.add(dto);
					//System.out.println(list.size());
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("memberSearchAll() Exception !!");
			}finally {
				dbClose();
			}
			return list;
		}//memberSearchAll()
		
		//도서추가
		public int bookInsert(bookDTO dto) {
			conn = getConn(); // DB 접속
			String sql = " INSERT into tblbook values ( ?,?,?,?,?,?,?) ";	// SQL 문장작성
			int succ = 0;		//sql 문장의 성공여부 판단ㅇ하기위한 변수 (insert, delete, update)
			try {
				ps = conn.prepareStatement(sql);	//전송객체 생성
				ps.setString(1, dto.getBooktitle());
				ps.setString(2, dto.getBookwriter());
				ps.setString(3, dto.getBookisbn());
				ps.setString(4, dto.getBookcompany());
				ps.setInt(5, dto.getBookcost());
				ps.setInt(6, dto.getBookqty());
				ps.setInt(7, dto.getBookprice());
				succ = ps.executeUpdate();			//문장을 실행
			} catch (Exception e) {
				e.printStackTrace();	//예외 발생 시 예외코드를 상세하게 출력
				System.out.println("memberInsert() Exception !!"); // 예외메세지 출력
			}finally {
				dbClose();	//DB 접속 해제
			}
			return succ;	//결과(성공여부)를 리턴
		}//memberInsert()
		
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
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("memberDelete Exception");
			}finally {
				dbClose();
			}
			return succ;
		}
		
}
