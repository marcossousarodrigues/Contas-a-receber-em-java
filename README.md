<h1>Contas a Receber em Java</h1>

<p>
Este é um projeto que desenvolvi para um trabalho na faculdade, onde foi solicitada a criação de um projeto JAVA WEB utilizando os seguintes Padrões de Projetos (Design Patterns):
</p>

<ul>
  <li>Padrão DAO</li>
  <li>Padrão Builder</li>
  <li>Padrão Factory</li>
  <li>Padrão Facade</li>
  <li>Padrão Decorator</li>
  <li>Padrão Command</li>
  <li>Padrão MVC</li>
</ul>

<p><strong>
Para atender a esse requisito, desenvolvi um sistema de contas a receber com as seguintes regras de negócio:
</strong></p>
<p>
Para uma visão geral deste projeto, vou adicionar as regras que utilizei e as imagens das telas. Para entender como foi construído, você pode verificar o código do projeto neste repositório. Vamos lá.
</p>

<h2>
1. Banco de Dados
</h2>

<h3>
  1.1 Tabelas
</h3>

<h3>
1.2 Detalhamento
</h3>
<p>
Para este projeto, foram definidas e criadas as seguintes tabelas:
</p>

tb_clients: onde é realizado o cadastro e manutenção de clientes.
tb_natures: onde é feito o cadastro das naturezas financeiras e a manutenção desse cadastro.
tb_products: nessa tabela, os produtos são cadastrados, atualizados, consultados e deletados. Além disso, possui outras funcionalidades.
tb_users: a tabela de usuários é responsável pelo gerenciamento dos usuários. Esta tabela permite alterações, deleções, consultas e criação de registros. Além disso, possui funcionalidades para bloquear e desbloquear usuários e campos com regras específicas.
tb_receivable: essa é a tabela principal, sendo as demais auxiliares. Esta tabela armazena os dados relacionados aos títulos financeiros, incluindo as chaves estrangeiras dos cadastros auxiliares, que são clientes, naturezas e produtos.
Espero que isso ajude a entender melhor o projeto e suas funcionalidades! Para mais detalhes, você pode conferir o código no repositório.
