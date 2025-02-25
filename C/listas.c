#include <stdio.h>
#include <stdlib.h>

struct Nodo {
    int dato;
    struct Nodo *siguiente;
};

void insertar(struct Nodo **cabeza, int nuevoDato) {
    struct Nodo *nuevoNodo = (struct Nodo *)malloc(sizeof(struct Nodo));
    nuevoNodo->dato = nuevoDato;
    nuevoNodo->siguiente = *cabeza;
    *cabeza = nuevoNodo;
}

void imprimirLista(struct Nodo *nodo) {
    while (nodo != NULL) {
        printf("%d -> ", nodo->dato);
        nodo = nodo->siguiente;
    }
    printf("NULL\n");
}

int main() {
    struct Nodo *cabeza = NULL;

    insertar(&cabeza, 1);
    insertar(&cabeza, 2);
    insertar(&cabeza, 3);

    imprimirLista(cabeza);
    return 0;
}
