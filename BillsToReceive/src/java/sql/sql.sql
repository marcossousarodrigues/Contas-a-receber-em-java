

-- criação da base de dados e tabelas
USE dbbillstoreceive;

DROP TABLE IF EXISTS tb_receivable;
DROP TABLE IF EXISTS tb_products;
DROP TABLE IF EXISTS tb_clients;
DROP TABLE IF EXISTS tb_natures;
DROP TABLE IF EXISTS tb_users;

CREATE TABLE IF NOT EXISTS tb_products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    blocked VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS tb_clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    person VARCHAR(255),
    cnpj_cpf VARCHAR(255),    
    email VARCHAR(255),
    tel VARCHAR(255),
    cep VARCHAR(255),
    country VARCHAR(255),
    state VARCHAR(255),
    city VARCHAR(255),
    neighborhood VARCHAR(255),
    street VARCHAR(255),
    number VARCHAR(255),
    blocked VARCHAR(2)
);


CREATE TABLE IF NOT EXISTS tb_natures (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    type VARCHAR(255),
    cost_center VARCHAR(255),
    account VARCHAR(255),
    blocked VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS tb_users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    permission VARCHAR(255),
    dtAccess DATETIME DEFAULT CURRENT_TIMESTAMP,
    errors_to_access INT DEFAULT 0,
    blocked VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS tb_receivable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    installments VARCHAR(10),
    title_type VARCHAR(50),
    title_value DECIMAL(10, 2), 
    title_amount INT, 
    title_total DECIMAL(10, 2),
    dt_payment DATE,
    dt_expiration DATE,
    form_of_payment VARCHAR(255),
    pay VARCHAR(2),
    dt_emission DATE,
    blocked VARCHAR(2),
    product_id INT,
    client_id INT,
    nature_id INT,
    user_id INT,
    FOREIGN KEY (product_id) REFERENCES tb_products(id), -- Relacionamento com a tabela devedores
    FOREIGN KEY (client_id) REFERENCES tb_clients(id), -- Relacionamento com a tabela devedores
    FOREIGN KEY (nature_id) REFERENCES tb_natures(id), -- Relacionamento com a tabela de categorias
    FOREIGN KEY (user_id) REFERENCES tb_users(id) -- Relacionamento com a tabela de usuários
);


-- inserção de dados em massa

INSERT INTO tb_products (name, description, price, blocked) VALUES
('Notebook', 'Notebook de alta performance com 16GB RAM e 512GB SSD', 1200.00, '2'),
('Smartphone', 'Smartphone modelo mais recente com 128GB de armazenamento', 800.00, '2'),
('Fones de Ouvido', 'Fones de ouvido com cancelamento de ruído', 150.00, '2'),
('Monitor', 'Monitor 4K UHD de 27 polegadas', 300.00, '2'),
('Teclado', 'Teclado mecânico com iluminação RGB', 100.00, '2');



INSERT INTO tb_clients (name, person, cnpj_cpf, email, tel, cep, country, state, city, neighborhood, street, number, blocked) VALUES
('João Silva', 'Pessoa Física', '123.456.789-00', 'joaosilva@example.com', '555-1234', '12345-678', 'Brasil', 'SP', 'São Paulo', 'Centro', 'Rua Principal', '123', '2'),
('Maria Oliveira', 'Pessoa Física', '987.654.321-00', 'mariaoliveira@example.com', '555-5678', '23456-789', 'Brasil', 'RJ', 'Rio de Janeiro', 'Copacabana', 'Avenida Atlântica', '456', '2'),
('Empresa XYZ', 'Pessoa Jurídica', '12.345.678/0001-99', 'contato@xyz.com.br', '555-2468', '34567-890', 'Brasil', 'MG', 'Belo Horizonte', 'Savassi', 'Rua da Bahia', '789', '2'),
('Corporation ABC', 'Pessoa Jurídica', '98.765.432/0001-88', 'info@abc.com.br', '555-1357', '45678-901', 'Brasil', 'RS', 'Porto Alegre', 'Moinhos de Vento', 'Rua Padre Chagas', '321', '2'),
('Indústrias Stark', 'Pessoa Jurídica', '11.222.333/0001-77', 'suporte@stark.com.br', '555-1239', '56789-012', 'Brasil', 'SC', 'Florianópolis', 'Centro', 'Rua das Flores', '654', '2');


INSERT INTO tb_natures (name, description, type, cost_center, account, blocked) VALUES
('Consultoria', 'Serviços de consultoria profissional', 'Receita', 'CC1001', '1.001.01.01.0001', '2'),
('Vendas de Software', 'Vendas de software licenciado', 'Receita', 'CC1001', '1.001.01.01.0001', '2'),
('Treinamento', 'Programas de treinamento para funcionários e clientes', 'Receita', 'CC1001', '1.001.01.01.0001', '2'),
('Manutenção', 'Serviços de manutenção de rotina', 'Receita', 'CC1001', '1.001.01.01.0001', '2'),
('Vendas de Equipamentos', 'Vendas de equipamentos técnicos', 'Receita', 'CC1001', '1.001.01.01.0001', '2');


INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Marcos', 'Sousa', 'marcos.sousa@areceber.com', 'admin', 2, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('João', 'Silva', 'joao.silva@areceber.com', 'senha123', 1, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Maria', 'Oliveira', 'maria.oliveira@areceber.com', 'senha123', 2, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Carlos', 'Santos', 'carlos.santos@areceber.com', 'senha123', 1, 1);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Ana', 'Souza', 'ana.souza@areceber.com', 'senha123', 2, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Paulo', 'Costa', 'paulo.costa@areceber.com', 'senha123', 1, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Fernanda', 'Lima', 'fernanda.lima@areceber.com', 'senha123', 2, 1);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Bruno', 'Almeida', 'bruno.almeida@areceber.com', 'senha123', 1, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Patrícia', 'Ramos', 'patricia.ramos@areceber.com', 'senha123', 2, 2);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Ricardo', 'Pereira', 'ricardo.pereira@areceber.com', 'senha123', 1, 1);
INSERT INTO tb_users (name, surname, email, password, permission, blocked) VALUES ('Juliana', 'Fernandes', 'juliana.fernandes@areceber.com', 'senha123', 2, 2);









