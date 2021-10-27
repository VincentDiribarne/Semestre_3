<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>TP_NOTE</title>
    <link href="pokedex.css" rel="stylesheet">
</head>
<body>
<div class="pokedex">
    <div class="pan_right"></div>
    <div class="pan_screen">
        <?php
        include_once("db.inc.php");
        include_once("pokemon.class.php");

        if (isset($_POST['tri'])) {
            try {
                $bdd = new PDO("mysql:host=localhost;dbname=$db_name", $user, $pass);
                $sql = "SELECT * FROM `pokedex` WHERE 1";
                $arguments = array();

                if ($_POST['type0'] != "EMPTY") {
                    $sql .= " AND types0nom = ?";
                    array_push($arguments, $_POST['type0']);
                }


                if ($_POST['type1'] != "EMPTY") {
                    $sql .= " AND types1nom = ?";
                    array_push($arguments, $_POST['type1']);
                }

                if ($_POST['condition'] != "EMPTY" && $_POST['operator'] != "EMPTY" && $_POST['MinMaxValue'] != "EMPTY") {
                    $variable = $_POST['condition'] . $_POST['operator'] . $_POST['MinMaxValue'];
                    $sql .= " AND {$variable}";
                    array_push($arguments, $_POST['condition']);
                }

                if ($_POST['trier'] != "EMPTY") {
                    $variable = $_POST['trier'] . " " . $_POST['groupe'];
                    $sql .= " ORDER BY {$variable}";
                    array_push($arguments, $_POST['trier']);
                }

                $reponse = $bdd->prepare($sql);

                if (is_object($reponse)) {
                    $reponse->execute($arguments);
                    $tmp = $reponse->fetchAll();
                    foreach ($tmp as $ligne) {
                        $tmp = new Pokemon($ligne['id'], $ligne['nom'], $ligne['types0nom'], $ligne['types0couleur'], $ligne['types1nom'], $ligne['types1couleur'], $ligne['baseHP'], $ligne['baseAttack'], $ligne['baseDefense'], $ligne['baseSpAttack'], $ligne['baseSpDefense'], $ligne['baseSpeed'], $ligne['description'], $ligne['image']);
                        echo $tmp->printHTML();
                    }
                }

            } catch (PDOExeption $err) {
                echo "Erreur : " . $err->getMessage() . "<br />";
                die();
            }
        }

        if (isset($_POST['modifier']) && $_POST['MinMaxId'] != "EMPTY" && !empty($_POST['statistiqueModif']) && !empty($_POST['NouvelleValeur'])) {
            try {
                $bdd = new PDO("mysql:host=localhost;dbname=$db_name", $user, $pass);
                $variable = "{$_POST['statistiqueModif']} = {$_POST['NouvelleValeur']} WHERE id = {$_POST['MinMaxId']}";
                $sql = "UPDATE `pokedex` SET {$variable}";

                $rep = $bdd->prepare($sql);
                $rep->execute();


                $sql2 = "SELECT * FROM `pokedex` WHERE id = {$_POST['MinMaxId']}";
                $reponse2 = $bdd->prepare($sql2);

                if (is_object($reponse2)) {
                    $reponse2->execute();
                    $tmp = $reponse2->fetchAll();
                    foreach ($tmp as $ligne) {
                        $tmp = new Pokemon($ligne['id'], $ligne['nom'], $ligne['types0nom'], $ligne['types0couleur'], $ligne['types1nom'], $ligne['types1couleur'], $ligne['baseHP'], $ligne['baseAttack'], $ligne['baseDefense'], $ligne['baseSpAttack'], $ligne['baseSpDefense'], $ligne['baseSpeed'], $ligne['description'], $ligne['image']);
                        echo $tmp->printHTML();
                    }
                }

            } catch (PDOExeption $err) {
                echo "Erreur : " . $err->getMessage() . "<br />";
                die();
            }
        }
        ?>
    </div>
    <div class="pan_left">
        <div>
            <p class="cadre" id="cadre">
                Prénom : Vincent </br>
                Nom : DIRIBARNE </br>
                numéro étudiant : i202597</br>
                <script>
                    const paragraph = document.getElementById("cadre");
                    const text = document.createTextNode("Groupe : 21A");
                    paragraph.appendChild(text);
                </script>
            </p>
        </div>
        <div>
            <form method="post" class=cadre>
                Rechercher :<br>
                Type 0 : <select name="type0">
                    <option value="EMPTY">---</option>
                    <option value="Combat">Combat</option>
                    <option value="Dragon">Dragon</option>
                    <option value="Eau">Eau</option>
                    <option value="Electrique">Electrique</option>
                    <option value="Fée">Fée</option>
                    <option value="Feu">Feu</option>
                    <option value="Glace">Glace</option>
                    <option value="Insecte">Insecte</option>
                    <option value="Normal">Normal</option>
                    <option value="Plante">Plante</option>
                    <option value="Poison">Poison</option>
                    <option value="Psy">Psy</option>
                    <option value="Roche">Roche</option>
                    <option value="Sol">Sol</option>
                    <option value="Spectre">Spectre</option>
                </select>
                Type 1 : <select name="type1">
                    <option value="EMPTY">---</option>
                    <option value="Acier">Acier</option>
                    <option value="Combat">Combat</option>
                    <option value="Eau">Eau</option>
                    <option value="Fée">Fée</option>
                    <option value="Glace">Glace</option>
                    <option value="Plante">Plante</option>
                    <option value="Poison">Poison</option>
                    <option value="Psy">Psy</option>
                    <option value="Roche">Roche</option>
                    <option value="Sol">Sol</option>
                    <option value="Vol">Vol</option>
                </select><br>
                Condition : <select name="condition">
                    <option value="EMPTY">---</option>
                    <option value="id">ID</option>
                    <option value="baseHP">HP</option>
                    <option value="baseAttack">ATQ</option>
                    <option value="baseDefense">DEF</option>
                    <option value="baseSpAttack">SP_ATQ</option>
                    <option value="baseSpDefense">SP_DEF</option>
                    <option value="baseSpeed">SPEED</option>
                </select>
                <select name="operator">
                    <option value="EMPTY">---</option>
                    <option value=" = ">=</option>
                    <option value=" > ">></option>
                    <option value=" >= ">>=</option>
                    <option value=" < "><</option>
                    <option value=" <= "><=</option>
                </select>
                <input type="number" name="MinMaxValue" min="0" max="300"><br>
                Trier par : <select name="trier">
                    <option value="EMPTY">---</option>
                    <option value="id">ID</option>
                    <option value="baseHP">HP</option>
                    <option value="baseAttack">ATQ</option>
                    <option value="baseDefense">DEF</option>
                    <option value="baseSpAttack">SP_ATQ</option>
                    <option value="baseSpDefense">SP_DEF</option>
                    <option value="baseSpeed">SPEED</option>
                </select></br>
                <input type="radio" id="croissant" name="groupe" value="ASC" checked>
                <label for="croissant">Croissant</label>
                <input type="radio" id="decroissant" name="groupe" value="DESC">
                <label for="decroissant">Décroissant</label></br>

                <input class="btn" type="submit" name="tri" value="Afficher les résultats">
            </form>

            <form method="post" class=cadre>
                Modifier une stat : <br>
                Id du Pokemon :
                <input name="MinMaxId" type="number" min="0" max="300"> <br>
                Stats : <select name="statistiqueModif">
                    <option value="EMPTY">---</option>
                    <option value="id">ID</option>
                    <option value="baseHP">HP</option>
                    <option value="baseAttack">ATQ</option>
                    <option value="baseDefense">DEF</option>
                    <option value="baseSpAttack">SP_ATQ</option>
                    <option value="baseSpDefense">SP_DEF</option>
                    <option value="baseSpeed">SPEED</option>
                </select> <br>
                Nouvelle Valeur :
                <input name="NouvelleValeur" type="number" min="0" max="300"><br>
                <input class="btn" type="submit" name="modifier" value="Modifier">
            </form>
        </div>
    </div>
    <div class="pan_center"></div>
</div>
</body>
</html>