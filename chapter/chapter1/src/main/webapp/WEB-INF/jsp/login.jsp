<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--login.jsp放在jsp目录下，无法通过URL进行调用，由LoginController控制类中标注了@RequestMapping(value = "/login.html")的loginPage（）转发--%>
<html>
<head>
    <title>网站登录</title>
</head>
<body>
<c:if test="${!empty error}">   <%--使用JSTL标签对登陆错误返回信息进行处理--%>
    <font color="red"><c:out value="${error}"/></font>
    <%--引用的error变量，正是LoginController返回的ModelAndView("login", "error", "用户名或密码错误")对象的error--%>
</c:if>
<form action="<c:url value="/admin/loginCheck.html"/>" method="post">
    用户名：
    <input type="text" name="userName">
    <br>
    密 码：
    <input type="password" name="password">
    <br>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
