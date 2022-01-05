<%@ page import="com.hanul.study.SumMachine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP02</title>
</head>
<body>
<%
SumMachine sm = new SumMachine();
int sum =sm.getSum(10, 30);
pageContext.setAttribute("sum", sum);	//바인딩(연결) 객체 : scope 설정
%>
누적합 : <%= sum %><br>
누적합 : ${sum}<%-- EL 표현식을 이용한 출력 --%>
</body>
</html>