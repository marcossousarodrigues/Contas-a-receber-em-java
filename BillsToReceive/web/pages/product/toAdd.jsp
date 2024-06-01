<%-- 
    Document   : toAdd
    Created on : 1 de mai. de 2024, 12:25:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/header/header.jsp" %>

<section class="container">

    
<img src="/BillsToReceive/img/logo-green.png" alt="alt"/>
<h1>Cadastro de Produtos</h1>


<p class="message-error"></p>
<section class="forms">

    <form id="form-category" action="/BillsToReceive/ProductController" method="post">

        <div class="label-input">
            <label>Nome</label>
            <input type="text" name="name" class="name"/>
        </div>

        <div class="label-input">
            <label>Descrição</label>
            <input type="text" name="description" class="description"/>
        </div>
        
        <div class="label-input">
            <label>Preço</label>
            <input type="text" name="price" class="price"/>
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
