<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo 목록 보기</h1>
<div>
<%--    EL을 사용해서 todoList 접근--%>
    ${todolist}
<%--    상대경로이기 때문에 todo 폴더를 접근할 필요 없음--%>
        <a href="view">상세보기</a>
</div>
<div>
    <a href="create">새 Todo</a>
</div>
</body>
</html>
