public class SimulateurDeCanards {

    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        simulateur.simuler();
    }

    private void simuler() {
        Cancaneur mandarin = new Mandarin();
        Cancaneur appelant = new Appelant();
        Cancaneur canardEnPlastique = new CanardEnPlastique();
        Cancaneur canardOie = new CompteurDeCouacs(new AdaptateurDOie(new Oie()));
        Cancaneur colvert = new CompteurDeCouacs(new Colvert());

        System.out.println("\nSimilateur de canards");
        simuler(colvert);
        simuler(colvert);
        simuler(colvert);
        simuler(colvert);
        simuler(canardOie);
        simuler(canardOie);
        simuler(canardOie);
        System.out.println("Nous avons compté " + CompteurDeCouacs.getNombreDeCouacs()+ " couac(s)");

        simuler(mandarin);
        simuler(appelant);
        simuler(canardEnPlastique);
    }



    public void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}
