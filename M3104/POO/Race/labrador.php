<?php
include_once('chien.php');

class Labrador extends Chien
{
    public function __construct($name, $age)
    {
        parent::__construct($name, $age);
        $this->race = "Labrador";
    }
}

