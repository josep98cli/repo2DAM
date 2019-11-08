<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Scrapping Pelicules</title>
    <link rel="stylesheet" type="text/css" href="./estilos/estilsIndex.css">
</head>

<body>
    <?php 
        include './conexion.php';

        echo "<table class='peliculas'>";
        //hago un bucle while que hasta que columna no sea NULL es decir ya no hay mas peliculas se ejecute
        //convierto con fetch_array la variable $resultado a una array associativo
        while($columna = mysqli_fetch_array($resultado)){

            //accedo dentro de cada pelicula uno a uno y saque el contenido que creo necesario
            echo "<tr>";
            echo "<td><a id='tituloPeliculas' href='./varGet.php?ident=$columna[id_pelicula]'>".$columna['titulo']."</a></td>";
            echo "</tr>";
            
        }
        echo "</table>";
    ?>
</body>

</html>