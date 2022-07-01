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
<p>Bem-vindo ao sistema eVote da Universidade de Coimbra! Por favor introduza as credenciais de registo de eleição!</p>

<s:form action="registoSubmitEleicao" method="post">
    <s:radio label="Departamento" name="dep_id" list="#{'1':'DEI','2':'DEEC','3':'DEC','4':'DEM','5':'DEQ'}" value="dep_id" />
    <s:radio label="Sou um" name="tipo_id" list="#{'1':'Estudante','2':'Docente','3':'Funcionario'}" value="tipo_id" />
    <s:textfield name="titulo" label="Titulo"/><br>
    <s:textfield name="descricao" label="Descricao"/><br>
    <s:textfield name = "dataInicio" format = "dd/MM/yyyy hh:mm" label="Data Inicio [yyyy-MM-dd hh:mm]" />
    <s:textfield name = "dataFim" format = "dd/MM/yyyy hh:mm" label="Data Fim [yyyy-MM-dd hh:mm]"/>
    <s:submit />
</s:form>

</div>
</body>
</html>
