<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css" media="screen" type="text/css"/>
</head>
<body>
<div id="container">
    <form action="main.php" method="POST">
        <h1>Connexion</h1>

        <label><b>Nom d'utilisateur</b></label>
        <input id="username" type="text" placeholder="Entrer le nom d'utilisateur" name="username" required>

        <label><b>Mot de passe</b></label>
        <input id="password" type="password" placeholder="Entrer le mot de passe" name="password" required>

        <input type="submit" id='submit' value='LOGIN'>

        <script>
            let username = document.getElementById('username');
            let password = document.getElementById('password');
            <?php
            include_once("db.inc.php");

            if (isset($_POST['username']) && isset($_POST['password'])) {
                try {
                    $bdd = new PDO("mysql:host=localhost;dbname=$db_name", $user, $pass);
                    $usernameUser = $_POST['username'];
                    $sql = "SELECT * FROM `Session` WHERE username='{$usernameUser}'";

                    $rep = $bdd->query($sql);
                    $lig = $rep->fetch();

                    $passwordUser = $_POST['password'];
                    $usernameBDD = $lig['username'];
                    $passwordBDD = $lig['password'];
                } catch (PDOExeption $err) {
                    echo "Erreur : " . $err->getMessage() . "<br />";
                    die();
                }
            }
            ?>

            let usernameUser = <?php
                if (isset($usernameUser)) {
                    echo $usernameUser;
                } else {
                    echo erreur;
                }
                ?>;

            let usernameBDD = <?php
                if (isset($usernameBDD)) {
                    echo $usernameBDD;
                } else {
                    echo erreur;
                }
                ?>;

            let mdpUser = <?php
                if (isset($passwordUser)) {
                    echo $passwordUser;
                } else {
                    echo erreur;
                }
                ?>;

            let mdpBDD = <?php
                if (isset($passwordBDD)) {
                    echo $passwordBDD;
                } else {
                    echo erreur;
                }
                ?>;

            if (usernameUser !== usernameBDD || usernameBDD === 'erreur') {
                changeColor(username);
            }

            if (mdpUser !== mdpBDD || mdpBDD === 'erreur') {
                changeColor(password);
                document.write("Mot de passe incorrect");
            }

            function changeColor(element) {
                element.style.color = '#ff0000';
            }
        </script>

    </form>
</div>
</body>
</html>


