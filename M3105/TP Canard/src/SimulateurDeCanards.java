public class SimulateurDeCanards {

    public static void main(String[] args) {
        SimulateurDeCanards simulateur = new SimulateurDeCanards();
        simulateur.simuler();
    }

    private void simuler() {
        Cancaneur colvert = new Colvert();
        Cancaneur mandarin = new Mandarin();
        Cancaneur appelant = new Appelant();
        Cancaneur canardEnPlastique = new CanardEnPlastique();

        System.out.println("\nSimilateur de canards");
        simuler(colvert);
        simuler(mandarin);
        simuler(appelant);
        simuler(canardEnPlastique);
    }

    public void simuler(Cancaneur canard) {
        canard.cancaner();
    }
}
