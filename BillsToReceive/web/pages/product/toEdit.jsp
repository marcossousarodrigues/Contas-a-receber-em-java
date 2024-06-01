<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Product" %>
<%@page import="java.util.ArrayList" %>
<%
   Product productEdit  = (Product) request.getAttribute("productEdit");
%>

<%@include file="/header/header.jsp" %>

<section class="container">
   
    

<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>

<h1>Produtos - Editar</h1>


<p class="message-error"></p>
<section class="forms">

    <form id="form-contact" action="/BillsToReceive/ProductController" method="post">

        <input type="hidden" name="id" value="<%= productEdit.getId()%>"/>
        <div class="label-input">
            <label>Nome</label>
            <input type="text" name="name" value="<%= productEdit.getName()%>" class="date"/>
        </div>

        <div class="label-input">
            <label>Descrição</label>
            <input type="text" name="description" value="<%= productEdit.getDescription()%>" class="description"/>
        </div>
        
        <div class="label-input">
            <label>Preço</label>
            <input type="text" name="price" value="<%= productEdit.getPrice()%>" class="price"/>
        </div>
        
        <div class="label-select">
            <label>Bloqueado</label>
            <select name="blocked">
                <option value="<%= productEdit.getBlocked().equals("1") ? "1" : "2" %>"><%= productEdit.getBlocked().equals("1") ? "Sim" : "Não" %></option>
                <option value="2">Não</option>
                <option value="1" >Sim</option>
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
