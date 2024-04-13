<?php

$host = "localhost";
$user = "root";
$pass = "";
$dbname = "projeto";
$port = 3306;
try{
    //Conexão com a porta
    $conn = new PDO("mysql:dbname=banco;host=localhost", "root", "root");

    //Conexão sem a porta
    //$conn = new PDO("mysql:host=$host;dbname=" . $dbname, $user, $pass);

    //echo "Conexão com banco de dados realizado com sucesso!";
}  catch(PDOException $err){
    echo "Erro: Conexão com banco de dados não foi realizada com sucesso. Erro gerado " . $err->getMessage();
}

?>