<?php

$host = "127.0.0.1";
$user = "root";
$pass = "";
$dbname = "projeto";
$port = 3306;
try{
    //Conexão com a porta
    //$conn = new PDO("mysql:host=$host;port=$port;dbname=" . $dbname, $user, $pass);

    //Conexão sem a porta
    $conn = new PDO("mysql:host=$host;dbname=" . $dbname, $user, $pass);

    echo "Conexão com banco de dados realizado com sucesso! <br><br>";
}  catch(PDOException $err){
    echo "Erro: Conexão com banco de dados não foi realizada com sucesso. Erro gerado " . $err->getMessage();
}


$dados = filter_input_array(INPUT_POST, FILTER_DEFAULT);
var_dump($dados);

echo "<br><br>";

$capaCanal = $_FILES["capaCanal"];

var_dump($capaCanal);
echo "<br>";

    $capa_canal_blob = file_get_contents($capaCanal['tmp_name']);

    $query_teste = "INSERT INTO canalYoutube (linkCanal, capaCanal, codConteudo) VALUES (:linkCanal, :capaCanal, :codConteudo)";
    $cad_arquivo = $conn->prepare($query_teste);
    $cad_arquivo->bindParam(':linkCanal', $dados['linkCanal']);
    $cad_arquivo->bindParam(':capaCanal', $capa_canal_blob);
    $cad_arquivo->bindParam(':codConteudo', $dados['codConteudo']);
    echo "<br>$query_teste<br>";
    $cad_arquivo->execute();

    if($cad_arquivo->rowCount()){
        echo "<p style='color: green;'>Arquivo cadastrado com sucesso!</p>";
    }else{
        echo "<p style='color: #f00;'>Erro: Arquivo não cadastrado com sucesso!</p>";
    }
    
    echo "<br> Adicionado com sucesso";
     
?>