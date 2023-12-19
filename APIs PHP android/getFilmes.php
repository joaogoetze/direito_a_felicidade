<?php 
header('Content-Type: application/json; charset=utf-8');

$filme = array();
// Recebe os parâmetros dos sites


$response = array();
// Recebe os sites


$filme ["erro"] = true;

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	include 'dbConnection.php';

	$conn = new mysqli($HostName, $HostUser, $HostPass, $DatabaseName);

	mysqli_set_charset($conn, "utf8");

	if ($conn->connect_error)
	{
		die("Ops, falhou...:" . $conn->connect_error);
	}
	

	
	$sql = "SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
			conteudo.descricaoIndicacao, conteudo.tematicaConteudo, conteudo.listaTematicaConteudo, 
			filme.capaFilme, filme.sinopseFilme, filme.duracaoFilme, filme.anoLancamentoFilme, filme.plataformaFilme
			FROM conteudo JOIN filme ON conteudo.codConteudo = filme.codConteudo;";

	$result = $conn->query($sql);

	if ($result->num_rows > 0) 
	{ 

		$qtdDados = $result->num_rows;
		

		for($i = 0; $i < $qtdDados; $i++)
		{
		$registro = mysqli_fetch_array($result);	
	
		$filme["codConteudo"]   = $registro['codConteudo'];
		$filme["nomeConteudo"]   = $registro['nomeConteudo'];
		$filme["descricaoConteudo"]   = $registro['descricaoConteudo'];
		$filme["descricaoIndicacao"]   = $registro['descricaoIndicacao'];
		$filme["tematicaConteudo"]   = $registro['tematicaConteudo'];
		$filme["listaTematicaConteudo"]   = $registro['listaTematicaConteudo'];
		
		$filme["capaFilme"] = $registro['capaFilme'];
		$filme["sinopseFilme"] = $registro['sinopseFilme'];
		$filme["duracaoFilme"] = $registro['duracaoFilme'];
		$filme["anoLancamentoFilme"] = $registro['anoLancamentoFilme'];
		$filme["plataformaFilme"] = $registro['plataformaFilme'];
		


		$response["registros"] = $result->num_rows;
		$response["erro"]= false;
		$response["filmes"][$i] = $filme;
		}
		
		

	 } 
	 else
	 {
	 	$filme	["mensagem"] = "nenhum filme encontrado";	
	 }
	 $conn->close();
	}


	echo json_encode($response);
?>