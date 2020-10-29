DROP DATABASE tades;
CREATE DATABASE tades;
use tades;
create table Unidade(
codUnidade INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL
);
create table produto(
codProduto INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(100) NOT NULL,
categoria VARCHAR(100) NOT NULL,
foto VARCHAR(200) NULL,
descricao VARCHAR(300),
valor NUMERIC(9,2),
quantidade INTEGER,
Unidade_codUnidade INTEGER,
status INTEGER,
FOREIGN KEY (Unidade_codUnidade) REFERENCES Unidade(codUnidade)
);

insert into Unidade(nome) values("matriz");
insert into Unidade(nome) values("Campina Grande");
insert into Unidade(nome) values("Brasília");
insert into Unidade(nome) values("Joinville");

insert into produto(titulo,categoria,descricao,valor,quantidade,Unidade_codUnidade,status) values("bancada branca 1.2m","bancada","muito boa",190.30,200,1,1);
insert into produto(titulo,categoria,descricao,valor,quantidade,Unidade_codUnidade,status) values("bancada PRETA 1.2m","bancada","SHOW DE BOLA",190.30,200,1,1);

create table Cliente(
codCliente INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(15) NOT NULL,
email VARCHAR(150) NOT NULL,
telefone CHAR(15) null,
Unidade_codUnidade INTEGER,
FOREIGN KEY (Unidade_codUnidade)
REFERENCES Unidade(codUnidade)
);
insert into Cliente(nome,cpf,email,telefone,Unidade_codUnidade)values("Cliente teste","888.888.888-88","cliente@cliente.com","119789-8745",1);


Create table tades.Funcionario(
codFuncionario INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
Funcionario_nome VARCHAR(100) not null
);
INSERT INTO tades.Funcionario(Funcionario_nome) values("default");
create table tades.venda(
codVenda INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
total NUMERIC(9,2),
funcionario_codFuncionario INTEGER,
cliente_codCliente INTEGER,
Unidade_codUnidade INTEGER,
datahora date,
status integer,
FOREIGN KEY(Funcionario_codFuncionario) REFERENCES Funcionario(codFuncionario),
FOREIGN KEY(cliente_codCliente) REFERENCES Cliente(codCliente),
FOREIGN KEY (Unidade_codUnidade) REFERENCES Unidade(codUnidade)
);

create table tades.ProdutoVenda(
codProdutoVenda INTEGER AUTO_INCREMENT PRIMARY KEY,
venda_codVenda INTEGER,
produto_codProduto INTEGER,
produto_valor NUMERIC(9,2) NOT NULL,
funcionario_codFuncionario INTEGER,
status integer,
FOREIGN KEY(venda_codVenda) REFERENCES venda(codVenda),
FOREIGN KEY(funcionario_codFuncionario) REFERENCES Funcionario(codFuncionario),
FOREIGN KEY(produto_codProduto) REFERENCES produto(codProduto)
);

