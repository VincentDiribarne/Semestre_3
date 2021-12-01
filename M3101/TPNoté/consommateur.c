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
    
    int semP = getSemId(CleSemP);     // sémaphore producteur
    int semC = getSemId(CleSemC);     // sémaphore consommateur
    int mutexC = getSemId(CleMutexC);   // mutex consommateur
 
    int i;        // numéro de consommateur
    int val;      // valeur consommée
    int n = 0;    // nombre de valeurs consommées
    int np; //numero du producteur
    setbuf(stdout, NULL);

    // A COMPLETER
    printf("Cons n° %s\n",argv[1]);
    i = atoi(argv[1]); //conversion du tring en int
    tube = open("/tmp/tube", O_RDONLY); //ouverture du tube en lecture
    if (tube < 0) { 
        printf("ERREUR ouverture du tube\n");//message d'erreur à l'ouverture du tube
        return EXIT_FAILURE;
    }

    for(n; n<10;n++){
        P(n);
        P(mutexC);
        read(tube, &np, sizeof(int)); //lecture du tube
        read(tube, &val, sizeof(int));
        V(mutexC); 
        V(MAX_ELTS);
        printf("Cons n°%d, Prod n° %d, %d\n", i, np, val);//affichage du consommateur, du producteur et de la valeur passé en paramètre par le producteur
    }
    close(tube); //fermeture du tube

    return 0;
}

