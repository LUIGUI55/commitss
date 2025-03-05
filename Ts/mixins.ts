type Constructor<T = {}> = new (...args: any[]) => T;

function Volador<TBase extends Constructor>(Base: TBase) {
    return class extends Base {
        volar() {
            console.log("Volando!");
        }
    };
}

function Nadador<TBase extends Constructor>(Base: TBase) {
    return class extends Base {
        nadar() {
            console.log("Nadando!");
        }
    };
}

class Persona {
    constructor(public nombre: string) {}
}

const SuperPersona = Volador(Nadador(Persona));

let superPersona = new SuperPersona("Luis");
superPersona.volar();
superPersona.nadar();