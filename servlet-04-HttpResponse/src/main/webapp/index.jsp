<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的交互网页</title>
</head>
<body>
    <div style="text-align: center">
        <%--以post的方式提交表单，提交到login请求--%>
        <form action="${pageContext.request.contextPath}/login" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="password" name="password"><br>
            爱好：
            <input type="checkbox" name="hobbys" value="登山">登山
            <input type="checkbox" name="hobbys" value="潜水">潜水
            <input type="checkbox" name="hobbys" value="踢球">踢球
            <input type="checkbox" name="hobbys" value="打豆豆">打豆豆<br>

            <input type="submit">
        </form>
    </div>
</body>
</html>
