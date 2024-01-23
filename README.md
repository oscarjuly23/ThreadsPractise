# ThreadsPractise
Este repositorio contiene un proyecto que aborda conceptos de Threads y concurrencia. Aquí encontrarás implementaciones en Java que responden a diferentes ejercicios propuestos.

## Ejercicios
### [Búsqueda Paralela 1](https://github.com/oscarjuly23/ThreadsPractise/tree/main/src/Exercicis/Exercici3)


### [Búsqueda Paralela 2](https://github.com/oscarjuly23/ThreadsPractise/tree/main/src/Exercicis/Exercici4)
Hemos implementado una clase en Java que permite realizar una búsqueda paralela de un entero dentro de un array. La clase contiene el siguiente método:  

public static int buscaParalela(int aBuscar, int[] Array, int NumThreads)  

Este método crea tantos hilos como se especifica en NumThreads, divide el array Array en tantas partes como NumThreads, y asigna a cada hilo la parte correspondiente del array para realizar una búsqueda secuencial del valor aBuscar. Si un hilo encuentra el valor, el método devuelve la posición en el array inicial y muestra por pantalla el número de hilo. En caso contrario, el método devuelve -1. La clase también almacena la longitud del array, el número de hilos y el valor a buscar como atributos.


### [Paralela & Memoria Compartida](https://github.com/oscarjuly23/ThreadsPractise/tree/main/src/Exercicis/Exercici5)
En esta versión, hemos modificado el ejercicio anterior para que los hilos accedan al array mediante memoria compartida. Comparamos los tiempos de búsqueda con el ejercicio anterior y justificamos las diferencias. Se realizaron experimentos con diferentes tamaños de array y números de hilos para evaluar el rendimiento.

### [MergeSort Multithreaded](https://github.com/oscarjuly23/ThreadsPractise/tree/main/src/Exercicis/Exercici7)
Implementamos un programa multihilo en Java que ordena un array recursivamente utilizando el algoritmo Merge Sort. El hilo principal crea 2 hilos, y cada uno crea dos nuevos hilos para ordenar la mitad del array. Este enfoque multihilo mejora la eficiencia del proceso de ordenación.

## Aàlisis de Resultados:

### Ejercicios Búsqueda Paralela
Hemos llevado a cabo una serie de experimentos para evaluar el rendimiento de la búsqueda paralela en un array utilizando memoria compartida (ejercicio 5) en comparación con la versión sin memoria compartida (ejercicio 4). A continuación, se presentan los resultados clave:

Tamaño del Array: 10, NumThreads: 2
- Sin Memomria Compartida (nS): 511.400
- Con Memomria Compartida (nS): 386.500

Tamaño del Array: 100, NumThreads: 2
- Sin Memomria Compartida (nS): 417.300
- Con Memomria Compartida (nS): 458.300

Tamaño del Array: 1000 ,NumThreads: 2
- Sin Memomria Compartida (nS): 465.000
- Con Memomria Compartida (nS): 647.400

Observamos que la búsqueda utilizando memoria compartida tiende a superar a la versión sin memoria compartida a medida que aumenta el tamaño del array. Esto puede deberse a la gestión eficiente de recursos y la paralelización de tareas, especialmente en conjuntos de datos más grandes.


### Ejercicio MergeSort
Hemos evaluado el rendimiento del algoritmo de ordenación MergeSort con y sin multithreading. A continuación, se presentan los resultados para diferentes tamaños de array:

Tamaño del Array: 10
MergeSort (nS): 5.518.900
Secuencial (nS): 14.900

Se observó un retraso notable en el uso del MergeSort con multithreading en comparación con la ordenación secuencial para los tamaños de datos probados. Esto podría atribuirse a la creación y espera de múltiples threads, lo que puede sobrecargar los recursos del sistema.

##
- @author: Oscar Julian
- @date: Decemmbre 2022
