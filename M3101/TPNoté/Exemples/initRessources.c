// initRessources.c

// --- Fichiers inclus ---
#include <stdio.h>

#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include "ipc.h"

#define CleShm 1 // segment de mémoire partagée

int debug = 0;

int main() {
    //Création du segment de mémoire partagée
    printf("Création Shm\t\t");
    if (createShm(CleShm, sizeof(int)) != -1)
        printf("OK\n");
    else
       printf("NOK\n");
    
    // Création d'un tube nommé
    printf("Création du tube\t");
int e;
    if ((e = mkfifo("tubeExemple", 0600)) == 0)
        printf("OK\n");
    else
       printf("NOK %d\n", e);

    return 0;
}
