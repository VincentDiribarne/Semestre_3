// readShm.c

#include <stdio.h>

#include "ipc.h"

#define CleShm 1 // segment de mémoire partagée

int debug = 0;

int main(int argc, char *argv[]) {
    int shmId = getShmId(CleShm); // numéro interne de shm
    if (shmId == -1) {
        printf("Segment mémoire inexistant\n");
        return EXIT_FAILURE;
    }
    
    // Obtention du segment de mémoire partagée
    int *shm = (int *) attachShm(shmId);
    
    printf("Entier = %d\n", *shm);
    
    // Détachement du segment de mémoire
    detachShm(shm);
    
    return 0;
}
