<?php


class Pokemon
{

    private $_Id;
    private $_Name;
    private $_Html;

    public function __construct($Id, $Name, $Type0nom, $Type0couleur, $Type1nom = NULL, $Type1couleur = NULL, $HP, $Attack, $Defense, $SpAttack, $SpDefense, $Speed, $Description, $PathImg)
    {
        $this->_Id = $Id;
        $this->_Name = $Name;
        $Html = "<p id='" . $Id;

        if ($Type1couleur == NULL && $Type1nom == NULL) {
            $Html .= "' style='background-color: " . $Type0couleur . "'>";
        } else {
            $Html .= "' style='background-image: -webkit-linear-gradient(30deg, " . $Type0couleur . " 50%, " . $Type1couleur . " 50%)'>";
        }

        $Html .= "#" . $Id . " " . $Name . "</br> <img src='images/" . $PathImg . "'></img></br>";

        if ($Type1nom == NULL) {
            $Html .= "Types : " . $Type0nom;
        } else {
            $Html .= "Types : " . $Type0nom . ", " . $Type1nom;
        }
        $Html .= "</br> HP : " . $HP . "</br> Attack : " . $Attack . "</br> Defense : " . $Defense . "</br> SpAttack : " . $SpAttack . "</br> SpDefense : " . $SpDefense . "</br> Speed : " . $Speed . "</p>";
        $this->_Html = $Html;
    }


    public function PrintHTML()
    {
        return $this->_Html;
    }


}


?>