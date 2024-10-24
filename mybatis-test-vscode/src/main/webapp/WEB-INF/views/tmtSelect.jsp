<%@page import="com.mybatis.mybatis_test.TmtVO"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset="UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% TmtVO vo = (TmtVO)request.getAttribute("vo"); %>
    <table border="1px solid black">
        <tr>
            <td>번호</td>
            <td><%= vo.getId() %></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><%= vo.getName() %></td>
        </tr>
        <tr>
            <td>실행여부</td>
            <td><%= vo.getStatus() %></td>
        </tr>
        <tr>
            <td>시작 날짜</td>
            <td><%= vo.getStartdate() %></td>
        </tr>
    </table>
</body>
</html>