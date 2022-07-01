
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Editar Eleicao</title>
</head>
<body>
<div id="header">
</div>
<div id="main">

    <p>Eleicao: <c:out value="${eleicao.titulo}" /></p>
    <br/>
    <br/>
<s:form action="editarSubmitEleicao" method="post">
    <s:textfield name="titulo" label="Título" value="%{eleicao.titulo}"/><br><br>
    <s:textfield name="descricao" label="Descricao" value="%{eleicao.descricao}"/><br><br>
    <s:textfield name = "dataInicio" format = "dd/MM/yyyy hh:mm" label="Data Inicio [dd-MM-yyyy hh:mm]" value="%{eleicao.data_inicio}"/>
    <s:textfield name = "dataFim" format = "dd/MM/yyyy hh:mm" label="Data Fim [dd-MM-yyyy hh:mm]" value="%{eleicao.data_fim}"/>
    <s:submit />
</s:form>

</div>
</body>
</html>
