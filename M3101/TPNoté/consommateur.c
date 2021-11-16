// producteur.c

#include <stdio.h>
#include <unistd.h>

#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include "ipc.h"
#include "types.h"

int debug = 0;

int main(int argc, char *argv[]) {
    int tube;     // ouvert en lecture
    
    int semP;     // sémaphore producteur
    int semC;     // sémaphore consommateur
    int mutexC;   // mutex consommateur
 
    int i;        // numéro de consommateur
    int val;      // valeur consommée
    int n = 0;    // nombre de valeurs consommées
    
    setbuf(stdout, NULL);
    
    // A COMPLETER

    return 0;
}

