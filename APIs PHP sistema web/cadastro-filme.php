<?php

$capaFilme = $_GET["capaFilme"];
$sinopseFilme = $_GET["sinopseFilme"];
$duracaoFilme = $_GET["duracaoFilme"];
$anoLancamentoFilme = $_GET["anoLancamentoFilme"];
$plataformaFilme = $_GET["plataformaFilme"];
$codConteudo = $_GET["codConteudo"];



echo "Capa: ".$capaFilme. "<br/> Sinopse: ".$sinopseFilme. "<br/> Duração: ".$duracaoFilme. "<br/> Ano de lançamento: ".$anoLancamentoFilme. "<br/> Plataforma: ".$plataformaFilme. "<br/> Código: ".$codConteudo. "<br/>";


$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into filme (capaFilme, sinopseFilme, duracaoFilme, anoLancamentoFilme, plataformaFilme, codConteudo) values ('{$capaFilme}', '{$sinopseFilme}', '{$duracaoFilme}', '{$anoLancamentoFilme}', '{$plataformaFilme}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>