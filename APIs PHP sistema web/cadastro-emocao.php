<?php

$tipoEmocao = $_GET["tipoEmocao"];
$dataEmocao = $_GET["dataEmocao"];
$codConteudo = $_GET["codConteudo"];




echo "Tipo da emoção: ".$tipoEmocao. "<br/> Data da emoção: ".$dataEmocao. "<br/> Código: ".$codConteudo. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into aplicativo (tipoEmocao, dataEmocao, codConteudo) values ('{$tipoEmocao}', '{$dataEmocao}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>