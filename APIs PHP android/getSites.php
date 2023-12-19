<?php 
header('Content-Type: application/json; charset=utf-8');

$sites = array();
// Recebe os parâmetros dos sites


$response = array();
// Recebe os sites


$sites ["erro"] = true;

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	include 'dbConnection.php';

	$conn = new mysqli($HostName, $HostUser, $HostPass, $DatabaseName);

	mysqli_set_charset($conn, "utf8");

	if ($conn->connect_error)
	{
		die("Ops, falhou...:" . $conn->connect_error);
	}
	

	
	$sql = "SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
	   		conteudo.descricaoIndicacao, conteudo.tematicaConteudo, 
       		paginaweb.codPagina, paginaweb.linkPagina, paginaweb.autorPagina
			FROM conteudo JOIN paginaweb ON conteudo.codConteudo = paginaweb.codConteudo";

	$result = $conn->query($sql);

	if ($result->num_rows > 0) 
	{ 

		$qtdDados = $result->num_rows;
		

		for($i = 0; $i < $qtdDados; $i++)
		{
		$registro = mysqli_fetch_array($result);	
	
		$sites["codConteudo"]   = $registro['codConteudo'];
		$sites["nomeConteudo"]   = $registro['nomeConteudo'];
		$sites["descricaoConteudo"]   = $registro['descricaoConteudo'];
		$sites["descricaoIndicacao"]   = $registro['descricaoIndicacao'];
		$sites["tematicaConteudo"]   = $registro['tematicaConteudo'];
		$sites["linkPagina"]  = $registro['linkPagina'];
		$sites["autorPagina"] = $registro['autorPagina'];

		$response["registros"] = $result->num_rows;
		$response["erro"]= false;
		$response["sites"][$i] = $sites;
		}
		
		

	 } 
	 else
	 {
	 	$sites["mensagem"] = "nenhuma página encontrada";	
	 }
	 $conn->close();
	}


	echo json_encode($response);
?>