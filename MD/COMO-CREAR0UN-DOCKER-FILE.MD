# ¿Qué es Docker y cómo se utiliza?

## ¿Qué es Docker?
Docker es una plataforma de contenedorización que permite a los desarrolladores empaquetar aplicaciones y sus dependencias en contenedores. Estos contenedores son ligeros, portátiles y se pueden ejecutar en cualquier entorno que tenga Docker instalado, asegurando que la aplicación se comporte de la misma manera en desarrollo, pruebas y producción.

## ¿Por qué usar Docker?
- **Portabilidad**: Los contenedores Docker pueden ejecutarse en cualquier sistema operativo que soporte Docker.
- **Consistencia**: Asegura que la aplicación se ejecute de la misma manera en diferentes entornos.
- **Aislamiento**: Cada contenedor tiene su propio entorno aislado, lo que evita conflictos entre dependencias.
- **Eficiencia**: Los contenedores son ligeros y utilizan menos recursos que las máquinas virtuales.

## Instalación de Docker
1. **Linux**:
    ```bash
    sudo apt-get update
    sudo apt-get install docker-ce docker-ce-cli containerd.io
    ```
2. **Windows/Mac**:
    - Descarga e instala Docker Desktop desde [docker.com](https://www.docker.com/products/docker-desktop).

## Comandos básicos de Docker
- **Verificar la instalación**:
    ```bash
    docker --version
    ```
- **Ejecutar un contenedor**:
    ```bash
    docker run hello-world
    ```
- **Listar contenedores en ejecución**:
    ```bash
    docker ps
    ```
- **Listar todos los contenedores**:
    ```bash
    docker ps -a
    ```
- **Detener un contenedor**:
    ```bash
    docker stop <container_id>
    ```
- **Eliminar un contenedor**:
    ```bash
    docker rm <container_id>
    ```

## Crear un Dockerfile
Un `Dockerfile` es un archivo de texto que contiene las instrucciones para construir una imagen Docker. Aquí tienes un ejemplo básico:

```Dockerfile
# Usar una imagen base de Python
FROM python:3.9-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos de la aplicación
COPY . /app

# Instalar las dependencias
RUN pip install -r requirements.txt

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 5000

# Comando para ejecutar la aplicación
CMD ["python", "app.py"]

