// deleteRessources.c

// --- Fichiers inclus ---
#include <stdio.h>
#include <unistd.h>

#include "ipc.h"
#include "types.h"

int debug = 0;

int main() {
    // Destruction des sémaphores
    printf("Destruction SemP\t");
    if (deleteSem(getSemId(CleSemP)) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    printf("Destruction SemC\t");
    if (deleteSem(getSemId(CleSemC)) != -1)
        printf("OK\n");
    else
        printf("NOK\n");
    
    printf("Destruction MutexP\t");
    if (deleteSem(getSemId(CleMutexP)) != -1)
        printf("OK\n");
    else
        printf("NOK\n");

    printf("Destruction MutexC\t");
    if (deleteSem(getSemId(CleMutexC)) != -1)
        printf("OK\n");
    else
        printf("NOK\n");

    printf("Destruction SemSuper\t");
    if (deleteSem(getSemId(CleSemSuper)) != -1)
        printf("OK\n");
    else
        printf("NOK\n");

    //Destruction du segment de mémoire partagée
    printf("Destruction Shm\t\t");
    if (deleteShm(getShmId(CleShm)) != -1)
        printf("OK\n");
    else
       printf("NOK\n");
    
    // Suppression du tube
    printf("Suppression du tube\t");
    if (unlink("/tmp/tube") == 0)
        printf("OK\n");
    else
       printf("NOK\n");

    return 0;
}

