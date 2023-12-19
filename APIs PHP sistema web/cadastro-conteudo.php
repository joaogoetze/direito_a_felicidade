<?php

$nomeConteudo = $_GET["nomeConteudo"];
$descricaoConteudo = $_GET["descricaoConteudo"];
$descricaoIndicacao = $_GET["descricaoIndicacao"];
$tematicaConteudo = $_GET["tematicaConteudo"];




echo "Nome: ".$nomeConteudo. "<br/> Descrição do conteúdo: ".$descricaoConteudo. "<br/> Descrição da indicação: ".$descricaoIndicacao. "<br/> Temática: ".$tematicaConteudo. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into conteudo (nomeConteudo, descricaoConteudo, descricaoIndicacao, tematicaConteudo) values ('{$nomeConteudo}', '{$descricaoConteudo}', '{$descricaoIndicacao}', '{$tematicaConteudo}')";
    mysqli_query($con, $query);

    echo "<br>";
    echo "Adicionado com sucesso!";
    mysqli_close($con);
    
    

}

?>