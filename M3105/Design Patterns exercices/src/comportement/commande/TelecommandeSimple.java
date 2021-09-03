package comportement.commande;

public class TelecommandeSimple {
	Commande emplacement;

	public TelecommandeSimple() {
	}

	public void setCommande(Commande commande) {
		emplacement = commande;
	}

	public void boutonPresse() {
		emplacement.executer();
	}
}
