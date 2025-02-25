#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *imprimirMensaje(void *mensaje) {
    printf("%s\n", (char *)mensaje);
    return NULL;
}

int main() {
    pthread_t hilo1, hilo2;
    char *mensaje1 = "Hola desde el hilo 1";
    char *mensaje2 = "Hola desde el hilo 2";

    pthread_create(&hilo1, NULL, imprimirMensaje, (void *)mensaje1);
    pthread_create(&hilo2, NULL, imprimirMensaje, (void *)mensaje2);

    pthread_join(hilo1, NULL);
    pthread_join(hilo2, NULL);

    return 0;
}