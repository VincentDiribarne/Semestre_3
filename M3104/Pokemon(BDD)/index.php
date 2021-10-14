<?php
include_once("db.inc.php");
try {
    $db = new PDO("$server:host=$host;dmname=$base", $user, $pass);
    $sql = "SELECT Nom, Type, PV, ATTQ FROM Pokemon";
    $reponse = $db->query($sql);

    echo "avant is object";

    while ($ligne = $reponse->fetch()) {
        echo $ligne["Nom"] . "\t de type ";
        echo $ligne["Type"] . "\t avec ";
        echo $ligne["PV"] . " pv \t et qui utilise ";
        echo $ligne["ATTQ"] . " comme attaque !\n";
    }

} catch (PDOException $e) {
    echo nl2br("Erreur : " . $e->getMessage());
    die();
}