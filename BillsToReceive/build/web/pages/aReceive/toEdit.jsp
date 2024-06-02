<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Receivable" %>
<%@page import="models.Product" %>
<%@page import="models.Nature" %>
<%@page import="models.Client" %>
<%@page import="java.util.ArrayList" %>
<%
   Receivable receivableEdit  = (Receivable) request.getAttribute("receivableEdit");
   ArrayList<Product> productEdit = (ArrayList<Product>) request.getAttribute("productEdit");
   ArrayList<Nature> natureEdit = (ArrayList<Nature>) request.getAttribute("natureEdit");
   ArrayList<Client> clientEdit = (ArrayList<Client>) request.getAttribute("clientEdit");
%>


<%@include file="/header/header.jsp" %>

<section class="container">
    
<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>

<h1>Contas a Receber - Editar</h1>


<p class="message-error"></p>
<section class="forms">

    <form id="form-contact" action="ReceivableController" method="post">

        <input type="hidden" name="id" value="<%= receivableEdit.getId()%>"/>
        <div class="label-input">
            <label>Numero do Titulo</label>
            <input type="text" name="title" value="<%= receivableEdit.getTitle()%>" class="title"/>
        </div>

        <div class="label-input">
            <label>Parcelas</label>
            <input type="text" name="installments" value="<%= receivableEdit.getInstallments()%>" class="installments"/>
        </div>

        <div class="label-input">
            <label>Tipo do Titulo</label>
            <input type="text" name="title_type" value="<%= receivableEdit.getTitle_type()%>" class="title_type"/>
        </div>
        
        <div class="label-select">
            <label>Produto/Serviço</label>
            <select name="product_id" class="product_id">
                <% for(int i = 0; i < productEdit.size(); i++) {
                    String selected = "";
                    if (productEdit.get(i).getId() == receivableEdit.getProduct().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= productEdit.get(i).getId() %>" <%= selected %>><%= productEdit.get(i).getId() %></option>
                <% } %>
                <option></option>
            </select>
        </div>
        
        <div class="label-select">
            <label>Produto/Serviço</label>
            <select name="name_product" class="name_product">
                <% for(int i = 0; i < productEdit.size(); i++) {
                    String selected = "";
                    if (productEdit.get(i).getId() == receivableEdit.getProduct().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= productEdit.get(i).getId() %>" <%= selected %>><%= productEdit.get(i).getName() %></option>
                <% } %>
                <option></option>
            </select>
        </div>
                
        <div class="label-select">
            <label>Produto/Serviço</label>
            <select name="description_product" class="description_product">
                <% for(int i = 0; i < productEdit.size(); i++) {
                    String selected = "";
                    if (productEdit.get(i).getId() == receivableEdit.getProduct().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= productEdit.get(i).getId() %>" <%= selected %>><%= productEdit.get(i).getDescription() %></option>
                <% } %>
                <option></option>
            </select>
        </div>
                
        
        <div class="label-input">
            <label>Valor</label>
            <input type="text" name="title_value" value="<%= receivableEdit.getTitle_value()%>" class="title_value"/>
        </div>
          
        <div class="label-select">
            <label>Cliente</label>
            <select name="client_id" class="client_id">
                <% for(int i = 0; i < clientEdit.size(); i++) {
                    String selected = "";
                    if (clientEdit.get(i).getId() == receivableEdit.getClient().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= clientEdit.get(i).getId() %>" <%= selected %>><%= clientEdit.get(i).getId() %></option>
                <% } %>
                <option></option>
            </select>
        </div>
                
        <div class="label-select">
            <label>Cliente</label>
            <select name="client_name" class="client_name">
                <% for(int i = 0; i < clientEdit.size(); i++) {
                    String selected = "";
                    if (clientEdit.get(i).getId() == receivableEdit.getClient().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= clientEdit.get(i).getId() %>" <%= selected %>><%= clientEdit.get(i).getName() %></option>
                <% } %>
                <option></option>
            </select>
        </div>

        <div class="label-select">
            <label>Natureza Financeira</label>
            <select name="nature_id" class="nature_id">
                <% for(int i = 0; i < natureEdit.size(); i++) {
                    String selected = "";
                    if (natureEdit.get(i).getId() == receivableEdit.getNature().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= natureEdit.get(i).getId() %>" <%= selected %>><%= natureEdit.get(i).getId() %></option>
                <% } %>
                <option></option>
            </select>
        </div>
                
        <div class="label-select">
            <label>Natureza Financeira</label>
            <select name="nature_name" class="nature_name">
                <% for(int i = 0; i < natureEdit.size(); i++) {
                    String selected = "";
                    if (natureEdit.get(i).getId() == receivableEdit.getNature().getId()) {
                        selected = "selected"; 
                    }
                %>
                <option value="<%= natureEdit.get(i).getId() %>" <%= selected %>><%= natureEdit.get(i).getName() %></option>
                <% } %>
                <option></option>
            </select>
        </div>
                

        <div class="label-input">
            <label>Data Pagamento</label>
            <input type="date" name="dt_payment" value="<%= receivableEdit.getDt_payment()%>" class="dt_payment" readonly="true"/>
        </div>
        
        <div class="label-input">
            <label>Data de Vencimento</label>
            <input type="date" name="dt_expiration" value="<%= receivableEdit.getDt_expiration()%>" class="dt_expiration"/>
        </div>
        
         <div class="label-select">
            <label>Forma de Pagamento</label>
            <select name="form_of_payment">
                <option value="<%= receivableEdit.getForm_of_payment() %>"><%= receivableEdit.getForm_of_payment() %></option>
                <option value="PIX">PIX</option>
                <option value="Debito">Debito</option>
                <option value="Credito">Credito</option>
            </select>
        </div>
        
        <div class="label-select">
            <label>Pago</label>
            <select name="pay" class="pay">
                <option value="<%= receivableEdit.getPay()%>"><%= receivableEdit.getPay().equals("1") ? "sim" : "Não"%></option>
                <option value="2">Não</option>
                <option value="1">Sim</option>
            </select>
        </div>
                
        <div class="label-input">
            <label>Data de Emissão</label>
            <input type="date" name="dt_emission" value="<%= receivableEdit.getDt_emission()%>" class="dt_emission" readonly="true"/>
        </div>
        
        <div class="label-select">
            <label>Bloqueado</label>
            <select name="blocked">
                <option value="<%= receivableEdit.getBlocked()%>"><%= receivableEdit.getBlocked().equals("1") ? "sim" : "Não"%></option>
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
    <script src="/BillsToReceive/assets/js/manipulation-form-elements.js"></script>
</body>
</html>
