// writeTube.c

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
    
    if (argc != 2) {
        printf("Argument absent\n");
        return EXIT_FAILURE;
    }
    val = atoi(argv[1]);
    
    // Ouverture du tube en écriture
    tube = open("tubeExemple", O_WRONLY);
    if (tube < 0) {
        printf("ERREUR ouverture du tube\n");
        return EXIT_FAILURE;
    }

    // Ecriture dans le tube
    write(tube, &val, sizeof(int));
 
    // Fermeture du tube
    close(tube);
    
    return 0;
 }
