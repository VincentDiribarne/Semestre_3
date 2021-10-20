package OptimiserChaineProd.optimisateur;

import OptimiserChaineProd.atelier.Atelier;
import OptimiserChaineProd.atelier.Poste;
import java.util.ArrayList;
import java.util.List;

public class OptimisateurAtelierImpl implements OptimisateurAtelier {

    @Override
    public ResultatOptimisation optimiserAtelier(Atelier atelier) {
        //Temps optimaux à l'indice 0 et 1
        long tempsMinimalC0 = atelier.getChaine(0).getTempsEntree() + atelier.getChaine(0).getPoste(0).getTempsTraitement();
        long tempsMinimalC1 = atelier.getChaine(1).getTempsEntree() + atelier.getChaine(1).getPoste(1).getTempsTraitement();

        List<Poste> listPoste = new ArrayList<>();

        for (int i = 1; i < atelier.getLongueurChaines(); i++) {
            //Calcul temps minimal C0
            long nouveauMeilleurTempsChaine0 = Math.min(tempsMinimalC0,
                    tempsMinimalC1 + atelier.getTempsChangement(1, 0, i - 1))
                    + atelier.getChaine(0).getPoste(i).getTempsTraitement();

            //Calcul temps minimal C1
            tempsMinimalC1 = Math.min(tempsMinimalC1,
                    tempsMinimalC0 + atelier.getTempsChangement(0, 1, i - 1))
                    + atelier.getChaine(1).getPoste(i).getTempsTraitement();

            //Attribution temps minimal C0
            tempsMinimalC0 = nouveauMeilleurTempsChaine0;
        }

        //Cherche le meilleur temps
        long tempsMinimalAtelier = Math.min(
                tempsMinimalC0 + atelier.getChaine(0).getTempsSortie(),
                tempsMinimalC1 + atelier.getChaine(1).getTempsSortie());


        return new ResultatOptimisation(new ArrayList<>(), tempsMinimalAtelier);
    }
}
