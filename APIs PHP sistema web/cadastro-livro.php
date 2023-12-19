<?php


$editoraLivro = $_GET["editoraLivro"];
$capaLivro = $_GET["capaLivro"];
$anoLivro = $_GET["anoLivro"];
$paginasLivro = $_GET["paginasLivro"];
$autorLivro = $_GET["autorLivro"];
$generoLivro = $_GET["generoLivro"];
$codConteudo = $_GET["codConteudo"];


echo "Editora: ".$editoraLivro. "<br/> Capa: ".$capaLivro. "<br/> Ano: ".$anoLivro. "<br/> Páginas: ".$paginasLivro. "<br/> Autor: ".$autorLivro. "<br/> Gênero: ".$generoLivro. "<br/> Código: ".$codConteudo. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into livro (editoraLivro, capaLivro, anoLivro, paginasLivro, autorLivro, generoLivro, codConteudo) values ('{$editoraLivro}', '{$capaLivro}', '{$anoLivro}', '{$paginasLivro}', '{$autorLivro}', '{$generoLivro}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>