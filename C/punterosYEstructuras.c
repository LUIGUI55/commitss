#include <stdio.h>

struct Persona {
    char nombre[50];
    int edad;
};

void imprimirPersona(struct Persona *p) {
    printf("Nombre: %s\n", p->nombre);
    printf("Edad: %d\n", p->edad);
}

int main() {
    struct Persona persona = {"Luis", 30};
    imprimirPersona(&persona);
    return 0;
}