package exam;

public class Test {

  public static void main(String[] args) {

    ObjetDeValeur collier = new ObjetDeValeur("Collier de perles", 20);
    ObjetDeValeur radis = new ObjetDeValeur("Radis du jardin du roi"); // valeur
                                                                       // 0 par
                                                                       // defaut
    radis.recevoirValeurSupp(3);
    ObjetDeValeur robe = new ObjetDeValeur("Robe portée par la reine", 5);

    Stockage etui = new Stockage("Etui à bijoux");
    etui.ajouterEquipement(collier);

    Stockage sac = new Stockage("Sac en POO de mendiant");
    sac.ajouterEquipement(radis);

    Stockage coffre = new Stockage("Coffre du chateau");
    coffre.ajouterEquipement(etui);
    coffre.ajouterEquipement(sac);
    coffre.recevoirValeurSupp(5);
    coffre.ajouterEquipement(robe);
    sac.ajouterEquipement(new ObjetDeValeur("cle", 1));

    coffre.affiche();
    coffre.afficheValeur();
    coffre.afficheObjetsDeValeurMin(5);
  }

}
