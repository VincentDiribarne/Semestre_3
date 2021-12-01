// initRessources.c

// --- Fichiers inclus ---
#include <stdio.h>

#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include "ipc.h"
#include "types.h"

int debug = 0;

int main() {
    // Création des sémaphores
    printf("Création SemP\t\t");
    if (createSem(CleSemP, MAX_ELTS) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    printf("Création SemC\t\t");
    if (createSem(CleSemC, 0) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    printf("Création MutexP\t\t");
    if (createSem(CleMutexP, 1) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    printf("Création MutexC\t\t");
    if (createSem(CleMutexC, 1) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    printf("Création SemSuper\t");
    if (createSem(CleSemSuper, 0) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    //Création du segment de mémoire partagée
    printf("Création Shm\t\t");
    if (createShm(CleShm, sizeof(shm_t)) != -1)
        printf("OK\n");
    else
       printf("NOK\n");
    
    // Création d'un tube nommé
    printf("Création du tube\t");
    if (mkfifo("/tmp/tube", 0600) == 0)
        printf("OK\n");
    else
       printf("NOK\n");

    return 0;
}
