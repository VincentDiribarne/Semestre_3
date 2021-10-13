<?php
include_once("chien.php");
include_once("Race/bergerAllemand.php");
include_once("Race/shibaInu.php");
include_once("Race/labrador.php");

$medor = new Labrador("Medor", 5);
$brutus = new bergerAllemand("Brutus", 13);
$naomi = new shibaInu("Naomi", 2);


echo nl2br("Vous possedez 3 chiens.\n");
echo nl2br("\n".$medor->getName() . " est un chien de " .$medor->getAge(). " ans. C'est un " .$medor->getRace().". Il possède actuellement " .$medor->getPv(). " PV et " .$medor->getBonheur(). " de bonheur !\n");
echo nl2br($brutus->getName() . " est un chien de " .$brutus->getAge(). " ans. C'est un " .$brutus->getRace().". Il possède actuellement " .$brutus->getPv(). " PV et " .$brutus->getBonheur(). " de bonheur !\n");
echo nl2br($naomi->getName() . " est un chien de " .$naomi->getAge(). " ans. C'est un " .$naomi->getRace().". Il possède actuellement " .$naomi->getPv(). " PV et " .$naomi->getBonheur(). " de bonheur !\n");
?>

