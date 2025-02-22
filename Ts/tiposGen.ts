function identidad<T>(arg: T): T {
    return arg;
}

let numero = identidad<number>(10);
let texto = identidad<string>("Hola");