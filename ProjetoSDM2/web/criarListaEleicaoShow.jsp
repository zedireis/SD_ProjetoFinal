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
    <title>Nova eleição</title>
</head>
<body>
<div id="header">
    <p>Por favor introduza as credenciais de registo de lista para a eleicao<c:out value="${eleicao.titulo}" /></p>

<s:form action="registoSubmitListaEleicao" method="post">
    <s:textfield name="nomeLista" label="Titulo"/><br>
    <s:select label="Membros" name="ccMembros" list="results" value="tipo_id" multiple="true" listValueKey="nome" listKey="cc_number"/>
    <s:submit />
</s:form>

</div>
</body>
</html>
