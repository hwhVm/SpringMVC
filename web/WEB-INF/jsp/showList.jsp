<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        <%--function deleteItems(){--%>
            <%--//提交form--%>
            <%--document.itemsForm.action="${pageContext.request.contextPath }/deteleItem/>";--%>
            <%--document.itemsForm.submit();--%>
        <%--}--%>
        <%--function queryItems(){--%>
            <%--//提交form--%>
            <%--document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";--%>
            <%--document.itemsForm.submit();--%>
        <%--}--%>
    </script>
</head>

<body>
<p>
<table>
    <form name="itemsForm">
    <c:forEach var="message" items="${userList}">
        <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
        <tr>
            <td>${message.name}</td>
            <td>${message.age}</td>
            <td><a href="${pageContext.request.contextPath }/deteleItem?id=${userList[0].id}">detele</a></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
