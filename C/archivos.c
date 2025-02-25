#include <stdio.h>

int main() {
    FILE *file;
    char texto[100];

    file = fopen("archivo.txt", "w");
    if (file == NULL) {
        printf("Error al abrir el archivo\n");
        return 1;
    }

    fprintf(file, "Hola, mundo!\n");
    fclose(file);

    file = fopen("archivo.txt", "r");
    if (file == NULL) {
        printf("Error al abrir el archivo\n");
        return 1;
    }

    while (fgets(texto, 100, file) != NULL) {
        printf("%s", texto);
    }

    fclose(file);
    return 0;
}