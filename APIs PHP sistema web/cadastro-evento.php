<?php

$dataEvento = $_GET["dataEvento"];
$localEvento = $_GET["localEvento"];
$responsavelEvento = $_GET["responsavelEvento"];
$codConteudo = $_GET["codConteudo"];



echo "Data: ".$dataEvento. "<br/> Local: ".$localEvento. "<br/> Responsável: ".$responsavelEvento. "<br/> Código: ".$codConteudo. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into evento (dataEvento, localEvento, responsavelEvento, codConteudo) values ('{$dataEvento}', '{$localEvento}', '{$responsavelEvento}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>