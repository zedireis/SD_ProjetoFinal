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
    <p>Caro <c:out value="${votante.nome}" /> selecione a lista onde deseja efetuar o seu voto!</p>

    <s:form action="submitVotoLista" method="post">
        <s:radio label="Listas Disponíveis" name="idListaVotada" list="listasForVote" value="nome" listValueKey="nome" listKey="nome"/>
        <s:submit />
    </s:form>

</div>
</body>
</html>
