<?php

class carteAnniv
{
    private $date;
    private $nom;
    private $image;
    private $imageDeFond;
    private $slogan;

    public function __construct($date, $nom, $image, $imageDeFond, $slogan) {
        $this->date = $date;
        $this->nom = $nom;
        $this->image = $image;
        $this->imageDeFond = $imageDeFond;
        $this->slogan = $slogan;
    }

    public function getNom()
    {
        return $this->nom;
    }
    public function getDate()
    {
        return $this->date;
    }
    public function getSlogan()
    {
        return $this->slogan;
    }
    public function getImageDeFond()
    {
        return $this->imageDeFond;
    }
    public function getImage()
    {
        return $this->image;
    }

    public function printHTML() {
        echo "Mon nom : ".$this->getNom(). ", la date : ". $this->getDate(). ", le slogan : " .$this->getSlogan();
        echo "<br>Emplacement fichier Image : " .$this->getImage();
        echo "<br>Emplacement fichier Image de Fond : " .$this->getImageDeFond();
    }
}