<?php

class chien
{
    private $name;
    private $age;
    private $pv;
    private $bonheur;
    public $race;

    public function __construct($name, $age)
    {
        $this->name = $name;
        $this->age = $age;
        $this->pv = 100;
        $this->bonheur = 100;
    }

    public function getName()
    {
        return $this->name;
    }

    public function getAge()
    {
        return $this->age;
    }

    public function getPv()
    {
        return $this->pv;
    }

    public function getBonheur()
    {
        return $this->bonheur;
    }

    public function getRace()
    {
        return $this->race;
    }
}
