// writeShm.c

#include <stdio.h>
#include <stdlib.h>

#include "ipc.h"

#define CleShm 1 // segment de mémoire partagée

int debug = 0;

int main(int argc, char *argv[]) {
    int val;
    
    if (argc != 2) {
        printf("Argument absent\n");
        return EXIT_FAILURE;
    }
    val = atoi(argv[1]);
    
    int shmId = getShmId(CleShm); // numéro interne de shm
    if (shmId == -1) {
        printf("Segment mémoire inexistant\n");
        return EXIT_FAILURE;
    }
    
    // Obtention du segment de mémoire partagée
    int *shm = (int *) attachShm(shmId);

    //printf("Entier ? ");
    //scanf("%d", shm);
    *shm = atoi(argv[1]);
    
    // Détachement du segment de mémoire
    detachShm(shm);
    
    return 0;
}
