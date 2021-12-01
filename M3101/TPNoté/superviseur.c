// superviseur.c

#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include "ipc.h"
#include "types.h"

#define clearScreen() printf("\033[H\033[J") // macro pour effacer l'écran

int debug = 0;

int main() {

    if (!fork()) //exécution de initRessources
    {
        execl("./initRessources", "initRessources", NULL, NULL);
    }
    while (wait(NULL) != -1);
    int   semSuper = getSemId(CleSemSuper);    // sémaphore superviseur

    int   pidProd;     // pid du créateur de producteurs
    int   pidCons;     // pid du créateur de consommateurs;
    shm_t *shm = (shm_t *)attachShm(getShmId(CleShm)); // segment de mémoire partagée

    int   nbProd = 0;  // nombre de producteurs créés
    int   nbCons = 0;  // nombre de consommateurs créés
    setbuf(stdout, NULL);
    
    
    // A COMPLETER (question 2.3)
    // Attente de démarrage des processus mkProd et mkCons
     printf("Attente d'un Producteur\n");
    P(semSuper);
   
    printf("Attente d'un Consommateur\n");
    P(semSuper);
    
   
    // A COMPLETER (question 2.2)
    // Obtention des pids des processus
    pidProd = shm->pidProd;
    pidCons = shm->pidCons;
    
    // détachement du segment de mémoire
    // A COMPLETER
    detachShm(shm);

    while (1) {
        int cmd; // choix du menu affiché
        
        clearScreen();
        //menu qui permet à l'utilisateur de créer des producteurs et des consommateurs
        printf("1 - Ajouter Producteur (%d)\n", nbProd);
        printf("2 - Ajouter Consommateur (%d)\n", nbCons);
        printf("0 - Quitter\n");
        printf("votre choix ?\n");
        scanf("%d", &cmd);
        if (cmd == 1)
        {
             nbProd++;
            kill(pidProd, SIGUSR1);
        }
        if (cmd == 2)
        {
            nbCons++;
            kill(pidCons, SIGUSR1);
        }
        if (cmd == 0)
        {
            //fin de mkcons et mkprod
            kill(pidProd, SIGINT);
            kill(pidCons, SIGINT);
            if (!fork())
            {
                execl("./deleteRessources", "deleteRessources", NULL, NULL);//exécution de deleteRessources
            }
            while (wait(NULL) != -1);
            printf("Fin Superviseur\n");
            P(semSuper);
            P(semSuper);
            exit(-1);
        }
    }
    
    return 0;
}

