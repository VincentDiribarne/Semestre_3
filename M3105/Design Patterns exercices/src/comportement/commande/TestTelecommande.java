package comportement.commande;

public class TestTelecommande {

	public static void main(String[] args) {
		TelecommandeSimple telecommande = new TelecommandeSimple();
		Lampe lampe = new Lampe();
		CommandeAllumerLampe lampeAllumee = new CommandeAllumerLampe(lampe);
		telecommande.setCommande(lampeAllumee);
		telecommande.boutonPresse();
	}
}
