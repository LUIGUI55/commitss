function logConstructor(target: Function) {
    console.log(`Constructor de ${target.name} llamado`);
}

@logConstructor
class Vehiculo {
    constructor(public marca: string) {}
}

let coche = new Vehiculo("Toyota");

