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


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/1e23c494-fa69-4495-87be-273a8db94166)


<h3>
1.2 Detalhamento
</h3>
<p>
Para este projeto, foram definidas e criadas as seguintes tabelas:
</p>
<ul>
  <li><strong>tb_clients:</strong> onde é realizado o cadastro e manutenção de clientes.</li>
  <li><strong>tb_natures:</strong> onde é feito o cadastro das naturezas financeiras e a manutenção desse cadastro.</li>
  <li><strong>tb_products:</strong> nessa tabela, os produtos são cadastrados, atualizados, consultados e deletados. Além disso, possui outras funcionalidades.</li>
  <li><strong>tb_users:</strong> a tabela de usuários é responsável pelo gerenciamento dos usuários. Esta tabela permite alterações, deleções, consultas e criação de registros. Além disso, possui funcionalidades para bloquear e desbloquear usuários e campos com regras específicas.</li>
  <li><strong>tb_receivable:</strong> essa é a tabela principal, sendo as demais auxiliares. Esta tabela armazena os dados relacionados aos títulos financeiros, incluindo as chaves estrangeiras dos cadastros auxiliares, que são clientes, naturezas e produtos.</li>
</ul>

 <h1>Sistema</h1>
 <p>Agora vamos ver as telas</p>
 
 <h2>Login</h2>

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/90206ffc-7c28-4aed-940e-c9e124804784)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/30292226-6de2-495a-9619-f0703f5b2028)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/71ca85f1-3a08-4f18-982a-26c6456af4dc)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/dc328186-0143-49f2-b492-631ba5217f83)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/8a9f2402-d95e-4031-99a2-509c1f00701a)


<h2>Visão geral</h2>
![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/8b8dfb62-4dd5-48fb-8fe0-ae30fa66c654)


<h2>Clientes</h2>
![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/9db075a1-70bc-4ef1-8eca-c7bcd6c176f5)


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/0f91b683-b3a6-4d43-a101-d26ec11b5cfa)


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/f44d8e0d-2373-41b6-bfde-2ba36e16aa44)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/4727422f-59dd-40bd-bfb7-e0dbad397c98)


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/540ce4e8-07a2-4ece-b796-843b3d642e44)


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/bdef5db2-4c85-469c-8f44-cb01a51b29ce)


<h2>Naturezas Financeiras</h2>

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/2d1c6e3c-95bd-4cb3-930b-286f9e62bf1e)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/d48035ab-b1ee-4be4-9f1b-c6bdd222b138)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/9a95cd06-7154-4721-8123-851aeda1abce)


<h2>Produtos / Serviços</h2>

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/c52b4d8b-8269-4187-9103-3393b56f3928)


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/0562c316-8e58-4ccf-8e1f-b76b6a3afe55)


![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/68eab131-028c-447d-ae61-0b52fc983245)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/2adbb388-069e-4460-a71d-76ffa9ec67e1)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/6837cc2c-45e9-49a8-b5be-899132662c92)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/68c1c964-0624-4d85-944f-92acbab22b9f)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/e358185c-2e05-4e9e-8acc-111bc3ffb313)
 

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/303a24d7-abef-4c88-a600-d1ffe0754683)

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/e9eaf7ca-7e5f-4b9b-8a7a-4c4602107f3a)


<h2>Usuários</h2>

![image](https://github.com/marcossousarodrigues/Contas-a-receber-em-java/assets/49259832/1ce4f594-26bd-460c-badf-cb08a5f82eb8)






