interface Persona {
    nombre: string;
    edad: number;
}

type PersonaKeys = keyof Persona; // "nombre" | "edad"

function obtenerPropiedad<T, K extends keyof T>(obj: T, key: K): T[K] {
    return obj[key];
}

let persona: Persona = { nombre: "Luis", edad: 30 };
let nombre = obtenerPropiedad(persona, "nombre");
console.log(nombre); // Luis
