<?php

$logoAplicativo = $_GET["logoAplicativo"];
$linkAplicativo = $_GET["linkAplicativo"];
$desenvolvedoresAplicativo = $_GET["desenvolvedoresAplicativo"];
$gratisAplicativo = $_GET["gratisAplicativo"];
$codConteudo = $_GET["codConteudo"];




echo "Logo: ".$logoAplicativo. "<br/> Link: ".$linkAplicativo. "<br/> Desenvolvedores: ".$desenvolvedoresAplicativo. "<br/> Grátis: ".$gratisAplicativo. "<br/> Código: ".$codConteudo. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into aplicativo (logoAplicativo, linkAplicativo, desenvolvedoresAplicativo, gratisAplicativo, codConteudo) values ('{$logoAplicativo}', '{$linkAplicativo}', '{$desenvolvedoresAplicativo}', '{$gratisAplicativo}', '{$codConteudo}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>