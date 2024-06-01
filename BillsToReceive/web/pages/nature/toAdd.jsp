<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header/header.jsp" %>

<section class="container">

    
<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>
<h1>Cadastro de Naturezas</h1>


<p class="message-error"></p>
<section class="forms">

    <form id="form-category" action="/BillsToReceive/NatureController" method="post">

        <div class="label-input">
            <label>Nome</label>
            <input type="text" name="name" class="name"/>
        </div>

        <div class="label-input">
            <label>Descrição</label>
            <input type="text" name="description" class="description"/>
        </div>
        
        <div class="label-select">
            <label>Tipo</label>
            <select name="type">
                <option value="Receita">Receita</option>
            </select>
        </div>
        
        <div class="label-select">
            <label>Centro de Custo</label>
            <select name="costCenter">
                <option value=""><option>
                <option value="CC1001">CC1001 - Venda de WebSites</option>
                <option value="CC1002">CC1002 - Venda de Produtos</option>
                <option value="CC1002">CC1002 - Prestação de Serviço</option>
                <option value="CC1003">CC1003 - Venda de Mouse</option>
                <option value="CC1004">CC1004 - Venda de Teclado</option>
            </select>
        </div>
        
        <div class="label-select">
            <label>Conta Contabil</label>
            <select name="account">
                <option value=""><option>
                <option value="1.001.01.01.0001">1.001.01.01.0001 - Venda de WebSites</option>
                <option value="1.001.01.01.0002">1.001.01.01.0002 - Venda de Produtos</option>
                <option value="1.001.01.01.0003">1.001.01.01.0003 - Prestação de Serviço</option>
                <option value="1.001.01.01.0004">1.001.01.01.0004 - Venda de Mouse</option>
                <option value="1.001.01.01.0005">1.001.01.01.0005 - Venda de Teclado</option>
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
