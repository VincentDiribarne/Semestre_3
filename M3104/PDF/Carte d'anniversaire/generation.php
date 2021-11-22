<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Genere tes cartes d'anniversaire</title>
</head>
<body>
<div>
    <form action="" , method="post" enctype="multipart/form-data">
        <label for="name"> <b> Nom : </b> (requis) </br></label>
        <input type="text" id="name" name="name" required placeholder="Vincent DIRIBARNE" size="30" maxlength="30"></br>

        <label for="birthday"><b> Date de l'anniversaire : </b> (requis) </br></label>
        <input type="date" name="birthday" id="birthday" required></br>

        <label for="slogan"><b> Slogan : </b> (requis) </br></label>
        <input type="text" id="slogan" name="slogan" required></br>

        <label for="image"><b> Image : </b> (requis) </br></label>
        <input type="file" id="image" name="image" required></br>

        <label for="imageDeFond"><b> Image de fond : </b> (requis) </br></label>
        <input type="file" id="imageDeFond" name="imageDeFond" required></br>
        </br>
        <input type="submit" value="Génerer ma carte"/>
        <?php
        require_once('../fpdf/fpdf.php');
        require_once('carteAnniv.php');

        $nom = $_POST['name'];
        $date = $_POST['birthday'];
        $slogan = $_POST['slogan'];
        echo $_FILES['image']['name'];

        /*echo count($files);

for ($i = 0; $i < count($files); $i++) {
echo $files[i];
}*/

        //$carteAnniv = new carteAnniv($date, $nom, $files[0], $files[1], $slogan);

        //echo $carteAnniv->printHTML();


        /*
        $pdf = new FPDF();
        $pdf->AddPage();
        $pdf->SetFont('Arial', 'B', 16);
        $pdf->Image("");
        $pdf->Cell(40, 10, 'Hello World !');
        //Header("Content-type: application/pdf");
        $pdf->Output();*/
        ?>
    </form>
</div>
</body>
</html>







