<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 보기</h1>
<%
    String id = (String) session.getAttribute("userid");
    if(id == null) {
        //      userid 값을 못 찾아온 경우 loginForm.jsp로 회귀...
        response.sendRedirect("loginForm.jsp");
    }else{
//        제대로 userid값을 가져온 경우
        String pw = (String) session.getAttribute("Password");
        out.print("사용자 아이디값: " + id +"<br>");
        out.print("사용자 비밀번호값: " + pw +"<br>");
        out.print("<a href='logout.jsp'>로그 아웃</a>");
    }
%>
</body>
</html>
