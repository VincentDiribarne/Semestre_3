#include <stdio.h>

int main(int argc, char *argv[])
{
    int pidSuivant, i;

    if (argc != 3)
    {
        printf("Argument incorrect\n");
        exit(-1);
    }

    sscanf(argv[2], "%d", &pidSuivant);
    for (i = 1; i <= 10; i++)
    {
        printf("%s\n", argv[1]);
    }
}