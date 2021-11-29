import Cancaneur.Cancaneur;
import DesignDecorateur.CompteurDeCouacs;
import DesignFabrique.FabriqueDeCanard;
import DesignFabrique.FabriqueDeCanardsAbstraite;
import DesignFabrique.FabriqueDeComptage;

public class SimulateurDeCanards {

    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        FabriqueDeCanardsAbstraite fabriqueDeCanard = new FabriqueDeCanard();
        simulateur.simuler(fabriqueDeCanard);
    }

    private void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
        Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
        Cancaneur colvert = fabriqueDeCanards.creerColvert();

        System.out.println("\nSimilateur de canards");
        simuler(colvert);
        simuler(mandarin);
        System.out.println("Nous avons compté " + CompteurDeCouacs.getNombreDeCouacs()+ " couac(s)");
    }



    public void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}
