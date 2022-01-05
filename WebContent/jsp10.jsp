<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="dto"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP10</title>
</head>
<body>
<h3>JAVA 코드를 이용한 출력</h3>
이름(JAVA) : <%= dto.getMemberName() %> <br>
아이디(JAVA) : <%= dto.getMemberId() %>	<br>
주소(JAVA) : <%= dto.getMemberAddr() %> <br>

<h3>[Action Tag를 이용한 출력]</h3>
이름(Action) : <jsp:getProperty property="memberName" name="dto"/> <br>
아이디(Action) : <jsp:getProperty property="memberId" name="dto"/> <br>
주소(Action) : <jsp:getProperty property="memberAddr" name="dto"/> <br>

<h3>[El(Expression Language)을 이용한 출력]</h3>
이름(EL) : ${dto.memberName} <br>
아이디(EL) : ${dto.memberId } <br>
주소(EL) : ${dto.memberAddr } <br>
</body>
</html>