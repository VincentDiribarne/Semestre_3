#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

void monTraitement(int numSignal) {
    signal(numSignal, monTraitement);
}

int main(int argc, char *argv[])
{
    int pidSuivant, i;

    if (argc != 3)
    {
        printf("Argument incorrect\n");
        exit(-1);
    }

    setbuf(stdout, NULL);
    sscanf(argv[2], "%d", &pidSuivant);

    signal(SIGUSR1, monTraitement)

    for (i = 1; i <= 10; i++)
    {
        pause();
        printf("%s\n", argv[1]);
        kill(pidSuivant, SIGUSR1);
    }
}