
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Search page</title>
</head>
<body>
<div id="header">
</div>
<div id="main">
    <c:choose>
        <c:when test="${results.isEmpty()}">
            Não existem eleições a consultar. Espere que alguma termine!
        </c:when>

        <c:when test="${results.size() != 0}">

            <p>Por favor selecione a sua eleicao!</p>

            <s:form action="consultarEleicoesMenuVotar" method="post">
                <s:select headerKey="-1" headerValue="Selecionar Eleicao" label="Eleicoes disponíveis para votar" list="results" listValueKey="titulo" listKey="id" name="idEleicao" />
                <s:submit />
            </s:form>

        </c:when>

    </c:choose>

</div>
</body>
</html>
