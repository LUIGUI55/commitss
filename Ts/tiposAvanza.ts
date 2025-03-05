type Extractor<T, U> = T extends U ? T : never;

type Tipo1 = Extractor<string | number | boolean, string>; // string
type Tipo2 = Extractor<string | number | boolean, number>; // number

function extraer<T, U>(valor: T, tipo: U): Extractor<T, U> {
    if (typeof valor === typeof tipo) {
        return valor as Extractor<T, U>;
    }
    throw new Error("Tipo no coincide");
}

let resultado = extraer("Hola", ""); // "Hola"
console.log(resultado);