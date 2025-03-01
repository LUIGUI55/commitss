function logProperty(target: any, key: string) {
    let value = target[key];
    const getter = () => {
        console.log(`Get: ${key} => ${value}`);
        return value;
    };
    const setter = (newVal) => {
        console.log(`Set: ${key} => ${newVal}`);
        value = newVal;
    };
    Object.defineProperty(target, key, {
        get: getter,
        set: setter,
        enumerable: true,
        configurable: true
    });
}
class Persona {
    @logProperty
    nombre: string;

    constructor(nombre: string) {
        this.nombre = nombre;
    }
}

let persona = new Persona("Luis");
persona.nombre = "Carlos";
console.log(persona.nombre);
