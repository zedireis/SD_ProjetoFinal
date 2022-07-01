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
    <title>Registo de Utilizador</title>
</head>
<body>
<div id="header">
<p>Bem-vindo ao sistema eVote da Universidade de Coimbra! Por favor introduza as credenciais de registo de utilizador!</p>

<s:form action="registoSubmitUser" method="post">
    <s:radio label="Departamento" name="dep_id" list="#{'1':'DEI','2':'DEEC','3':'DEC','4':'DEM','5':'DEQ'}" value="dep_id" />
    <s:radio label="Sou um" name="tipo_id" list="#{'1':'Estudante','2':'Docente','3':'Funcionario'}" value="tipo_id" />
    <s:textfield name="username" label="Username"/><br>
    <s:password name="password" label="Password"/><br>
    <s:textfield name="nome" label="Nome"/><br>
    <s:textfield name="morada" label="Morada"/><br>
    <s:textfield name="nrTelemovel" label="Numero Telemovel"/><br>
    <s:textfield name="ccNumber" label="Numero de CC"/><br>
    Data de Validade CC:<br>
    <s:select label="Dia"
              headerKey="-1" headerValue="Dia"
              list="#{'1':'1', '2':'2', '3':'3', '4':'4', '5':'5', '6':'6', '7':'7', '8':'8', '9':'9', '10':'10', '11':'11', '12':'12', '13':'13', '14':'14', '15':'16', '17':'17', '18':'18', '19':'19', '20':'20', '21':'21', '22':'22', '23':'23', '24':'24', '25':'25', '26':'26', '27':'27', '28':'28', '29':'29', '30':'30', '31':'31'}"
              name="diaCC"
              value="diaCC" />
    <s:select label="Mês"
              headerKey="-1" headerValue="Mês"
              list="#{'1' : 'Janeiro', '2' : 'Fevereiro', '3' : 'Março', '4' : 'Abril', '5' : 'Maio', '6' : 'Junho', '7' : 'Julho', '8' : 'Agosto', '9' : 'Setembro', '10' : 'Outubro', '11' : 'Novembro', '12' : 'Dezembro'}"
              name="mesCC"
              value="mesCC" />
    <s:select label="Ano"
              headerKey="-1" headerValue="Ano"
              list="#{'2021':'2021', '2022':'2022', '2023':'2023', '2024':'2024','2025':'2025', '2026':'2026', '2027':'2027', '2028':'2028', '2029':'2029', '2030':'2030','2031':'2031', '2032':'2032'}"
              name="anoCC"
              value="anoCC" /><br>
    <s:submit />
</s:form>

</div>
</body>
</html>
