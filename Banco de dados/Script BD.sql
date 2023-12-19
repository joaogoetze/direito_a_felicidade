DROP DATABASE if EXISTS projeto; /* Exclui a base de dados caso ela já exista */
CREATE DATABASE projeto /* Cria a base de dados */
DEFAULT CHARSET UTF8 COLLATE UTF8_GENERAL_CI; /* Define o padrão de caracteres como UTF8 */
USE projeto; /* Ativa a base de dados para ser usada */

CREATE TABLE conteudo(
codConteudo INT NOT NULL AUTO_INCREMENT,
nomeConteudo VARCHAR(30) NOT NULL,
descricaoConteudo VARCHAR(90) NOT NULL,
descricaoIndicacao VARCHAR(90) NOT NULL,
tematicaConteudo VARCHAR(30) NOT NULL,
PRIMARY KEY (codConteudo)
); /* Cria a tabela e define seus atributos, tamnhos e tipos dos mesmos */

DROP TABLE conteudo; /* Exclui a tabela */
SELECT * FROM conteudo; /* Mostra todos os dados da tabela */

CREATE TABLE usuario(
codUsuario INT(11) NOT NULL AUTO_INCREMENT,
nomeUsuario VARCHAR(50) NOT NULL,
generoUsuario INT(11) NOT NULL,
tipoUsuario INT(11) NOT NULL,
emailUsuario VARCHAR(50) NOT NULL,
senhaUsuario VARCHAR(100) NOT NULL,
PRIMARY KEY (emailUsuario)
);

SELECT * FROM usuario WHERE emailUsuario = 'x';

INSERT INTO usuario (nomeUsuario, generoUsuario, tipoUsuario, emailUsuario, senhaUsuario) 
VALUES ('Admin', 1, 1, 'admin', 'admin'); /* Insere um dado na tabela */
delete from usuario where nomeUsuario  = 'Admin';
DROP TABLE usuario;
SELECT * FROM usuario;

CREATE TABLE canalYoutube(
codCanal INT NOT NULL AUTO_INCREMENT, 
linkCanal VARCHAR(80) NOT NULL,
capaCanal LONGBLOB NOT NULL,
codConteudo INT NOT NULL,
PRIMARY KEY (codCanal),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE canalyoutube;
SELECT * FROM canalyoutube;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
canalYoutube.codCanal, canalYoutube.linkCanal, canalYoutube.capaCanal, canalYoutube.codConteudo
FROM conteudo JOIN canalYoutube ON conteudo.codConteudo = canalYoutube.codConteudo;
/* Mostra os dados de duas tabelas em uma query */

CREATE TABLE serie(
codSerie INT NOT NULL AUTO_INCREMENT,
capaSerie LONGBLOB,
sinopseSerie VARCHAR(100) NOT NULL,
temporadaSerie INT NOT NULL,
anoLancamentoSerie YEAR NOT NULL,
plataformaSerie VARCHAR(40),
codConteudo INT NOT NULL,
PRIMARY KEY (codSerie),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE serie;
SELECT * FROM serie;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
serie.capaSerie, serie.sinopseSerie, serie.temporadaSerie, serie.temporadaSerie, serie.anoLancamentoSerie, serie.plataformaSerie
FROM conteudo JOIN serie ON conteudo.codConteudo = serie.codConteudo;

CREATE TABLE filme(
codFilme INT NOT NULL AUTO_INCREMENT,
capaFilme longblob,
sinopseFilme VARCHAR(100) NOT NULL,
duracaoFilme INT NOT NULL,
anoLancamentoFilme YEAR NOT NULL,
plataformaFilme VARCHAR(40),
codConteudo INT NOT NULL,
PRIMARY KEY (codFilme),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE filme;
SELECT * FROM filme;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
filme.capaFilme, filme.sinopseFilme, filme.duracaoFilme, filme.anoLancamentoFilme, filme.plataformaFilme
FROM conteudo JOIN filme ON conteudo.codConteudo = filme.codConteudo;

CREATE TABLE livro(
codLivro INT NOT NULL AUTO_INCREMENT,
editoraLivro VARCHAR(20) NOT NULL,
capaLivro BLOB NOT NULL,
anoLivro YEAR NOT NULL,
paginasLivro VARCHAR(4) NOT NULL, 
autorLivro VARCHAR(40) NOT NULL,
generoLivro VARCHAR(20) NOT NULL,
codConteudo INT NOT NULL,
PRIMARY KEY (codLivro),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE livro;
SELECT * FROM livro;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
livro.codLivro, livro.editoraLivro, livro.capaLivro, livro.anoLivro, livro.paginasLivro, livro.autorLivro, livro.generoLivro
FROM conteudo JOIN livro ON conteudo.codConteudo = livro.codConteudo;

CREATE TABLE artigo(
codArtigo INT NOT NULL AUTO_INCREMENT,
linkArtigo VARCHAR(80) NOT NULL,
resumoArtigo VARCHAR(250) NOT NULL,
anoPublicacao INT NOT NULL,
autorArtigo VARCHAR(80),
codConteudo INT NOT NULL,
PRIMARY KEY (codArtigo),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE artigo;
SELECT * FROM artigo;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo,
artigo.codArtigo, artigo.linkArtigo, artigo.resumoArtigo, artigo.anoPublicacao, artigo.autorArtigo
FROM conteudo JOIN artigo ON conteudo.codConteudo = artigo.codConteudo;

CREATE TABLE aplicativo (
codAplicativo INT NOT NULL AUTO_INCREMENT,
logoAplicativo blob,
linkAplicativo VARCHAR(80) NOT NULL,
desenvolvedoresAplicativo VARCHAR(60),
gratisAplicativo INT,
codConteudo INT NOT NULL,
PRIMARY KEY (codAplicativo),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE aplicativo;
SELECT * FROM aplicativo;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo,
aplicativo.codAplicativo, aplicativo.logoAplicativo, aplicativo.linkAplicativo, aplicativo.desenvolvedoresAplicativo, aplicativo.gratisAplicativo
FROM conteudo JOIN aplicativo ON conteudo.codConteudo = aplicativo.codConteudo;

CREATE TABLE paginaWeb(
codPagina INT NOT NULL AUTO_INCREMENT,
linkPagina VARCHAR(80) NOT NULL,
autorPagina VARCHAR(40),
codConteudo INT NOT NULL,
PRIMARY KEY (codPagina),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE paginaWeb;
SELECT * FROM paginaweb;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
paginaweb.codPagina, paginaweb.linkPagina, paginaweb.autorPagina
FROM conteudo JOIN paginaweb ON conteudo.codConteudo = paginaweb.codConteudo;

CREATE TABLE evento(
codEvento INT NOT NULL AUTO_INCREMENT,
dataEvento DATE NOT NULL,
localEvento VARCHAR(80) NOT NULL,
responsavelEvento VARCHAR(40) NOT NULL,
codConteudo INT NOT NULL,
PRIMARY KEY (codEvento),
FOREIGN KEY (codConteudo) REFERENCES conteudo(codConteudo)
);

DROP TABLE evento;
SELECT * FROM evento;

SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
evento.dataEvento, evento.localEvento, evento.responsavelEvento
FROM conteudo JOIN evento ON conteudo.codConteudo = evento.codConteudo;






/*CREATE TABLE emocao(
codEmocao INT NOT NULL AUTO_INCREMENT,
tipoEmocao INT NOT NULL,
dataEmocao DATE NOT NULL,
codUsuario INT NOT NULL,
PRIMARY KEY (codEmocao),
FOREIGN KEY (codUsuario) REFERENCES usuario(codUsuario)
); */