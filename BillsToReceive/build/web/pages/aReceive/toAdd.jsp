<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Product" %>
<%@page import="models.Nature" %>
<%@page import="models.Client" %>
<%@page import="java.util.ArrayList" %>

<%
   ArrayList<Product>  productAdd = (ArrayList<Product>) request.getAttribute("productAdd");
   ArrayList<Nature>  natureAdd = (ArrayList<Nature>) request.getAttribute("natureAdd");
   ArrayList<Client> clientAdd = (ArrayList<Client>) request.getAttribute("clientAdd");
%>

<%@include file="/header/header.jsp" %>

<section class="container">
 
    
<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>
<h1>Contas a Receber</h1>


<p class="message-error"></p>
<section class="forms">

    <form id="form-contact" action="/BillsToReceive/ReceivableController" method="post">

        <div class="label-input">
            <label>Numero Titulo</label>
            <input type="text" name="title" class="title"/>
        </div>
        
         <div class="label-input">
            <label>Numero de Parcelas</label>
            <input type="text" name="installments" class="installments"/>
        </div>
        
         <div class="label-input">
            <label>Tipo do Titulo</label>
            <input type="text" name="title_type" class="title_type"/>
        </div>
        
        <div class="label-select">
            <label>Codigo do Produto/Serviço</label>
            <select name="product_id" class="product_id">
                <option></option>
                <% if(productAdd != null){ %>
                <% for(int i = 0; i < productAdd.size(); i++) { %>
                
                <option value="<%= productAdd.get(i).getId() %>"><%= productAdd.get(i).getId() %></option>
                
                <% } %>
                <% } %>
            </select>
        </div>
        
        <div class="label-select">
            <label>Nome do Produto/Serviço</label>
            <select name="name_product" class="name_product">
                <option></option>
                <% if(productAdd != null){ %>
                <% for(int i = 0; i < productAdd.size(); i++) { %>
                
                <option value="<%= productAdd.get(i).getId() %>"><%= productAdd.get(i).getName() %></option>
                
                <% } %>
                <% } %>
            </select>
        </div>
            
        <div class="label-select">
            <label>Descrição do Produto/Serviço</label>
            <select name="description_product" class="description_product">
                <option></option>
                <% if(productAdd != null){ %>
                <% for(int i = 0; i < productAdd.size(); i++) { %>
                
                <option value="<%= productAdd.get(i).getId() %>"><%= productAdd.get(i).getDescription() %></option>
                
                <% } %>
                <% } %>
            </select>
        </div>
        
        <div class="label-select" style="display: none;">
            
           <select name="product_value" class="product_value" >
                <option></option>
                <% if(productAdd != null){ %>
                <% for(int i = 0; i < productAdd.size(); i++) { %>
                
                <option value="<%= productAdd.get(i).getId() %>"><%= productAdd.get(i).getPrice() %></option>
                
                <% } %>
                <% } %>
            </select>
            
        </div>

        <div class="label-input">
            <label>Valor</label>
            <input type="text" name="title_value" class="title_value"/>
        </div>

        <div class="label-select">
            <label>Codigo do Cliente</label>
            <select name="client_id" class="client_id">
                <option value=""></option>
                <% if(clientAdd != null){ %>
                <% for(int i = 0; i < clientAdd.size(); i++) { %>

                <option value="<%= clientAdd.get(i).getId() %>"><%= clientAdd.get(i).getId() %></option>

                <% } %>
                <% } %>
            </select>
        </div>
        
        <div class="label-select">
            <label>Nome do Cliente</label>
            <select name="client_name" class="client_name">
                <option value=""></option>
                <% if(clientAdd != null){ %>
                <% for(int i = 0; i < clientAdd.size(); i++) { %>

                <option value="<%= clientAdd.get(i).getId() %>"><%= clientAdd.get(i).getName() %></option>

                <% } %>
                <% } %>
            </select>
        </div>

        <div class="label-select">
            <label>Codigo da Natureza Financeira</label>
            <select name="nature_id" class="nature_id">
                <option value=""></option>
                <% if(clientAdd != null){ %>
                <% for(int i = 0; i < natureAdd.size(); i++) { %>

                <option value="<%= natureAdd.get(i).getId() %>"><%= natureAdd.get(i).getId() %></option>

                <% } %>
                <% } %>
            </select>
        </div>
            
        <div class="label-select">
            <label>Nome da Natureza Financeira</label>
            <select name="nature_name" class="nature_name">
                <option value=""></option>
                <% if(clientAdd != null){ %>
                <% for(int i = 0; i < natureAdd.size(); i++) { %>

                <option value="<%= natureAdd.get(i).getId() %>"><%= natureAdd.get(i).getName() %></option>

                <% } %>
                <% } %>
            </select>
        </div>

        <div class="label-input">
            <label>Data do Pagamento</label>
            <input type="date" name="dt_payment" class="dt_payment" readonly="true"/>
        </div>
            
        <div class="label-input">
            <label>Data Vencimento</label>
            <input type="date" name="dt_expiration" class="dt_expiration"/>
        </div>
            
        <div class="label-select">
            <label>Forma de Pagamento</label>
            <select name="form_of_payment">
                <option value="Pix">Pix</option>
                <option value="Debito">Debito</option>
                <option value="Credito">Credito</option>
            </select>
        </div>

        <div class="label-select">
            <label>Pago</label>
            <select name="pay" class="pay">
                <option value="2">Não</option>
                <option value="1">Sim</option>
            </select>
        </div>
            
        <div class="label-input">
            <label>Data Emissão</label>
            <input type="date" name="dt_emission" class="dt_emission" readonly="true"/>
        </div>
            
        <div class="label-select">
            <label>Bloqueado</label>
            <select name="blocked">
                <option value="2">Não</option>
                <option value="1">Sim</option>
            </select>
        </div>

        <div class="btn">
            <button type="submit" name ="action" class="btn-send" value="Create">Cadastrar</button>
        </div>
    </form>
</section>

</section>
            
        <script src="/BillsToReceive/assets/js/manipulation-form-elements.js"></script>
</body>
</html>
