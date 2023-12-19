<?php 
header('Content-Type: application/json; charset=utf-8');

	
$response = array();
$response ["erro"] = true;

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	include 'dbConnection.php';

	$conn = new mysqli($HostName, $HostUser, $HostPass, $DatabaseName);

	mysqli_set_charset($conn, "utf8");

	if ($conn->connect_error) {
		die("Ops, falhou...:" . $conn->connect_error);
	}

	$emailUsuario = "'".$_POST['emailUsuario']."'";
	$senhaUsuario = "'".$_POST['senhaUsuario']."'";

	$sql = "SELECT * FROM usuario WHERE emailUsuario = $emailUsuario AND senhaUsuario = $senhaUsuario "; 

	$result = $conn->query($sql);

	if ($result->num_rows > 0) {

	$registro = mysqli_fetch_array($result);	

	$response["registros"] = $result->num_rows; 
	$response["erro"] = false; 	
	$response["emailUsuario"]  = 	$registro['emailUsuario'];
	$response["senhaUsuario"]  = 	$registro['senhaUsuario'];
	$response["nomeUsuario"]  = 	$registro['nomeUsuario']; 
	$response["generoUsuario"]  = 	$registro['generoUsuario']; 
	$response["tipoUsuario"]  = 	$registro['tipoUsuario']; 
	
	 } else{

	 	$response["mensagem"] = "Usuario não existe";
	 	
	 }

	 $conn->close();
	}

	echo json_encode($response);

?>