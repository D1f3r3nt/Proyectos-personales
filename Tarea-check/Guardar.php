<?php

include("conexion.php");

if ($conex->connect_error) {
  die("Connection failed: " . $conex->connect_error);
}

if (isset ($_POST['registrarse'])) {

		if (strlen($_POST['usuario']) >= 1 &&
		strlen($_POST['contraseña']) >= 1 &&
		strlen($_POST['nombre']) >= 1 &&
		strlen($_POST['gmail']) >= 1){

			$usuario = trim($_POST['usuario']);


			$fecha_registro = date("d/m/y");

			$password = trim($_POST['contraseña']);

			$contraseña = hash($password, PASSWORD_BCRYPT);


			$nombre = trim($_POST['nombre']);


			$gmail = trim($_POST['gmail']);

			$comprobar = "SELECT * FROM `datos` WHERE usuario = '$usuario' and contrasena = '$contraseña' ";

			$sql = "INSERT INTO datos(usuario, contrasena, nombre, gmail, fecha_registro) VALUES ('$usuario', '$contraseña', '$nombre','$gmail','$fecha_registro')";

			$filas = mysqli_query($conex,$comprobar);

			$probar = mysqli_num_rows($filas);

			if ($probar >= 1){

				header("location:error_registro.php");

			}else{

				if (mysqli_query($conex, $sql)) {

	  				header("location:cuenta_creada.php");

				} else {

	  				header("location:error_cuenta.php");

				}


			}
			

	} 
	else {
				
		header("location:rellenar_campos.php");

	}
}
?>