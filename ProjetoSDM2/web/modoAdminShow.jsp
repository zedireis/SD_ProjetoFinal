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
    <title>Modo admin do sistema de voto eletrónico da Universidade de Coimbra!</title>
</head>
<body>
    <s:url action="resgistarUser" var="registarUserUrl" />
    <s:url action="criarEleicao" var="criarEleicaoUrl" />
    <s:url action="gerirEleicoesSearch" var="gerirEleicoesUrl"/>
    <s:url action="consultarEleicoesSearch" var="consultarEleicoesUrl"/>
    <s:url action="consultarVotosSearch" var="consultarLocalUrl"/>

    Por favor escolha a funcionalidade pretendida: <br/>
    Registar novo utilizador <s:a href="%{registarUserUrl}" >click here!</s:a> <br/>
    Criar nova eleição <s:a href="%{criarEleicaoUrl}" >click here!</s:a> <br/>
    Gerir Listas <s:a href="%{gerirEleicoesUrl}" >click here!</s:a> <br/>
    Consultar estatisticas de uma eleicao <s:a href="%{consultarEleicoesUrl}" >click here!</s:a> <br/>
    Consultar locais de voto dos eleitores<s:a href="%{consultarLocalUrl}" >click here!</s:a> <br/>
</body>
</html>
