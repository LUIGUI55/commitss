class Perro extends Animal {
    constructor(nombre: string) {
        super(nombre);
    }

    hacerSonido(): void {
        console.log(`${this.nombre} ladra.`);
    }
}

let miPerro = new Perro("Firulais");
miPerro.hacerSonido();

