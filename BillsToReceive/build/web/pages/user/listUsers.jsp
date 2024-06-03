<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User" %>
<%@page import="java.util.ArrayList" %>
<%
   ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
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
<h1>Lista de Usuários</h1>

<div class="button-add">
    <a href="/BillsToReceive/pages/user/toAdd.jsp">
        <img src="/BillsToReceive/img/icon-add-button.png">
    </a>
</div>

<h2><%= searchMessage != null ? searchMessage : ""  %></h2>

<section class="form-search">
    <form action="/BillsToReceive/UserController" method="post">
        <div class="label-input">
            <label>Pesquisar</label>
            <input type="text" name="fieldValue" class="name-field" placeholder="Digite aqui..."/>
        </div>
        <div class="label-input">
            <label>Pesquisar por:</label>
            <select name="field" class="field">
                <option value="id">Id</option>
                <option value="name">Name</option>
                <option value="surname">Sobrenome</option>
                <option value="email">E-mail</option>
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
                <th>Surname</th>
                <th>E-mail</th>
                <th>Permissão</th>
                <th>Bloqueado</th>
            </tr>
        </thead>
        <tbody>
            <% for(int i = 0; i < list.size(); i++){%>
            <tr>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend <%= list.get(i).getBlocked().equals("1") ? "legend-red-blocked" : "legend-green-blocked" %>"></div></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getId() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getName() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getSurname() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getEmail() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getPermission().equals("1") ? "Operador do Sistema" : "Administrador" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getBlocked().equals("1") ? "Sim" : "Não" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/UserController?action=Read&id=<%= list.get(i).getId()%>"><img class="img-btns" src="/BillsToReceive/img/edit.png"></a></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/UserController?action=Delete&id=<%= list.get(i).getId()%>"><img class="img-btns" src="/BillsToReceive/img/delete.png"></a></td>
            </tr>
            <%}%>
        </tbody>
    </table>

</section>


</section>
</body>
</html>
