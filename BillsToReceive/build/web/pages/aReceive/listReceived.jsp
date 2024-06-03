<%-- 
    Document   : listReceived
    Created on : 1 de mai. de 2024, 12:26:21
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Receivable" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="java.time.LocalDate" %>

<%
   ArrayList<Receivable> list = (ArrayList<Receivable>) request.getAttribute("receivable");
   String searchMessage = (String) request.getAttribute("searchMessage");
%>

<%@include file="/header/header.jsp" %>

<section class="container">
  
    
    <section class="container-legend">
        <h3>Legendas</h3>
        <div class="legend-description">
            <p>Recebimentos Confirmados</p>
            <div class="legend legend-green"></div>
        </div>
        
        <div class="legend-description">
            <p>Recebimentos Pendentes</p>
            <div class="legend legend-orange"></div>
        </div>
        
        <div class="legend-description">
            <p>Em Processo de Recebimento</p>
            <div class="legend legend-blue"></div>
        </div>
       
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

<h1>Contas a Receber</h1>

<div class="button-add">
    <a href="/BillsToReceive/ReceivableController?action=Add">
        <img src="/BillsToReceive/img/icon-add-button.png">
    </a>
</div>

<h2><%= searchMessage != null ? searchMessage : ""  %></h2>

<section class="form-search">
    <form action="/BillsToReceive/ReceivableController" method="post">
        <div class="label-input">
            <label>Pesquisar</label>
            <input type="text" name="fieldValue" class="name-field" placeholder="Digite aqui..."/>
        </div>
        <div class="label-input">
            <label>Pesquisar por:</label>
            <select name="field" class="field">
                <option value="Id">Id</option>
                <option value="title">Numero Titulo</option>
                <option value="title_type">Tipo do Titulo</option>
                <option value="dt_payment">Data do Pagamento</option>
                <option value="dt_expiration">Data de Vencimento</option>
                <option value="form_of_payment">Forma de Pagamento</option>
                <option value="blocked">Bloqueados</option>
                <option value="Nblocked">Não Bloqueados</option>
                <option value="pay">Pagos</option>
                <option value="Npay">Não Pagos</option>
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
                <th>Numero do Titulo</th>
                <th>Parcelas</th>
                <th>Tipo do Titulo</th>
                <th>Valor do titulo:</th>
                <th>Data de Pagamento</th>
                <th>Data de Vencimento</th>
                <th>Forma de Pagamento</th>
                <th>Pago</th>
                <th>Data de Emissão</th>
                <th>Bloqueado</th>
                <th>Produto</th>
                <th>Cliente</th>
                <th>Natureza Financeira</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
        </thead>
        <tbody>
            <% if(list.size() > 0) { %>
            <% for(int i = 0; i < list.size(); i++){%>
            
            <tr>
                
                <% if(list.get(i).getBlocked().equals("1")) { %>
                
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend legend-red-blocked"></div></td>
                
                
                <% } else if(list.get(i).getPay().equals("1")) { %>
                
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend legend-green"></div></td>
                
                <% } else if( list.get(i).getDt_expiration() == null ) { %>
                
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend legend-green-blocked"></div></td>
                
                
                <% } else if(list.get(i).getDt_expiration().before(new Date())) { %>
                
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend legend-orange"></div></td>
                
                <% } else if(list.get(i).getBlocked().equals("1")) { %>
                
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend legend-red-blocked"></div></td>
                
                <% } else { %>
                
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend legend-blue"></div></td>
                
                <% } %>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getId() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getTitle() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getInstallments() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getTitle_type() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getTitle_value() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getDt_payment() != null ? list.get(i).getDt_payment() : "" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getDt_expiration() != null ? list.get(i).getDt_expiration() : "" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getForm_of_payment() != null ? list.get(i).getForm_of_payment() : "" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getPay().equals("1") ? "sim" : "Não"%></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getDt_emission() != null ? list.get(i).getDt_emission() : "" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getBlocked().equals("1") ? "Sim" : "Não" %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getProduct().getName() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getClient().getName() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getNature().getName() %></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/ReceivableController?action=Read&id=<%= list.get(i).getId()%>"><img class="img-btns" src="/BillsToReceive/img/edit.png"></a></td>
                <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/ReceivableController?action=Delete&id=<%= list.get(i).getId()%>"><img class="img-btns" src="/BillsToReceive/img/delete.png"></a></td>
            </tr>
            <%}%>
            <% } %>
        </tbody>
    </table>

</section>

</section>
        <script src="/BillsToReceive/assets/js/manipulation-form-elements.js"></script>
</body>
</html>
