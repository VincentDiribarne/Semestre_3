// deleteRessources.c

// --- Fichiers inclus ---
#include <stdio.h>
#include <unistd.h>

#include "ipc.h"

#define CleShm 1 // segment de mémoire partagée

int debug = 0;

int main() {
    //Destruction du segment de mémoire partagée
    printf("Destruction Shm\t\t");
    if (deleteShm(getShmId(CleShm)) != -1)
        printf("OK\n");
    else
       printf("NOK\n");
    
    // Suppression du tube
    printf("Suppression du tube\t");
    if (unlink("tubeExemple") == 0)
        printf("OK\n");
    else
       printf("NOK\n");

    return 0;
}

