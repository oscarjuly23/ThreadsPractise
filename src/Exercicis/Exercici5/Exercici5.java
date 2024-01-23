package Exercicis.Exercici5;

import Exercicis.Time;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Exercici5 {
    static int nArray;
    public static ReentrantLock mutex = new ReentrantLock();
    public static void ex5() {
        int arraySize = 100;
        int NumThreads = 5;
        int aBuscar = (int) (Math.random() * arraySize);
        int[] Array = new int[arraySize];

        System.out.println("Mida de l'Array: " + arraySize);
        System.out.println("Quantitat de Threads: " + NumThreads);
        System.out.println("Numero a cercar: " + aBuscar);

        // Omplim l'array de numeros random:
        for (int i = 0; i < arraySize; i++) {
            Array[i] = (int) (Math.random() * arraySize);
            //System.out.println((Array[i]));
            //Array[i] = i;
        }

        int n = cercaParallelaShared(aBuscar, Array, NumThreads);
        if (n < 0) {
            System.out.println("El numero que busques no es troba a la llista.");
        } else {
            nArray = nArray+1;
            System.out.println("El numero s'ha trobat en la particio (" +nArray + "/"+NumThreads+") en la posicio (" + n + ").");
        }
    }

    public static int cercaParallelaShared(int aBuscar, int[] Array, int NumThreads) {
        // 1. Dividim l'array en tantes parts com NumThreads
        int divArray = Array.length / NumThreads;
        ArrayList<SearchInArrayShared> listThreads = new ArrayList<>();
        int inici, final_;
        boolean trobat = false;
        int posArray = -1;
        Time t = new Time();

        // 2. Creem tants threads com especifica NumThreads
        for (int i = 0; i < NumThreads; i++) {
            inici = i * divArray;
            final_ = (i * divArray + divArray);
            // 3. En aquest cas no copiem l'array sino que tots els threads utilitzaran el mateix array compartint-lo
            listThreads.add(new SearchInArrayShared(i, Array, inici, final_, aBuscar));
        }

        t.setT_inici();
        for (SearchInArrayShared n_Thread: listThreads) {
            n_Thread.start();
        }

        try {
            for (SearchInArrayShared n_Thread: listThreads) {
                n_Thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setT_final();
        //System.out.println(t.getT_final());

        for (SearchInArrayShared n_Thread: listThreads) {
            if (n_Thread.isTrobat()) {
                trobat = true;
                nArray = n_Thread.getnArray();
                posArray = n_Thread.getPosArray();
                break;
            }
        }

        if (!trobat) {
            return -1;
        }
        return posArray;
    }
}