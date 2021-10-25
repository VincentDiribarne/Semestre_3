<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pokemon</title>
    <link href="main.css" rel="stylesheet">
</head>
<body>
<p class="titre">Trouve ton Pokemon !</p>
<div class="container">
    <form action="index.php" method="post">
        <div class="formulairePokemon">
            <label class="label">Choisi le type dont tu veux recupérer les pokémons</label>
            <select name="type">
                <option value="ACIER">Acier</option>
                <option value="COMBAT">Combat</option>
                <option value="DRAGON">Dragon</option>
                <option value="EAU">Eau</option>
                <option value="ELECTRIQUE">Electrique</option>
                <option value="FEE">Fee</option>
                <option value="FEU">Feu</option>
                <option value="GLACE">Glace</option>
                <option value="INSECTE">Insecte</option>
                <option value="NORMAL">Normal</option>
                <option value="PLANTE">Plante</option>
                <option value="POISON">Poison</option>
                <option value="PSY">Psy</option>
                <option value="ROCHE">Roche</option>
                <option value="SPECTRE">Spectre</option>
                <option value="TENEBRES">Tenebres</option>
                <option value="VOL">Vol</option>
            </select>
            <button class="boutonSubmit" type="submit" name="submit">Recherche</button>
        </div>
    </form>

    <style>
        .aucun {
            color: white;
            font-size: 20px;
            margin-top: 10px;
            margin-left: 15%;
        }

        .pokemon {
            color: white;
            font-size: 20px;
            margin-top: 10px;
            margin-left: 15%;
            font-family: "Arial";
            text-align: justify;
        }
    </style>
    <?php
    $bdd = new PDO("mysql:host=localhost;dbname=info2_i202597_TEST", "i202597", "Fkb696fn");
    if (isset($_POST['type'])) {
        $type = $_POST['type'];

        $sql = "SELECT * FROM Pokemon WHERE Type='{$type}'";
        $rep = $bdd->query($sql);
        $lig = $rep->fetch();

        if ($lig == null) {
            echo '<div class="aucun"> <p>' . "Aucun pokémon n'existe avec le type fourni" . '</p> </div>';
            return;
        }

        echo '<div class="pokemon"> <p>' . $lig['Nom'] . " est un pokemon de type " . $lig['Type'] . ", il possède " . $lig['PV'] . " PV, et peut attaquer grâce à " . $lig['ATTQ'] . '.</p> </div>';
        foreach ($rep as $ligne) {
            echo '<div class="pokemon"> <p>' . $ligne['Nom'] . " est un pokemon de type " . $ligne['Type'] . ", il possède " . $ligne['PV'] . " PV, et peut attaquer grâce à " . $ligne['ATTQ'] . '.</p> </div>';
        }
    }
    ?>
</div>
</body>
</html>