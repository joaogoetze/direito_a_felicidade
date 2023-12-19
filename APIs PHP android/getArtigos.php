<?php 
header('Content-Type: application/json; charset=utf-8');

$artigo = array();
// Recebe os parâmetros dos sites

$response = array();
// Recebe os sites

$artigo ["erro"] = true;

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
				artigo.codArtigo, artigo.linkArtigo, artigo.resumoArtigo, artigo.anoPublicacao, artigo.autorArtigo
				FROM conteudo JOIN artigo ON conteudo.codConteudo = artigo.codConteudo";

		$result = $conn->query($sql);

		if ($result->num_rows > 0) 
		{ 
			$qtdDados = $result->num_rows;
			
			for($i = 0; $i < $qtdDados; $i++)
			{
				$registro = mysqli_fetch_array($result);	
			
				$artigo["codConteudo"]   = $registro['codConteudo'];
				$artigo["nomeConteudo"]   = $registro['nomeConteudo'];
				$artigo["descricaoConteudo"]   = $registro['descricaoConteudo'];
				$artigo["descricaoIndicacao"]   = $registro['descricaoIndicacao'];
				$artigo["tematicaConteudo"]   = $registro['tematicaConteudo'];
				$artigo["listaTematicaConteudo"]   = $registro['listaTematicaConteudo'];
				$artigo["linkArtigo"] = $registro['linkArtigo'];
				$artigo["resumoArtigo"] = $registro['resumoArtigo'];
				$artigo["anoPublicacao"] = $registro['anoPublicacao'];
				$artigo["autorArtigo"] = $registro['autorArtigo'];

				$response["registros"] = $result->num_rows;
				$response["erro"]= false;
				$response["artigo"][$i] = $artigo;
			}
		} 
		else
		{
			$artigo	["mensagem"] = "nenhum artigo encontrado";	
		}
		$conn->close();
	}

	echo json_encode($response);
?>