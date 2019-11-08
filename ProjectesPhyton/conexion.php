<?php

    $usuario = "root";
    $contrasena = "";
    $servidor = "localhost";
    $basededatos = "peliculas";

    //hago la conexion a la base de datos
    $conexion = mysqli_connect($servidor,$usuario,"") or die("No se ha podido conectar con el servidor");
   
   //sirve para codificar los accentos y poder transcribirlos posteriormente a la hora de hacerle un echo
    mysqli_query($conexion,"SET NAMES 'utf8'"); 

    //selecciono la base de datos 
    $db = mysqli_select_db($conexion, $basededatos) or die("Error en mysqli_select_db");

    //hago la consulta a la base de datos
    $consulta = "SELECT * FROM pelicula";

    //guardo el resultado en una variable llamada $resultado
    $resultado = mysqli_query($conexion, $consulta) or die("Error en la sintaxis de la consulta");

?>