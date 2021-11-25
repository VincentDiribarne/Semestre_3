<?php
echo "test<br>";
$bdd = new PDO("mysql:host=localhost;dbname=info2_i202597_TEST", "i202597", "Fkb696fn");
$rep = $bdd->query("SELECT * FROM Pokemon WHERE 1 ");
$lig = $rep->fetch();
echo $lig["Nom"];
?>
