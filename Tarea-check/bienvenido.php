
	<?php

	include("conexion.php");	
	session_start();

		if($_SESSION['verificacion'] == 1){

			$persona = $_SESSION['usuario'];

			if ($conex->connect_error) {
		  		die("Connection failed: " . $conex->connect_error);
		}
			$sql = "SELECT * FROM `tareas` WHERE usuario = '$persona' ORDER BY fecha_limite ASC";

			$new = mysqli_query($conex , $sql);

			$cantidad = mysqli_num_rows($new);

			echo "<html>
				<head>
					<title>
						Tarea-check
					</title>
					<meta charset='utf-8'>
					<link rel='stylesheet' type='text/css' href='estilos/estilos3.css'>
					<link rel='shortcut icon' href='imagenes/icono.ico'>
					<script data-ad-client='ca-pub-5475010456455777' async src='https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js'></script>
					<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>
				</head>
				<body>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<center>
				<div class='imagen'>
						<a href='index.php'>
						<img src='imagenes/icono.png' width='100' height='100'></a>
				</div>
				<table border='0'>
					<tr>
						<td>
						<form method='POST' action='cruce.php'>
						<center>
								<input type='submit' name='crear' value='Crear'>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<input type='submit' name='borrar' value='Limpiar'>
						</center>
						<br><br><br>	";
					
			for( $i=0; $i < $cantidad; $i++){

				$fila = $new->fetch_assoc();
				$iden = $fila['id'];

				if($fila['done'] == 'checked'){
					$vdd =  "checked='checked'";
				}else{
					$vdd = "";
				}
					$viajando = $i;
				echo "<label><input value='hecho' type='checkbox' name='".$iden."' ".$vdd."></input>";
				echo "//";
				echo $fila['fecha_limite'];
				echo "//&nbsp";
				echo  $fila['tarea'];
				echo "</label>";
				echo "<br>";



			}

			if($cantidad == 0){

				echo "<center><font size=5>Aun no tienes ningua tarea<br>crea una</font></center>";

			}
				
			echo "			
						<br><br>
						<center>
							<input type='submit' name='guardar' value='Guardar'>
						</center>
						</form>
						</td>
					</tr>
				</table>
			</center>
			</form>
			</body>
		</html>";

	}else{

			header('location:index.php');

	}






	?>
