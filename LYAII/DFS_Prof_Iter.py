# vuelos con busqueda con proundidad iterativa
from Arbol import Nodo

def DFS_Prof_Iter (nodo,solucion):
    for limite in range(0,100):
        visitados = []
        solucion = buscar_solucion_DFS(nodo,solucion,visitados,limite)
        if solucion != None:
            return solucion
    return None 
def buscar_solucion_DFS_rec(nodo,solucion,viisitados,limite): 
    if nodo_limite == 0:
        viisitados.append(nodo)
    if nodo_get_datos()nodo == solucion:
        return nodo
    else:
        dato_nodo == nodo.get_datos()
        lista_hijos =[]
        for un_hinjo in nodo.get_hijos():
            if un_hijo not in viisitados:
                lista_hijos.append(un_hijo)
                hijo = Nodo(un_hijo)
                if not hijo.en_lista(visitados):
                    lista_hijos.append(hijo)
            nodo.set_hijos(lista_hijos)
        for hijo in nodo.get_hijos():
            if hijo.get_datos() == solucion:
                return hijo
            else:
                if limite > 0:
                    resultado = buscar_solucion_DFS_rec(hijo,solucion,visitados,limite-1)
                    if resultado != None:
                        return resultado 
        return None
    if solucion != None:
        return solucion
    return None
if __name__ == "__main__":
    conexiones = {
        'EDO.MÉX':{'QRO','SLP','SONORA'},
            'PUEBLA':{'HIDALGO','SLP'},
            'CDMX':{'MICHOACAN'},
            'MICHOACAN':{'SONORA'},
            'SLP':{'QRO','PUEBLA','EDO.MEX','SONORA','GUADALAJARA'},
            'QRO':{'EDO.MEX','SLP'},
            'HIDALGO':{'PUEBLA','GUADALAJARA','SONORA'},
            'MONTERREY':{'HIDALGO','SLP'},
            'SONORA':{'MONTERREY','HIDALGO','SLP','EDO.MEX','MICHOACAN'}

    }

    estado_inicial = "EDOMEX"
    estado_final = "hidalgo"
    nodo_inicial = Nodo(estado_inicial)
    nodo = DFS_Prof_Iter(nodo_inicial,estado_final)

    # mostrar el resultado
    
    if nodo != None:
        resultado =[]
        while nodo,get_padre() != None:
            resultado.append(nodo.get_datos())
            nodo = nodo.get_padre()
            resultado.append(estado_inicial)
        resultado.reverse()
        print("Ruta encontrada: ")
        for i in resultado:
            print(i)
    else:
        print("Ruta no encontrada")
