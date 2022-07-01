
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Consultar Eleicao</title>
</head>
<body>
<div id="header">
</div>
<div id="main">

    <div>
        <p>Titulo: <c:out value="${eleicao.titulo}" /></p>
        <p>Descricao: <c:out value="${eleicao.descricao}" /></p>
        <p>Data de inicio: <c:out value="${eleicao.data_inicio}" /></p>
        <p>Data de fim: <c:out value="${eleicao.data_fim}" /></p>
        <p>Tipo: <c:out value="${tipo}" /></p>
        <p>Departamento: <c:out value="${dep}" /></p>
        <p>Total de votos: <c:out value="${total_votos}" /> ( 100 %)</p>
        <p>Votos em branco: <c:out value="${votos_branco}" /> ( <c:out value="${votos_branco_percent}" /> %)</p>
        <p>Votos nulos: <c:out value="${votos_nulos}" /> ( <c:out value="${votos_nulos_percent}" /> %)</p>
    </div>
        <br />
        <p>| ----------------- Listas Participantes ----------------- |</p>
    <c:forEach items="${listaList}" var="item">
        <div>
            Nome: <c:out value="${item.nome}" /> <br />
            Votos: <c:out value="${item.votos}" />  (<fmt:formatNumber pattern=" #,##0.00" value="${(item.votos/total_votos)*100}" /> %) <br />
        </div>
        <br />
    </c:forEach>

</div>
</body>
</html>
