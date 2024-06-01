<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header/header.jsp" %>

<section class="container">
   
               
            <img src="/BillsToReceive/img/logo-green.png" alt="alt"/>
            <h1>Cadastro de Usuários</h1>
            
            
            <p class="message-error"></p>
            <section class="forms">

                <form id="form-contact" action="/BillsToReceive/UserController" method="post">

                        <div class="label-input">
                            <label>Name</label>
                            <input type="text" name="name" class="name"/>
                        </div>
                    
                        <div class="label-input">
                            <label>Sobrenome</label>
                            <input type="text" name="surname" class="surname"/>
                        </div>
                    
                        <div class="label-input">
                            <label>E-mail</label>
                            <input type="text" name="email" class="email"/>
                        </div>
                    
                        <div class="label-input">
                            <label>Senha</label>
                            <input type="password" name="password" class="password"/>
                        </div>
                    
                        <div class="label-select">
                            <label>Permissão</label>
                            <select name="permission">
                                <option value="1">Operardor do Sistema</option>
                                <option value="2">Administrador</option>
                            </select>
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
    </body>
</html>
