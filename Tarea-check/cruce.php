<?php
session_start();
include("conexion.php");

	if($_SESSION['verificacion'] == 1){
		$persona = $_SESSION['usuario'];

		if ($conex->connect_error) {
		  	die("Connection failed: " . $conex->connect_error);
		}
		$sql = "SELECT * FROM `tareas` WHERE usuario = '$persona' ORDER BY fecha_limite ASC";

		$new = mysqli_query($conex , $sql);

		$cantidad = mysqli_num_rows($new);

		if(isset($_POST['guardar'])){


			for( $g=0; $g < $cantidad; $g++){


				$fila = $new->fetch_assoc();

				$id = $fila['id'];
				
					if($_POST[$id] == 'hecho'){

						$share = "UPDATE `tareas` SET done = 'checked' WHERE id = '$id' and usuario = '$persona'";

						$two = mysqli_query($conex , $share);
					}
					if($_POST[$id] == ''){

						$share2 = "UPDATE `tareas` SET done = '' WHERE id = '$id' and usuario = '$persona'";

						$two = mysqli_query($conex , $share2);
					}

			}

		header('location:bienvenido.php');



		}
		if(isset($_POST['crear'])){

				header("location:crear_tarea.php");



		}
		if(isset($_POST['borrar'])){

				//header("location:borrar.php");
			$persona = $_SESSION['usuario'];

			if ($conex->connect_error) {
		  		die("Connection failed: " . $conex->connect_error);
		}
			$sql = "SELECT * FROM `tareas` WHERE usuario = '$persona' ORDER BY fecha_limite ASC";

			$new = mysqli_query($conex , $sql);

			$cantidad = mysqli_num_rows($new);

			for( $i=0; $i < $cantidad; $i++){

				$fila = $new->fetch_assoc();

				if($fila['done'] == 'checked'){
					$delet = "DELETE FROM `tareas` WHERE done = 'checked'";
					$new2 = mysqli_query($conex , $delet);
				}
			}
					
			header("location:bienvenido.php");


		}
	}else{

			header('location:index.php');

	}
//UPDATE `tareas` SET `done`= '' WHERE done = 'checked'
?>