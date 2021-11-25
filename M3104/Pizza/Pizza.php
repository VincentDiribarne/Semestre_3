<?php

class Pizza
{
    private $nom;
    private $base;
    private $fromage;
    private $viande;
    private $suppl1;
    private $suppl2;

    public function __construct($nom, $base, $fromage, $viande, $suppl1, $suppl2)
    {
        $this->nom = $nom;
        $this->base = $base;
        $this->fromage = $fromage;
        $this->viande = $viande;
        $this->suppl1 = $suppl1;
        $this->suppl2 = $suppl2;
    }

    public function getNom()
    {
        return $this->nom;
    }

    public function getBase()
    {
        return $this->base;
    }

    public function getFromage()
    {
        return $this->fromage;
    }

    public function getViande()
    {
        return $this->viande;
    }

    public function getSuppl1()
    {
        return $this->suppl1;
    }

    public function getSuppl2()
    {
        return $this->suppl2;
    }

    public function innerNomHtml() {
        echo "<option>". $this->getNom(). "</option><br>";
    }

    public function toString()
    {
        echo "La pizza " . $this->getNom() . " est composé de  " . $this->getBase() . ", " . $this->getFromage() . ", " . $this->getViande() . ", " . $this->getSuppl1() . ", " . $this->getSuppl2();
    }
}