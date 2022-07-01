<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Bem-vindo ao sistema de voto eletrónico da Universidade de Coimbra!</title>
  </head>
  <body>
  <s:url action="modoAdmin" var="modoAdminUrl" />
  <s:url action="votoEleitor" var="votoEleitorUrl" />
  <s:url action="carSearch" var="carSearchUrl" />
  <s:url action="laptopSearch" var="laptopSearchUrl" />
  <s:url action="shoesSearch" var="shoesSearchUrl" />

  Por favor escolha a funcionalidade pretendida: <br/>
  Entrar na administração <s:a href="%{modoAdminUrl}" >click here!</s:a> <br/>
  Entrar em modo votante <s:a href="%{votoEleitorUrl}" >click here!</s:a> <br/>
  Cars <s:a href="%{carSearchUrl}" >click here!</s:a> <br/>
  Laptops <s:a href="%{laptopSearchUrl}" >click here!</s:a>  <br/>
  Shoes  <s:a href="%{shoesSearchUrl}" >click here!</s:a> <br/>

  </body>
</html>
