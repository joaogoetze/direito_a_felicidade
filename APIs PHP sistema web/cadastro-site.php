<?php

$linkPagina = $_GET["linkPagina"];
$autorPagina = $_GET["autorPagina"];
$codConteudo = $_GET["codConteudo"];


echo "Link: ".$linkPagina. "<br/> Autor: ".$autorPagina. "<br/> Código: ".$codConteudo. "<br/>";


$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into paginaWeb (linkPagina, autorPagina, codConteudo) values ('{$linkPagina}', '{$autorPagina}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>