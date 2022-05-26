<?php
	include("conexion.php");	
	session_start();

			if($_SESSION['verificacion'] == 1){

				if(isset($_POST['salir'])){


					header("location:bienvenido.php");


				}

				if(isset($_POST['enviar'])){

					if(strlen($_POST['msg']) >= 1 && strlen($_POST['fecha']) >= 1){

					$persona = $_SESSION['usuario'];

					$msg = trim($_POST['msg']);

					$fecha = $_POST['fecha'];

					if ($conex->connect_error) {
		  					die("Connection failed: " . $conex->connect_error);
					}
					$sql = "INSERT INTO `tareas`( usuario, tarea, fecha_limite, `done`) VALUES ('$persona','$msg','$fecha','')";

					if (mysqli_query($conex, $sql)) {

	  				header("location:bienvenido.php");

				} else {

	  				header("location:error_subiendo.php");

				}

				}else{

					header('location:error_subiendo.php');

				}

			}
		}else{

				header('location:index.php');
			}
?>