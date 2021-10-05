#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

int pidSuivant;

void pidErreur(int pid) {
    if (pid == -1)
    {
        printf("Problème à la création d'un processus");
    }
}

int main()
{
    int pid;
    char pidPere[10], pidIUT[10], pidLaval[10];

    printf("Début du père");
    sprintf(pidPere, "%d", getpid());

    //Fils 1
    pid = fork();
    pidErreur(pid);

    if (pid == 0)
    {
        execl("./fils", "filsLaval", "Laval\n", pidPere, NULL);
        sprintf(pidLaval, "%d", pid);
    }

    //Fils 2
    pid = fork();
    pidErreur(pid);
    if (pid == 0)
    {
        execl("./fils", "filsIUT", "IUT de", pidLaval, NULL);
        sprintf(pidIUT, "%d", pid);
    }

    //Fils 3
    pid = fork();
    pidErreur(pid);
    if (pid == 0)
    {
        execl("./fils", "filsLaval", "Dpt. Info", pidIUT, NULL);
        pidSuivant = pid;
    }

    printf("Fin du père");
}