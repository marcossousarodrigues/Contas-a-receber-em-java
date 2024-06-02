
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="models.User" %>

<%
   
    User user = (User) request.getSession().getAttribute("user");
    
    if(user == null)
    {
      response.sendRedirect("/BillsToReceive/pages/user/login.jsp");
    }

%>

<!DOCTYPE html>

<html>
    <head>
        <title>Contas a Receber</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/BillsToReceive/assets/css/styles.css"/>

        <title>Agenda de contatos</title>

        <!-- Fontes -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Share+Tech&display=swap" rel="stylesheet">


    </head>
    <body>
        <header>
            <a class="logo" href="/BillsToReceive/">
                <img src="/BillsToReceive/img/logo-white.png" alt="alt"/>
                <span>Receitas</span>
            </a>
            <nav class="nav-menu">
                <ul>
                    <li>
                        Produto/Serviço
                        <ul>
                            <li>
                                <a href="/BillsToReceive/pages/product/toAdd.jsp">
                                    <img src="/BillsToReceive/img/icon-add.png" >
                                    Adicionar
                                </a>
                            </li>
                            <li>
                                <a href="/BillsToReceive/ProductController?action=ReadAll">
                                    <img src="/BillsToReceive/img/icon-list.png" >
                                    Listar
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        Natureza Financeira
                        <ul>
                            <li>
                                <a href="/BillsToReceive/pages/nature/toAdd.jsp">
                                    <img src="/BillsToReceive/img/icon-add.png" >
                                    Adicionar
                                </a>
                            </li>
                            <li>
                                <a href="/BillsToReceive/NatureController?action=ReadAll">
                                    <img src="/BillsToReceive/img/icon-list.png" >
                                    Listar
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        Clientes
                        <ul>
                            <li>
                                <a href="/BillsToReceive/pages/client/toAdd.jsp">
                                    <img src="/BillsToReceive/img/icon-add.png" >
                                    Adicionar
                                </a>
                            </li>
                            <li>
                                <a href="/BillsToReceive/ClientController?action=ReadAll">
                                    <img src="/BillsToReceive/img/icon-list.png" >
                                    Listar
                                </a>
                            </li>
                        </ul>
                    </li>
                    <% if( user != null && user.getPermission().equals("2") ) { %>
                    <li>
                        Usuários
                        <ul>
                            <li>
                                <a href="/BillsToReceive/pages/user/toAdd.jsp">
                                    <img src="/BillsToReceive/img/icon-add.png" >
                                    Adicionar
                                </a>
                            </li>
                            <li>
                                <a href="/BillsToReceive/UserController?action=ReadAll">
                                    <img src="/BillsToReceive/img/icon-list.png" >
                                    Listar
                                </a>
                            </li>
                        </ul>
                    </li>
                    <% } %>
                    <li>
                        <a href="/BillsToReceive/UserController?action=Logout" >
                            <img src="/BillsToReceive/img/icon-exit.png" >
                            Sair
                        </a>
                    </li>
                </ul>
                <ul>
                    <li>
                        Receita
                        <ul>
                            <li>
                                <a href="/BillsToReceive/ReceivableController?action=Add">
                                    <img src="/BillsToReceive/img/icon-add.png" >
                                    Adicionar
                                </a>
                            </li>
                            <li>
                                <a href="/BillsToReceive/ReceivableController?action=ReadAll">
                                    <img src="/BillsToReceive/img/icon-list.png" >
                                    Listar
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="/BillsToReceive/ReceivableController?action=Find&field=pay&fieldValue=1">
                            <div class="legend legend-green"></div>
                            <span>Recebimentos Confirmados</span>
                        </a>
                    </li>
                    <li>
                        <a>
                            <div class="legend legend-orange"></div>
                            <span>Recebimentos Pendentes</span>
                        </a>
                    </li>
                    <li>
                        <a>
                            <div class="legend legend-blue"></div>
                            <span>Em Processo de Recebimento</span>
                        </a>
                    </li>
                    
                </ul>
              
            </nav>

        </header>
        
        <section>
            <p class="message_user">Olá, <strong><%= user != null ? user.getName(): "" %> / <%= user != null ? user.getEmail() : "" %></strong>, Seja bem-vindo(a)!</p>

    
        </section>
            