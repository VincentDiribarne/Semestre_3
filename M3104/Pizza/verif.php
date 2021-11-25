<?php

try {
    include_once("bdinc.php");
    include_once("Pizza.php");

    $var = $_GET['code'];
    echo $var . '<br>';
    $bdd = new PDO("mysql:host=localhost;dbname=info2_i202597_php", "i202597", "Fkb696fn");
    $sql = "SELECT * FROM `pizza` WHERE Nom LIKE '{$var}%'";

    echo $sql . '<br>';

    $reponse = $bdd->query($sql);

    if (is_object($reponse)) {
        $tmp = $reponse->fetchAll();
        foreach ($tmp as $ligne) {
            $tmp = new Pizza($ligne['Nom'], $ligne['Base'], $ligne['Fromage'], $ligne['Viande'], $ligne['Supplement1'], $ligne['Supplement2']);
            echo $tmp->innerNomHtml();
        }
    }
} catch (PDOExeption $err) {
    echo "Erreur : " . $err->getMessage() . "<br />";
    die();
}
?>
