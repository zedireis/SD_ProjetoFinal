
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
        <c:when test = "${idEleicao != null}">
            <p>Eleicao: <c:out value="${eleicao.titulo}" /></p>
            <br/>
            <br/>
            <s:url action="criarCandidatura" var="candidaturaUrl" />
            <s:url action="alterarPropsEleicao" var="alterarUrl" />
            Por favor escolha a funcionalidade pretendida: <br/>
            <s:a href="%{candidaturaUrl}" >Criar candidatura de uma lista!</s:a> <br/>
            <s:a href="%{alterarUrl}" >Alterar propriedades da eleição!</s:a> <br/>
        </c:when>

        <c:when test="${results.isEmpty()}">
            Não existem eleições registadas no sistema ou já todas começaram. Crie uma nova no menu principal!
        </c:when>

        <c:when test="${results.size() != 0}">

            <p>Por favor selecione a sua eleicao!</p>

            <s:form action="gerirEleicoesMenu" method="post">
                <s:select headerKey="-1" headerValue="Selecionar Eleicao" label="Eleicoes disponíveis" list="results" listValueKey="titulo" listKey="id" name="idEleicao" />
                <s:submit />
            </s:form>

        </c:when>

    </c:choose>

</div>
</body>
</html>
