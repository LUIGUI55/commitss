type Readonly<T> = {
    readonly [P in keyof T]: T[P];
};

interface Usuario {
    nombre: string;
    edad: number;
}

let usuario: Readonly<Usuario> = {
    nombre: "Luis",
    edad: 30
};

// usuario.nombre = "Carlos"; // Error: Cannot assign to 'nombre' because it is a read-only property.