#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int contador = 0;
pthread_mutex_t mutex;

void *incrementarContador(void *arg) {
    pthread_mutex_lock(&mutex);
    contador++;
    printf("Contador: %d\n", contador);
    pthread_mutex_unlock(&mutex);
    return NULL;
}

int main() {
    pthread_t hilos[10];
    pthread_mutex_init(&mutex, NULL);

    for (int i = 0; i < 10; i++) {
        pthread_create(&hilos[i], NULL, incrementarContador, NULL);
    }

    for (int i = 0; i < 10; i++) {
        pthread_join(hilos[i], NULL);
    }

    pthread_mutex_destroy(&mutex);
    return 0;
}