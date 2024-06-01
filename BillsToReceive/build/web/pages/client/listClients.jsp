<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Client" %>
<%@page import="java.util.ArrayList" %>
<%
   ArrayList<Client> list = (ArrayList<Client>) request.getAttribute("clients");
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
            <h1>Lista de Clientes</h1>
            <div class="button-add">
                <a href="/BillsToReceive/pages/client/toAdd.jsp">
                    <img src="/BillsToReceive/img/icon-add-button.png">
                </a>
            </div>
              
            <section class="form-search">
                <form>
                    <div class="label-input">
                        <label>Pesquisar</label>
                        <input type="text" name="name" class="name" placeholder="Digite aqui..."/>
                   </div>
                    <div class="label-input">
                        <label>Pesquisar por:</label>
                        <select>
                            <option value="value">Id</option>
                            <option value="value">Nome</option>
                            <option value="value">Sobrenome</option>
                            <option value="value">Email</option>
                        </select>
                   </div>
                   <div class="btn">
                        <button type="submit" name ="btn_action" class="btn-send" value="search">Buscar</button>
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
                        <th>Tipo de Pessoa</th>
                        <th>CNPJ/CPF</th>
                        <th>E-mail</th>
                        <th>Telefone</th>
                        <th>Cep</th>
                        <th>País</th>
                        <th>Estado</th>
                        <th>Cidade</th>
                        <th>Bairro</th>
                        <th>Rua</th>
                        <th>Numero</th>
                        <th>Bloqueado</th>
                    </tr>
                </thead>
                <tbody>
                        <% for(int i = 0; i < list.size(); i++){%>
                        <tr>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><div class="legend <%= list.get(i).getBlocked().equals("1") ? "legend-red-blocked" : "legend-green-blocked" %>"></div></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getId() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getName() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getPerson() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getCnpj_cpf() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getEmail() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getTel() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getCep() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getCountry() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getState() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getCity() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getNeighborhood() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getStreet() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getNumber() %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><%= list.get(i).getBlocked().equals("1") ? "Sim" : "Não" %></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/ClientController?action=Read&id=<%= list.get(i).getId() %>"><img class="img-btns" src="/BillsToReceive/img/edit.png"></a></td>
                            <td class="<%= (i % 2 == 0) ? "table-color-one" : "table-color-two" %>"><a href="/BillsToReceive/ClientController?action=Delete&id=<%= list.get(i).getId() %>"><img class="img-btns" src="/BillsToReceive/img/delete.png"></a></td>
                        </tr>
                        <%}%>
                 </tbody>
                </table>
                 
            </section>
            
                
        </section>
    </body>
</html>
