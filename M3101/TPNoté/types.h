#define CleSemP        1 // sémaphore producteur
#define CleSemC        2 // sémaphore consommateur
#define CleMutexP      3 // mutex producteur
#define CleMutexC      4 // mutex consommateur
#define CleSemSuper    5 // sémaphore superviseur

#define CleShm         1 // segment de mémoire partagée

#define MAX_ELTS      10 // nombre max de valeurs produites sans être consommées
#define MAX_PROCESSUS 10 // nombre max de produteurs et de consommateurs

typedef enum {prod, cons} process_t;

typedef struct {
    int pidProd; // pid créateur producteur
    int pidCons; // pid créateur consommateur
} shm_t;
