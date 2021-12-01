package TPNote.Version1.Exception;

public class RendezVousExistant extends java.lang.Exception {
    public RendezVousExistant() {
        super("Le rendez vous existe déjà");
    }

    public RendezVousExistant(String msg) {
        super(msg);
    }
}
