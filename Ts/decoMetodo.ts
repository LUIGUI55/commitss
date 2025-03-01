function logMethod(target: any, key: string, descriptor: PropertyDescriptor) {
    const originalMethod = descriptor.value;

    descriptor.value = function (...args: any[]) {
        console.log(`Método ${key} llamado con argumentos: ${JSON.stringify(args)}`);
        return originalMethod.apply(this, args);
    };

    return descriptor;
}

class Calculadora {
    @logMethod
    sumar(a: number, b: number): number {
        return a + b;
    }
}

let calc = new Calculadora();
console.log(calc.sumar(2, 3));


