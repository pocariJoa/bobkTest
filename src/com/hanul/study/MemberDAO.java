package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {	//DB와 연동하여 트랜잭션(요청)을 처리
	private Connection conn;			//연결객체
	private PreparedStatement ps;		//전송객체
	private ResultSet rs;				//결과객체(select 쿼리)
	
	//DB 접속 : ojdbc8.jar ▶ WebContent > WEB-INF > lib : 복붙
	public Connection getConn() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "hanul";
			String password = "0000";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception");
		}
		return conn;
	}//getConn()
	
	//DB 접속 해제
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception");
		}
	}//dbClose()
	
	//회원가입
	public int insertMember(MemberDTO dto) {
		conn = getConn();	//db접속
		String sql = " insert into Member values (?, ?, ?, ?, ?, ?) " ;	//sql 문장 작성
		int succ = 0;		//성공여부를 판달할 변수를 초기화
		try {
			ps = conn.prepareStatement(sql);	//전송객체 생성
			ps.setString(1, dto.getMemberName());
			ps.setString(2, dto.getMemberId());
			ps.setString(3, dto.getMemberPw());
			ps.setInt(4, dto.getMemberAge());
			ps.setString(5, dto.getMemberAddr());
			ps.setString(6, dto.getMemberTel());
			succ = ps.executeUpdate();
		} catch (Exception e) {		//예외처리
			e.printStackTrace();
			System.out.println("insertMember() Exception");
		}finally {					//DB 접속 해제
			dbClose();
		}
		return succ;
	}//insertMember()
	
	//전체회원 목록검색 : select
	public ArrayList<MemberDTO> searchAllMember() {
		conn = getConn();
		String sql = " select * from Member ";
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				//String memberName = rs.getString("memberName");
				//String memberId = rs.getString("MemberId");
				//String memberPw = rs.getString("MemberPw");
				//int memberAge = rs.getInt("MemberAge");
				//String memberAddr = rs.getString("MemberAddr");
				//String memberTel = rs.getString("MemberTel");
				//MemberDTO dto = new MemberDTO(memberName, memberId, memberPw, memberAge, memberAddr, memberTel);
				
				MemberDTO dto = new MemberDTO();
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberId(rs.getString("MemberId"));
				dto.setMemberPw(rs.getString("MemberPw"));
				dto.setMemberAge(rs.getInt("MemberAge"));
				dto.setMemberAddr(rs.getString("MemberAddr"));
				dto.setMemberTel(rs.getString("MemberTel"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchAllMember() Exception");
		}finally {
			dbClose();
		}
		return list;
	}
	
	//회원정보 삭제 : delete
	public int deleteMember(String MemberId) {
		conn = getConn();
		String sql = " delete from Member where memberId = ? ";
		int succ= 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, MemberId);
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		return succ;
	}
	
	//특정회원의 정보 검색 : select
	public MemberDTO getById(String memberId) {
		conn = getConn();
		String sql = " SELECT * FROM MEMBER WHERE memberId = ? ";
		MemberDTO dto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberPw(rs.getString("memberPw"));
				dto.setMemberAge(rs.getInt("memberAge"));
				dto.setMemberAddr(rs.getString("memberAddr"));
				dto.setMemberTel(rs.getString("memberTel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getById() Exception");
		}finally {
			dbClose();
		}
		return dto;
	}//getById
	
	//회원정보 수정 : update
	public int updateMember(MemberDTO dto) {
		conn = getConn();
		String sql = " UPDATE MEMBER SET MEMBERNAME = ? , MEMBERPW = ?, MEMBERAGE = ?, ";
			sql	+= "MEMBERADDR = ?, MEMBERTEL = ? WHERE MEMBERID = ?";
		int succ= 0;
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, dto.getMemberName());
			ps.setString(2, dto.getMemberPw());
			ps.setInt(3, dto.getMemberAge());
			ps.setString(4, dto.getMemberAddr());
			ps.setString(5, dto.getMemberTel());
			ps.setString(6, dto.getMemberId());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateMember Exception");
		}finally {
			dbClose();
		}
		return succ;
	}//updateMember()
}



