<?php
	
	include("conexion.php");


	if ($conex->connect_error) {
  die("Connection failed: " . $conex->connect_error);
}

	if (isset($_POST['pedir'])){

		if (strlen($_POST['usuario']) >=1 &&
			strlen($_POST['gmail']) >=1){


			$usuario = $_POST['usuario'];

			$gmail = $_POST['gmail'];

			$sql = "SELECT * FROM datos WHERE usuario = '$usuario' and gmail = '$gmail'";

			$new = mysqli_query($conex, $sql);

				
			$filas = mysqli_num_rows($new);

			if ($filas == 1){

				$contenido = $new->fetch_assoc();

				$password = $contenido['contrasena'];

				$asunto = "Contraseña";

				$msg = "Hola buenas tardes, tu contraseña es".$password;

				$header = "From: tarea-check@support.com"/*cuenta que envia*/."\r\n";
				$header .= "Reply-to: tarea-check@support.com"/*lo mismo*/."\r\n";
				$header .= "X-Mailer: PHP/". phpversion();

				$mail = @mail($gmail,$asunto,$msg,$header);

				if($mail){

					header("location:respuesta_password.php");

				}else{

					echo "Mensaje no enviado";

				}


				


			}else{

				header("location:error_password.php");


			}


		}else{

			header("location:Enviar_password.php");

		}


	}



?>