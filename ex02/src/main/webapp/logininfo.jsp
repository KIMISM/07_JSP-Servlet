<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 입력 파라미터 출력</h1>
<%--getParameter로 request.jsp에서 넘어온 데이터중 해당 키의 value값을 가져온다--%>
<%
    String userid = request.getParameter("userid");
    String password = request.getParameter("Password");
%>
<%--http://localhost:8080/logininfo.jsp?userid=김세진&Password=1234--%>
<%--주소로 받아온 값이 출력된다--%>
아이디값 : <%= userid %><br>
비밀번호 :<%= password %><br>
</body>
</html>
