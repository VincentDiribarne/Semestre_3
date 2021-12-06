import Cancaneur.*;
import DesignComposite.Troupe;
import DesignDecorateur.CompteurDeCouacs;
import DesignFabrique.FabriqueDeCanard;
import DesignFabrique.FabriqueDeCanardsAbstraite;
import DesignObserver.Cancanologue;


public class SimulateurDeCanards {

    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        FabriqueDeCanardsAbstraite fabriqueDeCanard = new FabriqueDeCanard();
        simulateur.simuler(fabriqueDeCanard);
    }

    private void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
        Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
        Cancaneur colvert = fabriqueDeCanards.creerColvert();
        Cancanologue leCancanologue = new Cancanologue();
        Cancanologue leCancanologue2 = new Cancanologue();

        colvert.enregistrerObservateur(leCancanologue);
        colvert.enregistrerObservateur(leCancanologue2);

        simuler(colvert);

        /*Cancaneur appelant = new Appelant();
        //Cancaneur colvert = fabriqueDeCanards.creerColvert();

        System.out.println("\nSimilateur de canards");
        simuler(colvert);
        simuler(mandarin);
        System.out.println("Nous avons compté " + CompteurDeCouacs.getNombreDeCouacs()+ " couac(s)");

        Troupe troupeDeCanards = new Troupe();
        troupeDeCanards.add(mandarin);
        troupeDeCanards.add(appelant);

        Troupe troupeDeColvert = new Troupe();
        Cancaneur colvert2 = new Colvert();
        Cancaneur colvert3 = new Colvert();
        troupeDeColvert.add(colvert2);
        troupeDeColvert.add(colvert3);

        troupeDeCanards.add(troupeDeColvert);
        cancanologue.actualiser(colvert2);
        System.out.println("\nSimilateur de canards : Toute la troupe");
        simuler(troupeDeCanards);
        System.out.println("\nSimilateur de canards : Troupe de colvert");
        simuler(troupeDeColvert);*/
    }

    public void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}
