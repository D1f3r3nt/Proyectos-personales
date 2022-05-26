<?php

	include("conexion.php");	

		if ($conex->connect_error) {
	  		die("Connection failed: " . $conex->connect_error);
	}

	if(isset($_POST['entrar'])){

			if(strlen($_POST['usuario']) >=1 && strlen($_POST['password']) >=1){

				$usuario = trim($_POST['usuario']);

				$password = hash(trim($_POST['password']),PASSWORD_BCRYPT);

				$sql = "SELECT * FROM datos WHERE usuario = '$usuario' and contrasena = '$password'";

				$new = mysqli_query($conex , $sql);

					if (mysqli_query($conex, $sql)) {
	  				echo "New record created successfully";
				} else {
	  				echo "Error: " . $sql . "<br>" . mysqli_error($conex);
				}

				$filas = mysqli_num_rows($new);

				if($filas == 1){

					$verificacion = 1;
					session_start();
					$_SESSION['usuario'] = $usuario;
					$_SESSION['verificacion'] = $verificacion;
					header("location:bienvenido.php");


				}
				else{


					header("location:error_inicio.php");

					
				}

			}
			else{

				header("location:rellenar_campos2.php");

			}





	}


?>