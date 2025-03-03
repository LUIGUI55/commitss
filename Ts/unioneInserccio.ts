type A = { a: number };
type B = { b: number };

type Union = A | B;
type Interseccion = A & B;

let union: Union = { a: 1 };
let interseccion: Interseccion = { a: 1, b: 2 };

