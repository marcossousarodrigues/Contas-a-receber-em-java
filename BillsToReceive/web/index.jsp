
<%@page import="models.User" %>

<%
   /*
    User user = (User) request.getSession().getAttribute("user");
    
    if(user == null)
    {
      response.sendRedirect("/BillsToReceive/pages/user/login.jsp");
    }
    */
%>


<%@include file="/header/header.jsp" %>

<section class="container">

    <section class="presentation">
        

        <img src="/BillsToReceive/img/logo-green.png" alt="alt"/>

        <h1>Sistema de Controle de Contas a Receber</h1>

        <p>
            Bem-vindo ao nosso Sistema de Contas a Receber!
        </p>
        <p>
            Nosso sistema foi desenvolvido para simplificar o gerenciamento de suas finan�as, permitindo o cadastro de categorias financeiras e devedores de forma intuitiva e eficiente.
        </p>

        <p>
            Com nossa plataforma, voc� pode facilmente registrar suas receitas e associ�-las �s categorias financeiras correspondentes, al�m de selecionar os devedores relacionados a cada transa��o.
        </p>

        <h2>
            Principais recursos
        </h2>

        <ol>
            <li>
                Cadastro de Categorias Financeiras: Organize suas receitas de acordo com categorias espec�ficas, facilitando a an�lise e o controle financeiro.
            </li>
            <li>
                Cadastro de Devedores: Registre informa��es detalhadas sobre seus devedores, mantendo um hist�rico completo de transa��es e pagamentos.
            </li>
            <li>
                Registro de Receitas: Adicione novas receitas ao sistema, atribuindo categorias financeiras e devedores para uma gest�o precisa.
            </li>
            <li>
                Acompanhamento de Recebimentos:
                <ul>
                    <li>
                        Recebimentos Confirmados: Visualize as receitas j� recebidas e confirmadas em seu sistema.
                    </li>
                    <li>
                        Recebimentos Pendentes: Acompanhe as receitas aguardando pagamento, facilitando o controle de fluxo de caixa.
                    </li>
                    <li>
                        Em Processo de Recebimento: Identifique as receitas em andamento, garantindo uma vis�o completa de seu ciclo financeiro.
                    </li>
                </ul>
            </li>

        </ol>


        <p>Nosso sistema oferece uma interface amig�vel e relat�rios detalhados, permitindo uma gest�o eficiente e estrat�gica de suas contas a receber. Simplifique suas opera��es financeiras conosco!</p>

    </section>

</section>
</body>
</html>
