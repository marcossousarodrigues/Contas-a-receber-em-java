<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Nature" %>
<%@page import="java.util.ArrayList" %>
<%
   ArrayList<Nature> list = (ArrayList<Nature>) request.getAttribute("natures");
   String searchMessage = (String) request.getAttribute("searchMessage");
%>

<%@include file="/header/header.jsp" %>

<section class="container">

    <section class="container-legend">
        <h3>Legendas</h3>
        <div class="legend-description">
            <p>Bloquedo</p>
            <div class="legend legend-red-blocked"></div>
        </div>
        <div class="legend-description">
            <p>Não Bloquedo</p>
            <div class="legend legend-green-blocked"></div>
        </div>
    </section>
    
<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>
<h1>Naturezas Financeira</h1>

<div class="button-add">
    <a href="/BillsToReceive/pages/nature/toAdd.jsp">
        <img src="/BillsToReceive/img/icon-add-button.png">
    </a>
</div>

<h2><%= searchMessage != null ? searchMessage : ""  %></h2>
<section class="form-search">
    <form action="/BillsToReceive/NatureController" method="post">
        <div class="label-input">
            <label>Pesquisar</label>
            <input type="text" name="fieldValue" class="fieldValue" placeholder="Digite aqui..."/>
        </div>
        <div class="label-input">
            <label>Pesquisar por:</label>
            <select name="field" class="field">
                <option value="id">Id</option>
                <option value="name">Name</option>
                <option value="description">Descrição</option>
            </select>
        </div>
        <div class="btn">
            <button type="submit" name ="action" class="btn-send" value="Find">Buscar</button>
        </div>
    </form>
</section>

<section class="tables">

    <table border="1">
        <thead>
            <tr>
                <th>Legenda</th>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Tipo</th>
                <th>Centro de Custo</th>
                <th>Conta Contabil</th>
                <th>Bloqueado</th>
            </tr>
        </thead>
        <tbody>
            <% for(int i = 0; i < list.size(); i++){%>
            <tr>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend <%= list.get(i).getBlocked().equals("1") ? "legend-red-blocked" : "legend-green-blocked" %>"></div></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getId() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getName() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getDescription() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getType() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getCostCenter() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getAccount() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getBlocked().equals("1") ? "Sim" : "Não" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/NatureController?action=Read&id=<%= list.get(i).getId()%>"><img class="img-btns" src="/BillsToReceive/img/edit.png"></a></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/NatureController?action=Delete&id=<%= list.get(i).getId()%>"><img class="img-btns" src="/BillsToReceive/img/delete.png"></a></td>
            </tr>
            <%}%>
        </tbody>
    </table>

</section>


</section>
</body>
</html>
