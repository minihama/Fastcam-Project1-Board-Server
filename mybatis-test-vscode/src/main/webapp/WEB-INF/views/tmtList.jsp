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
    <%ArrayList<TmtVO> list = (ArrayList<TmtVO>)request.getAttribute("list");%>
    <table border="1px solid black">
        <tr>
            <td> 번호 </td>
            <td> 이름 </td>
            <td> 실행여부 </td>
            <td> 시작 날짜 </td>
        </tr>
        <%for(int i=0;i<list.size();i++){ %>
        <tr>
            <td><%= i %></td>
            <td><a href="tmtSelect.do?id=<%=list.get(i).getId()%>"><%= list.get(i).getName() %></a></td>
            <td><%= list.get(i).getStatus() %></td>
            <td><%= list.get(i).getStartdate() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>