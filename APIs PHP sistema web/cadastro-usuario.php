<?php

$nomeUsuario = $_GET["nomeUsuario"];
$generoUsuario = $_GET["generoUsuario"];
$tipoUsuario = $_GET["tipoUsuario"];
$emailUsuario = $_GET["emailUsuario"];
$senhaUsuario = $_GET["senhaUsuario"];
$matriculaEstudante = $_GET["matriculaEstudante"];
$matriculaServidor = $_GET["matriculaServidor"];
$cargoServidor = $_GET["cargoServidor"];
$siapeServidor = $_GET["siapeServidor"];


echo "Nome: ".$nomeUsuario. "<br/> Gênero: ".$generoUsuario. "<br/> Tipo: ".$tipoUsuario. "<br/> E-mail: ".$emailUsuario. "<br/> Senha: ".$senhaUsuario. "<br/> Matrícula do estudante: ".$matriculaEstudante. "<br/> Matrícula do servidor: ".$matriculaServidor. "<br/> Cargo: ".$cargoServidor. "<br/> Siape: ".$siapeServidor. "<br/>";

$hostname = "127.0.0.1";
$bancodedados   = "projeto";
$usuario = "root";
$senha = "";

$con = mysqli_connect($hostname, $usuario, $senha, $bancodedados);

if ($con->connect_error) {
	echo "Erro ao estabelecer conexão";
} else {

    
    
    $query = "insert into usuario (nomeUsuario, generoUsuario, tipoUsuario, emailUsuario, senhaUsuario, matriculaEstudante, matriculaServidor, cargoServidor, siapeServidor) values ('{$nomeUsuario}', '{$generoUsuario}', '{$tipoUsuario}', '{$emailUsuario}', '{$senhaUsuario}', '{$matriculaEstudante}', '{$matriculaServidor}', '{$cargoServidor}', '{$siapeServidor}')";
    mysqli_query($con, $query);

    echo "<br> Adicionado com sucesso";
    mysqli_close($con);
    
    

}

?>