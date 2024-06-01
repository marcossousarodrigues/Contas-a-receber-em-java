<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User" %>
<%@page import="java.util.ArrayList" %>
<%
   User userEdit  = (User) request.getAttribute("userEdit");
%>

<%@include file="/header/header.jsp" %>

<section class="container">
   
    

<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>

<h1>Usuários - Editar</h1>


<p class="message-error"></p>
<section class="forms">

    <form id="form-contact" action="/BillsToReceive/UserController" method="post">

        <input type="hidden" name="id" value="<%= userEdit != null ? userEdit.getId() : "" %>"/>
        <div class="label-input">
            <label>Nome</label>
            <input type="text" name="name" value="<%= userEdit != null ? userEdit.getName() : ""%>" class="name"/>
        </div>

        <div class="label-input">
            <label>Sobrenome</label>
            <input type="text" name="surname" value="<%= userEdit != null ? userEdit.getSurname() : "" %>" class="surname"/>
        </div>
        
        
        <div class="label-input">
            <label>E-mail</label>
            <input type="email" name="email" value="<%= userEdit != null ? userEdit.getEmail() : ""%>" class="email"/>
        </div>
        
        <div class="label-input">
            <label>Senha</label>
            <input type="password" name="password" value="<%= userEdit != null ? userEdit.getPassword() : "" %>" class="password"/>
        </div>
        
        <div class="label-select">
            <label>Permissão</label>
            <select name="permission">
                <option value="<%= userEdit.getPermission()%>"><%= userEdit != null ? userEdit.getPermission().equals("1") ? "Operador do Sistema" : "Administrador" : "" %></option>
                <option value="1">Operador do Sistema</option>
                <option value="2">Administrador</option>
            </select>
        </div>
                
        <div class="label-select">
            <label>Bloqueado</label>
            
            <select name="blocked">
                <option value="<%= userEdit != null ? userEdit.getBlocked() : "" %>"><%= userEdit.getBlocked().equals("1") ? "Sim" : "Não" %></option>
                <option value="1">Sim</option>
                <option value="2">Não</option>
            </select>
                
        </div>
        
        <div class="btn">
            <button type="submit" name ="action" class="btn-send" value="Update">Atualizar</button>
        </div>
    </form>
</section>

</section>
</body>
</html>
