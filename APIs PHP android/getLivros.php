<?php 
header('Content-Type: application/json; charset=utf-8');

$livros = array();
// Recebe os parâmetros dos sites


$response = array();
// Recebe os sites


$livros ["erro"] = true;

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
			livro.codLivro, livro.editoraLivro, livro.capaLivro, livro.anoLivro, livro.paginasLivro, livro.autorLivro, livro.generoLivro
			FROM conteudo JOIN livro ON conteudo.codConteudo = livro.codConteudo";

	$result = $conn->query($sql);

	if ($result->num_rows > 0) 
	{ 

		$qtdDados = $result->num_rows;
		

		for($i = 0; $i < $qtdDados; $i++)
		{
		$registro = mysqli_fetch_array($result);	
	
		$livros["codConteudo"]   = $registro['codConteudo'];
		$livros["nomeConteudo"]   = $registro['nomeConteudo'];
		$livros["descricaoConteudo"]   = $registro['descricaoConteudo'];
		$livros["descricaoIndicacao"]   = $registro['descricaoIndicacao'];
		$livros["tematicaConteudo"]   = $registro['tematicaConteudo'];
		$livros["listaTematicaConteudo"]   = $registro['listaTematicaConteudo'];
		$livros["editoraLivro"]  = $registro['editoraLivro'];
		$livros["capaLivro"] = $registro['capaLivro'];
		$livros["anoLivro"] = $registro['anoLivro'];
		$livros["paginasLivro"] = $registro['paginasLivro'];
		$livros["autorLivro"] = $registro['autorLivro'];
		$livros["generoLivro"] = $registro['generoLivro'];


		$response["registros"] = $result->num_rows;
		$response["erro"]= false;
		$response["livros"][$i] = $livros;
		}
		
		

	 } 
	 else
	 {
	 	$livros	["mensagem"] = "nenhuma página encontrada";	
	 }
	 $conn->close();
	}


	echo json_encode($response);
?>