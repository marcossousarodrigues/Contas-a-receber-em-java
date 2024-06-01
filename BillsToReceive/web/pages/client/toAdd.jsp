<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header/header.jsp" %>

<section class="container">
 
    
    <img src="/BillsToReceive/img/logo-green.png" alt="alt"/>
    <h1>Cadastro de Clientes</h1>


    <p class="message-error"></p>
    <section class="forms">

        <form id="form-contact" action="/BillsToReceive/ClientController" method="post">

            <div class="label-input">
                <label>Name</label>
                <input type="text" name="name" class="name"/>
            </div>

            <div class="label-select">
                <label>Tipo de Pessoa</label>
                <select name="person">
                    <option value="Pessoa Física">Pessoa Física</option>
                    <option value="Pessoa Jurídica" >Pessoa Jurídica</option>
                </select>
            </div>

            <div class="label-input">
                <label>CPF/CNPJ</label>
                <input type="text" name="cnpj_cpf" class="cnpj_cpf"/>
            </div>

            <div class="label-input">
                <label>E-mail</label>
                <input type="text" name="email" class="email"/>
            </div>

            <div class="label-input">
                <label>Telefone</label>
                <input type="text" name="tel" class="phone"/>
            </div>

            <div class="label-input">
                <label>Cep</label>
                <input type="text" name="cep" class="cep"/>
            </div>

            <div class="label-input">
                <label>País</label>
                <input type="text" name="country" class="country"/>
            </div>

            <div class="label-input">
                <label>Estado</label>
                <input type="text" name="state" class="state"/>
            </div>

            <div class="label-input">
                <label>Cidade</label>
                <input type="text" name="city" class="city"/>
            </div>

            <div class="label-input">
                <label>Bairro</label>
                <input type="text" name="neighborhood" class="neighborhood"/>
            </div>

            <div class="label-input">
                <label>Rua</label>
                <input type="text" name="street" class="street"/>
            </div>

            <div class="label-input">
                <label>Numero</label>
                <input type="text" name="number" class="number"/>
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
