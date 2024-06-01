<%-- 
    Document   : login
    Created on : 4 de mai. de 2024, 12:34:54
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User" %>

<%
    String messageError = (String) request.getAttribute("messageFeedback");
       
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contas a Receber</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/BillsToReceive/assets/css/styles.css"/>

        <title>Contas a Receber</title>

        <!-- Fontes -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Share+Tech&display=swap" rel="stylesheet">

    </head>
    <body>
        <section class="container">

            <img src="/BillsToReceive/img/logo-green.png" alt="alt"/>

            <h1>Login</h1>
            <p> <strong><i>Sistema de controle de contas a receber</i></strong></p>
            <p class="message-error"><%= messageError != null ? messageError: "" %></p>
            <p class="message-error-form"></p>
            <section class="forms">

                <form id="form-user" action="/BillsToReceive/UserController" method="post">

                    <div class="label-input">
                        <label>E-mail</label>
                        <input type="text" name="email" class="email"/>
                    </div>

                    <div class="label-input">
                        <label>Senha</label>
                        <input type="password" name="password" class="password"/>
                    </div>

                    <div class="label-input">
                        <label>Confirmar Senha</label>
                        <input type="password" name="comfirmpassword" class="comfirmpassword"/>
                    </div>

                    <div class="btn">
                        <button type="submit" name ="action" class="btn-send" value="Auth">Entrar</button>
                    </div>

                </form>
            </section>

        </section>
            
            <script src="/BillsToReceive/assets/js/validate_form_login.js"></script>
    </body>
</html>
