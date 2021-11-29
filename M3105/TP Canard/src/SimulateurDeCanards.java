import Cancaneur.*;
import DesignComposite.Troupe;
import DesignDecorateur.CompteurDeCouacs;
import DesignFabrique.FabriqueDeCanard;
import DesignFabrique.FabriqueDeCanardsAbstraite;


public class SimulateurDeCanards {

    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        FabriqueDeCanardsAbstraite fabriqueDeCanard = new FabriqueDeCanard();
        simulateur.simuler(fabriqueDeCanard);
    }

    private void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
        Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
        Cancaneur appelant = new Appelant();
        //Cancaneur colvert = fabriqueDeCanards.creerColvert();

        /*System.out.println("\nSimilateur de canards");
        simuler(colvert);
        simuler(mandarin);
        System.out.println("Nous avons compté " + CompteurDeCouacs.getNombreDeCouacs()+ " couac(s)");*/

        Troupe troupeDeCanards = new Troupe();
        troupeDeCanards.add(mandarin);
        troupeDeCanards.add(appelant);

        Troupe troupeDeColvert = new Troupe();
        Cancaneur colvert2 = new Colvert();
        Cancaneur colvert3 = new Colvert();
        troupeDeColvert.add(colvert2);
        troupeDeColvert.add(colvert3);

        troupeDeCanards.add(troupeDeColvert);
        System.out.println("\nSimilateur de canards : Toute la troupe");
        simuler(troupeDeCanards);
        System.out.println("\nSimilateur de canards : Troupe de colvert");
        simuler(troupeDeColvert);
    }

    public void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}
