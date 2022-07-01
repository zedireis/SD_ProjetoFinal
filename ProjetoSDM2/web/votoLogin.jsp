<%--
  Created by IntelliJ IDEA.
  User: Pedro | Ze
  Date: 10-05-2021
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sistema eVote</title>
</head>
<body>
<div id="header">
<p>Bem-vindo ao sistema eVote da Universidade de Coimbra! Por favor introduza as suas credenciais para votar!</p>
<s:form action="login" method="post">
    <s:textfield name="username" label="Username"/><br>
    <s:password name="password" label="Password"/><br>
    <s:submit />
</s:form>
</div>
</body>
</html>
