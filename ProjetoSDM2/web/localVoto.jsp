
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
    </div>
        <br />
        <p>| ----------------- Listas Votantes ----------------- |</p>
    <c:forEach items="${listaVotantes}" var="item">
        <div>
            Nome: <c:out value="${item.nome}" /> <br />
            Mesa de Voto: <c:out value="${item.mesaVoto}" /> <br />
            Momento: <c:out value="${item.momento}" /> <br />
        </div>
        <br />
    </c:forEach>

</div>
</body>
</html>
