<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>[구구단 출력]</h3>
<table border="1">
	<tr bgcolor="silver">
		<%for(int i =2; i <= 9; i++) {%>
			<th><font color="red"><%= i %>단</font></th>
		<%}//for %>
	</tr>
	<%for(int i =1; i<=9; i++) { %>
		<%if(i%2==0) { %>
			<tr bgcolor="yellow">
			<%for(int j=2; j<=9;j++) { %>
				<%if(i*j <10) { %>
					<td><%= j %> * <%= i %> = 0<%= j*i  %></td>
				<%} else{  %>
					<td><%= j %> * <%= i %> = <%= j*i  %></td>
				<%}//if%>
			<%}// 2for %>
		</tr>
		<%} else { %>
		<tr bgcolor="pink">
		<%for(int j=2; j<=9;j++) { %>
			<%if(i*j <10) { %>
				<td><%= j %> * <%= i %> = 0<%= j*i  %></td>
			<%} else{  %>
				<td><%= j %> * <%= i %> = <%= j*i  %></td>
			<%}//if%>
		<%}// 2for %>
	</tr>
		<%} %>
	<%}// 1for %>
</table>

<h3>[구구단 출력]</h3>
<table border="1">
	<tr bgcolor="silver">
		<%for(int i =2; i <= 9; i++) {%>
			<th><font color="red"><%= i %>단</font></th>
		<%}//for %>
	</tr>
	
	<%for(int i = 1; i<=9; i++) { %>
		<%if(i%2==0)	{ %>
			<tr bgcolor="yellow">
		<%} else {%>
			<tr bgcolor="pink">
		<%} %>
		
		<%for(int j=2; j<=9; j++){ %>
			<%if(i*j < 10) { %>
				<td><%= j %> * <%= i %> = 0<%= j*i  %></td>
			<%} else { %>
				<td><%= j %> * <%= i %> = <%= j*i  %></td>
			<%}//if %>
		<%}//for j %>
		</tr>
	<%} //for i%>
</table>
</div>
</body>
</html>