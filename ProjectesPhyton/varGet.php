<?php
  
  isset($_GET['ident'])? $id = $_GET['ident']: $_GET['ident']=0;
    //preparo la variable para cuando el usuario le de click se la pase al python.py
    $pepe = $id;
  //$result= shell_exec('C:\Users\josep\AppData\Local\Programs\Python\Python38-32\python.exe ./downloadFilm.py  $id'.$id);
    $tmp = exec("download_film.py $id");

    //header("Location: ./index.php");
    //die();

?>