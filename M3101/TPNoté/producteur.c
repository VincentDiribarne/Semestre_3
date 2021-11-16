// producteur.c

#include <stdio.h>
#include <unistd.h>
#include <time.h>

#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include "ipc.h"
#include "types.h"

int debug = 0;

int main(int argc, char *argv[]) {
    int tube;     // ouvert en écriture
    
    int semP;     // sémaphore producteur
    int semC;     // sémaphore consommateur
    int mutexP;   // mutex producteur
 
    int i;        // numéro de producteur
    int val;      // valeur produite
    int n = 0;    // nombre de valeurs produites
    
    // A COMPLETER

    return 0;
}
