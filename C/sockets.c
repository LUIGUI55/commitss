#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

int main() {
    int sock;
    struct sockaddr_in servidor;
    char mensaje[1000], respuesta[2000];

    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock == -1) {
        printf("No se pudo crear el socket\n");
    }

    servidor.sin_addr.s_addr = inet_addr("127.0.0.1");
    servidor.sin_family = AF_INET;
    servidor.sin_port = htons(8888);

    if (connect(sock, (struct sockaddr *)&servidor, sizeof(servidor)) < 0) {
        printf("Error al conectar\n");
        return 1;
    }

    printf("Conectado\n");
    printf("Mensaje: ");
    scanf("%s", mensaje);

    if (send(sock, mensaje, strlen(mensaje), 0) < 0) {
        printf("Error al enviar\n");
        return 1;
    }

    if (recv(sock, respuesta, 2000, 0) < 0) {
        printf("Error al recibir\n");
        return 1;
    }

    printf("Respuesta: %s\n", respuesta);
    close(sock);
    return 0;
}