package OptimiserChaineProd.optimisateur;

import OptimiserChaineProd.atelier.Atelier;

import java.util.ArrayList;
import java.util.LinkedList;

public class OptimisateurAtelierImpl implements OptimisateurAtelier {

    @Override
    public ResultatOptimisation optimiserAtelier(Atelier atelier) {
        //Temps optimaux à l'indice 0 et 1
        long tempsMinimalC0 = atelier.getChaine(0).getTempsEntree() + atelier.getChaine(0).getPoste(0).getTempsTraitement();
        long tempsMinimalC1 = atelier.getChaine(1).getTempsEntree() + atelier.getChaine(1).getPoste(1).getTempsTraitement();
        int[][] tab = new int[2][atelier.getLongueurChaines() - 1];

        for (int i = 1; i < atelier.getLongueurChaines(); i++) {
            long nouveauTmpMinimalC0;

            if (tempsMinimalC0 < tempsMinimalC1 + atelier.getTempsChangement(1, 0, i - 1)) {
                nouveauTmpMinimalC0 = tempsMinimalC0 + atelier.getChaine(0).getPoste(i).getTempsTraitement();
                tab[0][i - 1] = 0;
            } else {
                nouveauTmpMinimalC0 = tempsMinimalC1 + atelier.getChaine(0).getPoste(i).getTempsTraitement();
                tab[0][i - 1] = 1;
            }

            if (tempsMinimalC1 < tempsMinimalC0 + atelier.getTempsChangement(0, 1, i - 1)) {
                tempsMinimalC1 = tempsMinimalC1 + atelier.getChaine(1).getPoste(i).getTempsTraitement();
                tab[1][i - 1] = 1;
            } else {
                tempsMinimalC1 = tempsMinimalC0 + atelier.getChaine(1).getPoste(i).getTempsTraitement();
                tab[1][i - 1] = 0;
            }

            tempsMinimalC0 = nouveauTmpMinimalC0;
        }

        int idxChaine;
        long tempsMinAtelier;

        if (tempsMinimalC0 + atelier.getChaine(0).getTempsSortie() < tempsMinimalC1 + atelier.getChaine(1).getTempsSortie()) {
            idxChaine = 0;
            tempsMinAtelier = tempsMinimalC0 + atelier.getChaine(0).getTempsSortie();
        } else {
            idxChaine = 1;
            tempsMinAtelier = tempsMinimalC1 + atelier.getChaine(1).getTempsSortie();
        }

        LinkedList<Integer> idxCheminOpti = new LinkedList<>();
        idxCheminOpti.addFirst(idxChaine);

        for (int j = atelier.getLongueurChaines() -2; j >=0; j--) {
            idxChaine = tab[idxChaine][j];
            idxCheminOpti.addFirst(idxChaine);
        }

        return new ResultatOptimisation(idxCheminOpti, tempsMinAtelier);
    }
}
