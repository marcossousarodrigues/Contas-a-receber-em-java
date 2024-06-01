<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Client" %>
<%@page import="java.util.ArrayList" %>
<%
   Client clientEdit  = (Client) request.getAttribute("clientEdit");
%>

<%@include file="/header/header.jsp" %>

<section class="container">
  
    

    <img src="/BillsToReceive/img/logo-green.png" alt="alt"/>

    <h1>Clientes - Editar</h1>


    <p class="message-error"></p>
    <section class="forms">

        <form id="form-contact" action="/BillsToReceive/ClientController" method="post">
            <input type="hidden" name="id" value="<%= clientEdit.getId()%>"/>
            <div class="label-input">
                <label>Name</label>
                <input type="text" name="name" value="<%= clientEdit.getName() %>" class="name"/>
            </div>

            <div class="label-select">
                <label>Tipo de Pessoa</label>
                <select name="person">
                    <option value="<%= clientEdit.getPerson() %>"><%= clientEdit.getPerson() %></option>
                    <option value="Pessoa Física">Pessoa Física</option>
                    <option value="Pessoa Jurídica" >Pessoa Jurídica</option>
                </select>
            </div>

            <div class="label-input">
                <label>CPF/CNPJ</label>
                <input type="text" name="cnpj_cpf" value="<%= clientEdit.getCnpj_cpf() %>" class="cpf"/>
            </div>

            <div class="label-input">
                <label>E-mail</label>
                <input type="text" name="email" value="<%= clientEdit.getEmail() %>" class="email"/>
            </div>

            <div class="label-input">
                <label>Telefone</label>
                <input type="text" name="tel" value="<%= clientEdit.getTel() %>" class="phone"/>
            </div>

            <div class="label-input">
                <label>Cep</label>
                <input type="text" name="cep" value="<%= clientEdit.getCep() %>" class="cep"/>
            </div>

            <div class="label-input">
                <label>País</label>
                <input type="text" name="country" value="<%= clientEdit.getCountry() %>" class="country"/>
            </div>

            <div class="label-input">
                <label>Estado</label>
                <input type="text" name="state" value="<%= clientEdit.getState() %>" class="state"/>
            </div>

            <div class="label-input">
                <label>Cidade</label>
                <input type="text" name="city" value="<%= clientEdit.getCity() %>" class="city"/>
            </div>

            <div class="label-input">
                <label>Bairro</label>
                <input type="text" name="neighborhood" value="<%= clientEdit.getNeighborhood() %>" class="neighborhood"/>
            </div>

            <div class="label-input">
                <label>Rua</label>
                <input type="text" name="street" value="<%= clientEdit.getStreet() %>" class="street"/>
            </div>

            <div class="label-input">
                <label>Numero</label>
                <input type="text" name="number" value="<%= clientEdit.getNumber() %>" class="number"/>
            </div>

            <div class="label-select">
                <label>Bloqueado</label>
                <select name="blocked">
                    <option value="<%= clientEdit.getBlocked().equals("1") ? "1" : "2" %>"><%= clientEdit.getBlocked().equals("1") ? "Sim" : "Não" %></option>
                    <option value="2">Não</option>
                    <option value="1">Sim</option>
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
