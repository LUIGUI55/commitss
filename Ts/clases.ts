class Animal {
    nombre: string;

    constructor(nombre: string) {
        this.nombre = nombre;
    }

    hacerSonido(): void {
        console.log(`${this.nombre} hace un sonido.`);
    }
}

let perro = new Animal("Perro");
perro.hacerSonido();


