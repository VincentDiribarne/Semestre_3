function addItems() {
    var ul = document.getElementById("list");
    var saisie = document.getElementById('TodoList');
    var li = document.createElement("li");

    const reponse = saisie.value;
    if (reponse === "") {
        alert('Mettre un champ dans le formulaire !')
        return
    } else {
        saisie.value = ""
        li.appendChild(document.createTextNode(reponse));
        ul.appendChild(li);
    }
}