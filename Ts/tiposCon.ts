type Mensaje<T> = T extends string ? string : number;

let mensajeString: Mensaje<string> = "Hola";
let mensajeNumero: Mensaje<number> = 123;