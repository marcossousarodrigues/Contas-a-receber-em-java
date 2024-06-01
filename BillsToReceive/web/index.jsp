
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
            Nosso sistema foi desenvolvido para simplificar o gerenciamento de suas finanças, permitindo o cadastro de categorias financeiras e devedores de forma intuitiva e eficiente.
        </p>

        <p>
            Com nossa plataforma, você pode facilmente registrar suas receitas e associá-las às categorias financeiras correspondentes, além de selecionar os devedores relacionados a cada transação.
        </p>

        <h2>
            Principais recursos
        </h2>

        <ol>
            <li>
                Cadastro de Categorias Financeiras: Organize suas receitas de acordo com categorias específicas, facilitando a análise e o controle financeiro.
            </li>
            <li>
                Cadastro de Devedores: Registre informações detalhadas sobre seus devedores, mantendo um histórico completo de transações e pagamentos.
            </li>
            <li>
                Registro de Receitas: Adicione novas receitas ao sistema, atribuindo categorias financeiras e devedores para uma gestão precisa.
            </li>
            <li>
                Acompanhamento de Recebimentos:
                <ul>
                    <li>
                        Recebimentos Confirmados: Visualize as receitas já recebidas e confirmadas em seu sistema.
                    </li>
                    <li>
                        Recebimentos Pendentes: Acompanhe as receitas aguardando pagamento, facilitando o controle de fluxo de caixa.
                    </li>
                    <li>
                        Em Processo de Recebimento: Identifique as receitas em andamento, garantindo uma visão completa de seu ciclo financeiro.
                    </li>
                </ul>
            </li>

        </ol>


        <p>Nosso sistema oferece uma interface amigável e relatórios detalhados, permitindo uma gestão eficiente e estratégica de suas contas a receber. Simplifique suas operações financeiras conosco!</p>

    </section>

</section>
</body>
</html>
