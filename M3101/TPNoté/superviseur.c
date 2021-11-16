// superviseur.c

#include <stdio.h>
#include <unistd.h>
#include <signal.h>

#include "ipc.h"
#include "types.h"

#define clearScreen() printf("\033[H\033[J") // macro pour effacer l'écran

int debug = 0;

int main() {
    int   semSuper;    // sémaphore superviseur

    int   pidProd;     // pid du créateur de producteurs
    int   pidCons;     // pid du créateur de consommateurs;
    shm_t *shm = NULL; // segment de mémoire partagée

    int   nbProd = 0;  // nombre de producteurs créés
    int   nbCons = 0;  // nombre de consommateurs créés

    // A COMPLETER (question 7)

    // fin (question 7)
    
    // Obtention du numéro interne du sémaphore
    // A COMPLETER;
    
    // Obtention du segment de mémoire partagée
    // A COMPLETER
    

    // A COMPLETER (question 2.3)
    // Attente de démarrage des processus mkProd et mkCons
    
    // A COMPLETER (question 2.2)
    // Obtention des pids des processus

    // fin (question 2.2)
    
    // détachement du segment de mémoire
    // A COMPLETER

    while (1) {
        int cmd; // choix du menu affiché
        
        clearScreen();
        // A COMPLETER
        
    }
    
    // A COMPLETER (question 6)
    // Attente de terminaison des processus mkProd et mkCons
    
    // A COMPLETER (question 7)

    printf("Fin\n");
    
    return 0;
}

