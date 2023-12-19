<?php 
header('Content-Type: application/json; charset=utf-8');

$aplicativo = array();
// Recebe os parâmetros dos sites

$response = array();
// Recebe os sites

$aplicativo ["erro"] = true;

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
				conteudo.descricaoIndicacao, conteudo.tematicaConteudo, conteudo.listaTematicaConteudo, 
				aplicativo.codAplicativo, aplicativo.logoAplicativo, aplicativo.linkAplicativo, aplicativo.desenvolvedoresAplicativo,aplicativo.gratisAplicativo
				FROM conteudo JOIN aplicativo ON conteudo.codConteudo = aplicativo.codConteudo";

		$result = $conn->query($sql);

		if ($result->num_rows > 0) 
		{ 
			$qtdDados = $result->num_rows;
			
			for($i = 0; $i < $qtdDados; $i++)
			{
				$registro = mysqli_fetch_array($result);	
			
				$aplicativo["codConteudo"]   = $registro['codConteudo'];
				$aplicativo["nomeConteudo"]   = $registro['nomeConteudo'];
				$aplicativo["descricaoConteudo"]   = $registro['descricaoConteudo'];
				$aplicativo["descricaoIndicacao"]   = $registro['descricaoIndicacao'];
				$aplicativo["tematicaConteudo"]   = $registro['tematicaConteudo'];
				$aplicativo["listaTematicaConteudo"]   = $registro['listaTematicaConteudo'];
				$aplicativo["logoAplicativo"] = $registro['logoAplicativo'];
				$aplicativo["linkAplicativo"] = $registro['linkAplicativo'];
				$aplicativo["desenvolvedoresAplicativo"] = $registro['desenvolvedoresAplicativo'];
				$aplicativo["gratisAplicativo"] = $registro['gratisAplicativo'];
				
				$response["registros"] = $result->num_rows;
				$response["erro"]= false;
				$response["aplicativo"][$i] = $aplicativo;
			}
		} 
		else
		{
			$aplicativo	["mensagem"] = "nenhum aplicativo encontrado";	
		}
		$conn->close();
	}

	echo json_encode($response);
?>