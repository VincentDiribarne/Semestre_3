package OptimiserChaineProd.optimisateur;

import OptimiserChaineProd.atelier.Atelier;

public interface OptimisateurAtelier {

    /**
     * Calcul et retourne le temps minimal et l'enchainement des chaines pour un
     * parcours optimal de l'atelier.
     *
     * @param atelier l'atelier
     * @return le résultat de l'optimisation
     */
    ResultatOptimisation optimiserAtelier(Atelier atelier);
}
