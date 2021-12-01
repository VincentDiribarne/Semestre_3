// sem.c
// ----------------------
// Gestion des semaphores
// ----------------------

// --- Fichiers inclus ---

#include <stdio.h>
#include <stdlib.h>

#include <sys/types.h>
#include <sys/sem.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/errno.h>

#include "ipc.h"

int getSemId(key_t key) {
    int resul = semget(key, 0, 0);
    
    if (resul == -1)
        debug && printf("Sémaphore inexistant\n");
    else
        debug && printf("Accès au sémaphore\n");
    
    return resul;
}

int createSem(key_t key, int valInit) {
    //union semun u;
    semun u; // sous Linux (cf sem.h)
    
    int semid = getSemId(key);
    
    if (semid == -1) {
        semid = semget(key, 1, IPC_CREAT | IPC_EXCL | 0600);
        debug && printf("Création du sémaphore");
        if (semid == -1) debug && printf(" impossible\n");
        else {
            debug && printf("\n");
            u.val = valInit;
            debug && printf("Initialisation du sémaphore");
            if (semctl(semid, 0, SETVAL, u) == -1) {
                debug && printf(" impossible (errno = %d)", errno);
                deleteSem(semid);
                semid = -1;
            }
            debug && printf("\n");
        }
    }
    
    return semid;
}

int deleteSem(int semid) {
    //union semun u;
    semun u; // sous Linux (cf sem.h)
    
    int resul = semctl(semid, 0, IPC_RMID, u);
    
    debug && printf("Destruction du sémaphore");
    if (resul == -1) debug && printf(" impossible (errno = %d)", errno);
    debug && printf("\n");
    
    return resul;
}

int P(int semid) {
    struct sembuf buffer;
    int    resul;
    
    buffer.sem_num	=  0;
    buffer.sem_op	= -1;
    buffer.sem_flg	=  0;
    debug && printf("Opération P");
    resul = semop(semid, &buffer, 1);
    if (resul == -1) debug && printf(" impossible (errno = %d)", errno);
    debug && printf("\n");
    
    return resul;
}

int V(int semid) {
    struct sembuf buffer;
    int    resul;
    
    buffer.sem_num	= 0;
    buffer.sem_op	= 1;
    buffer.sem_flg	= 0;
    debug &&  printf("Opération V");
    resul = semop(semid, &buffer, 1);
    if (resul == -1) debug && printf(" impossible (errno = %d)", errno);
    debug && printf("\n");
    
    return resul;
}

int getShmId(key_t key) {
    int resul = shmget(key, 0, 0);
    
    if (resul == -1)
        debug && printf("Segment mémoire inexistant\n");
    else
        debug && printf("Acces au segment mémoire\n");
    
    return resul;
}

int createShm(key_t key, int size) {
    int shmid = getShmId(key);
    
    if (shmid == -1) {
        shmid = shmget(key, size, IPC_CREAT | IPC_EXCL | 0600);
        debug && printf("Création du segment mémoire");
        if (shmid == -1) debug && printf(" impossible");
        debug && printf("\n");
}
    
    return shmid;
}

int deleteShm(int shmid) {
    int resul = shmctl(shmid, IPC_RMID, NULL);
    
    debug && printf("Destruction du segment mémoire");
    if (resul == -1) debug && printf(" impossible (errno = %d)", errno);
    debug && printf("\n");
    
    return resul;
}

void *attachShm(int shmid) {
    debug && printf("Attatchement du segment de mémoire\n");
	return shmat(shmid, NULL, 0);
}

void detachShm(void *mem) {
    debug && printf("Détachement du segment de mémoire\n");
	shmdt(mem);
}
