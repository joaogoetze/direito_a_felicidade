<?php 
header('Content-Type: application/json; charset=utf-8');

$canal = array();
// Recebe os parâmetros dos sites

$response = array();
// Recebe os sites

$canal ["erro"] = true;

	if ($_SERVER['REQUEST_METHOD'] == 'POST') 
	{

		include 'dbConnection.php';

		$conn = new mysqli($HostName, $HostUser, $HostPass, $DatabaseName);

		mysqli_set_charset($conn, "utf8");

		if ($conn->connect_error)
		{
			die("Ops, falhou...:" . $conn->connect_error);
		}
		
		$sql = "SELECT conteudo.codConteudo, conteudo.nomeConteudo, conteudo.descricaoConteudo, 
		conteudo.descricaoIndicacao, conteudo.tematicaConteudo, canalYoutube.codCanal, 
		canalYoutube.linkCanal, canalYoutube.capaCanal, canalYoutube.codConteudo
		FROM conteudo JOIN canalYoutube ON conteudo.codConteudo = canalYoutube.codConteudo";

		$result = $conn->query($sql);

		if ($result->num_rows > 0) 
		{ 

			$qtdDados = $result->num_rows;	

			for($i = 0; $i < $qtdDados; $i++)
			{
				$registro = mysqli_fetch_array($result);	
		
				$canal["codConteudo"] = $registro['codConteudo'];
				$canal["nomeConteudo"] = $registro['nomeConteudo'];
				$canal["descricaoConteudo"] = $registro['descricaoConteudo'];
				$canal["descricaoIndicacao"] = $registro['descricaoIndicacao'];
				$canal["tematicaConteudo"] = $registro['tematicaConteudo'];
				$canal["linkCanal"] = $registro['linkCanal'];
		
				$canal["capaCanal"][] = base64_encode($registro['capaCanal']);

				$response["registros"] = $result->num_rows;
				$response["erro"]= false;
				$response["canal"][$i] = $canal;
			}	
		} 
		else
		{
			$canal["mensagem"] = "nenhum canal encontrado";	
		}
		$conn->close();
	}
	echo json_encode($response);
?>