<%@ page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
//MVC Project에서 학습했던 Servlet 코드(Servlet03.java) : 순수 자바 코드(POJO)

//DTO 클래스의 초기화된  생성자 메소드를  이용하여 DTO객체를 생성하는 방법
/* request.setCharacterEncoding("utf-8");//인코딩 설정
String memberName = request.getParameter("memberName");
String memberId = request.getParameter("memberId");
String memberPw = request.getParameter("memberPw");
int memberAge = Integer.parseInt(request.getParameter("memberAge"));
String memberAddr = request.getParameter("memberAddr");
String memberTel = request.getParameter("memberTel");
MemberDTO dto = new MemberDTO(memberName, memberId, memberPw, memberAge, memberAddr, memberTel); */

//디폴트생성자메소드를 이용하여 DTO객체를 생성하는 방법
request.setCharacterEncoding("utf-8");
MemberDTO dto = new MemberDTO();
dto.setMemberName(request.getParameter("memberName"));
dto.setMemberId(request.getParameter("memberId"));
dto.setMemberPw(request.getParameter("memberPw"));
dto.setMemberAge(Integer.parseInt(request.getParameter("memberAge")));
dto.setMemberAddr(request.getParameter("memberAddr"));
dto.setMemberTel(request.getParameter("memberTel"));
--%>
<% request.setCharacterEncoding("utf-8"); //인코딩 설정%>
<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<%-- <jsp:setProperty property="memberName" name="dto"/>
	<jsp:setProperty property="memberId" name="dto"/>
	<jsp:setProperty property="memberPw" name="dto"/> --%>
	<jsp:setProperty property="*" name="dto"/>	
</jsp:useBean>

<jsp:useBean id="dao" class="com.hanul.study.MemberDAO" />

<%
int  succ =dao.insertMember(dto);
if(succ > 0){
	out.println("<script>alert('회원가입 성공!');");
	out.println("location.href='jsp05Main.html';</script>");
}else{
	out.println("<script>alert('회원가입 실패!');");
	out.println("location.href='jsp05Main.html';</script>");
}
%>
