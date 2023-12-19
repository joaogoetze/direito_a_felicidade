<?php

$capaSerie = $_GET["capaSerie"];
$sinopseSerie = $_GET["sinopseSerie"];
$temporadaSerie = $_GET["temporadaSerie"];
$anoLancamentoSerie = $_GET["anoLancamentoSerie"];
$plataformaSerie = $_GET["plataformaSerie"];
$codConteudo = $_GET["codConteudo"];



echo "Capa: ".$capaSerie. "<br/> Sinopse: ".$sinopseSerie. "<br/> Temporada: ".$temporadaSerie. "<br/> Ano de lançamento: ".$anoLancamentoSerie. "<br/> Plataforma: ".$plataformaSerie. "<br/> Código: ".$codConteudo. "<br/>";


$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into serie (capaSerie, sinopseSerie, temporadaSerie, anoLancamentoSerie, plataformaSerie, codConteudo) values ('{$capaSerie}', '{$sinopseSerie}', '{$temporadaSerie}', '{$anoLancamentoSerie}', '{$plataformaSerie}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>