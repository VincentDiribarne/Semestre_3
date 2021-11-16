// readTube.c

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

int debug = 0;

int main(int argc, char *argv[]) {
    int tube; // tube (n° de descripteur)
    int val;
    
    // Ouverture du tube en lecture
    tube = open("tubeExemple", O_RDONLY);
    if (tube < 0) {
        printf("ERREUR ouverture du tube\n");
        return EXIT_FAILURE;
    }

    // Lecture dans le tube
    read(tube, &val, sizeof(int));
    
    printf("Entier : %d\n", val);
    
    // Fermeture du tube
    close(tube);
    
    return 0;
 }
