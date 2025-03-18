function logParameter(target: any, key: string, index: number) {
    const metadataKey = `log_${key}_parameters`;
    if (Array.isArray(target[metadataKey])) {
        target[metadataKey].push(index);
    } else {
        target[metadataKey] = [index];
    }
}

class Usuario {
    saludar(@logParameter nombre: string): string {
        return `Hola, ${nombre}`;
    }
}

let usuario = new Usuario();
usuario.saludar("Luis");
