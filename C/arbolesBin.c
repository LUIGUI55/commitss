#include <stdio.h>
#include <stdlib.h>

struct Nodo {
    int dato;
    struct Nodo *izquierda, *derecha;
};

struct Nodo* nuevoNodo(int dato) {
    struct Nodo* nodo = (struct Nodo*)malloc(sizeof(struct Nodo));
    nodo->dato = dato;
    nodo->izquierda = nodo->derecha = NULL;
    return nodo;
}

void preOrden(struct Nodo* nodo) {
    if (nodo == NULL) return;
    printf("%d ", nodo->dato);
    preOrden(nodo->izquierda);
    preOrden(nodo->derecha);
}

int main() {
    struct Nodo *raiz = nuevoNodo(1);
    raiz->izquierda = nuevoNodo(2);
    raiz->derecha = nuevoNodo(3);
    raiz->izquierda->izquierda = nuevoNodo(4);
    raiz->izquierda->derecha = nuevoNodo(5);

    printf("Recorrido en preorden: ");
    preOrden(raiz);
    printf("\n");

    return 0;
}