<?php

$linkArtigo = $_GET["linkArtigo"];
$resumoArtigo = $_GET["resumoArtigo"];
$anoPublicacao = $_GET["anoPublicacao"];
$autorArtigo = $_GET["autorArtigo"];
$codConteudo = $_GET["codConteudo"];



echo "Link: ".$linkArtigo. "<br/> Resumo: ".$resumoArtigo. "<br/> Ano: ".$anoPublicacao. "<br/> Autor: ".$autorArtigo. "<br/> Código: ".$codConteudo. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into artigo (linkArtigo, resumoArtigo, anoPublicacao, autorArtigo, codConteudo) values ('{$linkArtigo}', '{$resumoArtigo}', '{$anoPublicacao}', '{$autorArtigo}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>