# Crear una API con JavaScript, HTML y CSS

## 1. Configurar el entorno de desarrollo
1. Asegúrate de tener Node.js y npm instalados en tu sistema. Puedes descargarlos desde [nodejs.org](https://nodejs.org/).

2. Crea una carpeta para tu proyecto y navega a ella:
    ```bash
    mkdir mi-api
    cd mi-api
    ```

3. Inicializa un nuevo proyecto Node.js:
    ```bash
    npm init -y
    ```

## 2. Instalar las dependencias necesarias
1. Instala Express, un framework para construir aplicaciones web con Node.js:
    ```bash
    npm install express
    ```

## 3. Crear la API con Express
1. Crea un archivo llamado `server.js` y añade el siguiente código:
    ```javascript
    const express = require('express');
    const app = express();
    const port = 3000;

    app.use(express.json());

    let data = [
        { id: 1, message: 'Hello, World!' },
        { id: 2, message: 'Hello, API!' }
    ];

    app.get('/api/data', (req, res) => {
        res.json(data);
    });

    app.post('/api/data', (req, res) => {
        const newData = req.body;
        data.push(newData);
        res.status(201).json(newData);
    });

    app.listen(port, () => {
        console.log(`API running at http://localhost:${port}`);
    });
    ```

## 4. Crear la interfaz de usuario con HTML y CSS
1. Crea un archivo llamado `index.html` y añade el siguiente código:
    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>API con JavaScript, HTML y CSS</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>API con JavaScript, HTML y CSS</h1>
        <div id="data-container"></div>
        <script src="script.js"></script>
    </body>
    </html>
    ```

2. Crea un archivo llamado `styles.css` y añade el siguiente código:
    ```css
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }

    h1 {
        color: #333;
    }

    #data-container {
        margin-top: 20px;
    }
    ```

3. Crea un archivo llamado `script.js` y añade el siguiente código:
    ```javascript
    document.addEventListener('DOMContentLoaded', () => {
        fetch('/api/data')
            .then(response => response.json())
            .then(data => {
                const container = document.getElementById('data-container');
                data.forEach(item => {
                    const div = document.createElement('div');
                    div.textContent = item.message;
                    container.appendChild(div);
                });
            });
    });
    ```

## 5. Ejecutar la aplicación
1. Asegúrate de que tu servidor Express esté sirviendo los archivos estáticos. Actualiza `server.js` para incluir lo siguiente:
    ```javascript
    // ...existing code...
    app.use(express.static('public'));
    // ...existing code...
    ```

2. Mueve `index.html`, `styles.css` y `script.js` a una carpeta llamada `public`.

3. Ejecuta el servidor:
    ```bash
    node server.js
    ```

4. Abre tu navegador y ve a `http://localhost:3000` para ver la aplicación en funcionamiento.

¡Y eso es todo! Ahora tienes una API básica creada con JavaScript, HTML y CSS.