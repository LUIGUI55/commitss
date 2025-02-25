#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

int main() {
    int socket_desc, nuevo_socket, c;
    struct sockaddr_in servidor, cliente;
    char *mensaje;

    socket_desc = socket(AF_INET, SOCK_STREAM, 0);
    if (socket_desc == -1) {
        printf("No se pudo crear el socket\n");
    }

    servidor.sin_family = AF_INET;
    servidor.sin_addr.s_addr = INADDR_ANY;
    servidor.sin_port = htons(8888);

    if (bind(socket_desc, (struct sockaddr *)&servidor, sizeof(servidor)) < 0) {
        printf("Error al hacer bind\n");
        return 1;
    }

    listen(socket_desc, 3);

    printf("Esperando conexiones...\n");
    c = sizeof(struct sockaddr_in);
    nuevo_socket = accept(socket_desc, (struct sockaddr *)&cliente, (socklen_t*)&c);
    if (nuevo_socket < 0) {
        printf("Error al aceptar\n");
        return 1;
    }

    mensaje = "Hola Cliente\n";
    write(nuevo_socket, mensaje, strlen(mensaje));

    close(nuevo_socket);
    close(socket_desc);
    return 0;
}