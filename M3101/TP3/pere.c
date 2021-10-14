#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

int main()
{
    int pid;
    setbuf(stdout, NULL);

    //Fils 1
    pid = fork();
    switch (pid)
    {
    case -1:
        printf("Problème à la création d'un fils\n");
        exit(-1);
        break;
    case 0:
        execl("./fils", "filsLaval", "Laval\n", "0", NULL);
    }

    //Fils 2
    pid = fork();
    switch (pid)
    {
    case -1:
        printf("Problème à la création d'un fils\n");
        exit(-1);
        break;
    case 0:
        execl("./fils", "filsIUT", "IUT de \n", "3", NULL);
    }

    //Fils 3
    pid = fork();
    switch (pid)
    {
    case -1:
        printf("Problème à la création d'un fils\n");
        exit(-1);
        break;
    case 0:
        execl("./fils", "filsDpt", "Dpt. Info\n", "2", NULL);
    }

    printf("Fin du père");
}
