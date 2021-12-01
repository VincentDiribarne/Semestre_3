// mkProCons.c

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>

#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include "ipc.h"
#include "types.h"

process_t type;

int debug  = 0;

int stop     = 0; // fin de la boucle principale
int action   = 0; // positionné à 1 sur réception du signal SIGUSR1
                  // pour indiquer qu'un producteur ou consommateur doit être créé

// A COMPLETER
// Prototypes des fonctions
void signal_SIGUSR1(int numSignal) {
	// Etape 1 (cf. sujet)
     printf("\n");
	printf("J'ai reçu le signal %s\n", sys_siglist[numSignal]);
    action = 1;

}
void signal_SIGINT(int numSignal) {
	// Etape 1 (cf. sujet)
    stop = 1;
	exit(-1);
}	

int main(int argc, char *argv[]) {
    int   pid = getpid();
    int   semSuper = getSemId(CleSemSuper);    // sémaphore superviseur
    int   mutexP = getSemId(CleMutexP);      // mutex producteur
    int   mutexC = getSemId(CleMutexC);      // mutex consommateur
    
    shm_t *shm = (shm_t *)attachShm(getShmId(CleShm)); // segment de mémoire partagée

    int   tubeWR;      // ouvert en écriture (mkProd)
    int   tubeRD;      // ouvert en lecture  (mkCons)

    int   nbP = 0;     // nombre de producteurs créés
    int   nbC = 0;     // nombre de consommateurs créés
    
    

    //obtention des arguments passer a l'exécution du processus ./mkProdCons
    setbuf(stdout, NULL);
    if (argc >= 2){
        if (strcmp(argv[1],"prod") == 0)
        {
        printf("Début mkProd");
        shm->pidProd = pid;
        tubeWR = open("/tmp/tube", O_WRONLY);
        if (tubeWR < 0) {
            printf("ERREUR ouverture du tube\n");
            return EXIT_FAILURE;
        }
        V(semSuper);
        }
        if (strcmp(argv[1],"cons") == 0)
        {
        printf("Début mkCons");
        tubeRD = open("/tmp/tube", O_RDONLY);
        if (tubeRD < 0) {
            printf("ERREUR ouverture du tube\n");
            return EXIT_FAILURE;
        }
        shm->pidCons = pid;
        V(semSuper);
        }
    }
    // Interception du signal USR1
    if (signal(SIGUSR1, signal_SIGUSR1)==SIG_ERR) {
		printf("Signal non intercepte\n");
		exit(-1);
	}
     if (signal(SIGINT, signal_SIGINT)==SIG_ERR) {
		printf("Signal non intercepte\n");
		exit(-1);
	}
    

    // détachement du segment de mémoire
    detachShm(shm);
    
    // A COMPLETER (question 1.1)
    // Mise en place des signaux
    signal(SIGUSR1, signal_SIGUSR1);
    signal(SIGINT, signal_SIGINT);
    
    // fin (question 2.3)
    // permet de créer un producteur ou un consommateur en fonction du choix de l'utilisateur
    while (! stop) {
        // A COMPLETER (question 3.1)
        pause();
        if (action)
        {
            
            action = 0;
            char _param[10];
            if (strcmp(argv[1], "prod") == 0)
            {
                
                nbP++;
                sprintf(_param, "%d", nbP);

                if (!fork())
                {
                    execl("./producteur", "producteur", _param, NULL);
                }
            }
            else if (strcmp(argv[1], "cons") == 0)
            {
                 
                nbC++;
                sprintf(_param, "%d", nbC);
                if (!fork())
                {
                    execl("./consommateur", "consommateur", _param, NULL);
                }
            }
        }
        
    }

    V(semSuper);

    return 0;
}
