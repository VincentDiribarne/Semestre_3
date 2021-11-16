// mkProCons.c

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>

#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include "ipc.h"
#include "types.h"

process_t type;

int debug  = 0;

int stop     = 0; // fin de la boucle principale
int action   = 0; // positionné à 1 sur réception du signal SIGUSR1
                  // pour indiquer qu'un producteur ou consommateur doit être créé

// A COMPLETER
// Prototypes des fonctions

int main(int argc, char *argv[]) {
    int   pid = getpid();
    int   semSuper;    // sémaphore superviseur
    int   mutexP;      // mutex producteur
    int   mutexC;      // mutex consommateur
    
    shm_t *shm = NULL; // segment de mémoire partagée

    int   tubeWR;      // ouvert en écriture (mkProd)
    int   tubeRD;      // ouvert en lecture  (mkCons)

    int   nbP = 0;     // nombre de producteurs créés
    int   nbC = 0;     // nombre de consommateurs créés
    
    // A COMPLETER (question 1)
    
    // A COMPLETER (question 4.1)
    
    // fin (question 4.1)
    
    // fin (question 1)

    // Obtention des numéros internes des sémaphores
    // A COMPLETER;

    // Obtention du segment de mémoire partagée
    // A COMPLETER;
    
    // A COMPLETER (question 2.1)

    // fin (question 2.1)
    
    // A COMPLETER (question 2.3)

    // fin (question 2.3)
    
    // détachement du segment de mémoire
    // A COMPLETER;

    // fin (question 2.3)
    
    // A COMPLETER (question 1.1)
    // Mise en place des signaux
    
    // fin (question 2.3)
    
    while (! stop) {
        // A COMPLETER (question 1.1)
    }

    // A COMPLETER (question 2.4)
    
    // fin (question 2.4)

    return 0;
}
