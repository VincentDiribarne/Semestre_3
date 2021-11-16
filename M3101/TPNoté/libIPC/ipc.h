// ipc.h
// ----------------------
// Gestion des semaphores
// ----------------------

// --- Fichiers inclus ---

#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/errno.h>

// sous Linux
typedef union {
	int                val;
	struct semid_ds    *buffer;
	unsigned short int *table;
} semun;

// --- Indicateur de debuggage
// val : 0 off, 1 on
extern int debug;


// --- Accès à un sémaphore déjà existant ---
// key      : clé externe du sémaphore
// retourne : numéro interne du sémaphore, -1 sinon
int getSemId(key_t key);


// --- Création d'un nouveau sémaphore ---
// (sans effet si le sémaphore exite déjà)
// key      : clé externe du sémaphore
// valInit  : valeur initiale du sémaphore
// retourne : numéro interne du sémaphore, -1 sinon
int createSem(key_t key, int valInit);

// --- Destruction d'un sémaphore ---
// semid    : clé interne du sémaphore
// retourne : 0 si OK, -1 sinon
int deleteSem(int semid);

// --- Opération P ---
// semid    : clé interne du sémaphore
// retourne : 0 si OK, -1 sinon
int P(int semid);

// --- Opération V ---
// semid    : clé interne du sémaphore
// retourne : 0 si OK, -1 sinon
int V(int semid);

// --- Accès à un segment mémoire partagé ---
// key      : clé externe du segment mémoire
// retourne : numéro interne du segment mémoire, -1 sinon
int getShmId(key_t key);

// --- Création d'un segment mémoire partagé ---
// key      : clé externe du segment mémoire
// size     : taille de la zone mémoire
// retourne : numéro interne du segment mémoire, -1 sinon
int createShm(key_t key, int size);

// --- Destruction d'un segment mémoire partagé ---
// shmid    : clé interne du segment mémoire
// retourne : 0 si OK, -1 sinon
int deleteShm(int shmid);

// --- Accès au segment de mémoire partagé
// shmid    : clé interne du segment mémoire
// retourne : adresse du segment mémoire, NULL sinon
void *attachShm(int shmid);

// Ecriture du compteur partagé
// mem      : adresse du segment mémoire, NULL sinon
void detachShm(void *mem);
