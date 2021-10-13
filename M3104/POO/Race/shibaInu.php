<?php

class shibaInu extends chien
{
    public function __construct($name, $age)
    {
        parent::__construct($name, $age);
        $this->race = "Shiba Inu";
    }
}