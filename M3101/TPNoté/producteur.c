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
    
    int semP = getSemId(CleSemP);     // sémaphore producteur
    int semC = getSemId(CleSemC);     // sémaphore consommateur
    int mutexP = getSemId(CleMutexP);   // mutex producteur
    int i;        // numéro de producteur
    
    int n = 0;    // nombre de valeurs produites
    
    // A COMPLETER
    i = atoi(argv[1]);
    printf("Prod n° %s\n", argv[1]);
    tube = open("/tmp/tube", O_WRONLY); // ouverture en écriture du tube
    if (tube < 0) {
        printf("ERREUR ouverture du tube\n");//message d'erreur à l'ouverture du tube
        return EXIT_FAILURE;
    }
    for(n; n<10;n++){
        int val = rand()%10 +1;      // création d'une valeur random
        P(MAX_ELTS); 
        P(mutexP);
        write(tube, &i, sizeof(int)); //ecriture dans le tube
        write(tube, &val, sizeof(int));
        V(mutexP);
        V(n);
        sleep(rand()%3 +1); // temps d'attente entre 2 valeurs
        
    }
    close(tube); //fermeture du tube
    
    return 0;
}
