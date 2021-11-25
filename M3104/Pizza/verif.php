<?php

try {
    include_once("bdinc.php");
    include_once("Pizza.php");

    $var = $_GET['code'];
    echo $var . '<br>';
    $bdd = new PDO("mysql:host=localhost;dbname=$db_name", $user, $pass);
    $sql = "SELECT * FROM `pizza` WHERE 1";
    //WHERE Nom LIKE '{$var}%'

    echo $sql . '<br>';

    $reponse = $bdd->prepare($sql);

    if (is_object($reponse)) {
        echo 'ok <br>';
        $tmp = $reponse->fetchAll();
        echo 'ok2 <br>';
        foreach ($tmp as $ligne) {
            echo 'ok3 <br>';
            $tmp = new Pizza($ligne['Nom'], $ligne['Base'], $ligne['Fromage'], $ligne['Viande'], $ligne['Supplement1'], $ligne['Supplement2']);
            echo $tmp->innerNomHtml();
        }
        echo 'ok4 <br>';
    }
} catch (PDOExeption $err) {
    echo "Erreur : " . $err->getMessage() . "<br />";
    die();
}
?>
