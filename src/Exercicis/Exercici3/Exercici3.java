package Exercicis.Exercici3;

import java.util.LinkedList;

public class Exercici3 {
    public static void ex3() {
        LinkedList<Integer> list = new LinkedList<>();
        int listSize = 100;
        int num2Search = (int) (Math.random() * listSize);
        System.out.println("Mida de la llista: " + listSize);
        System.out.println("Numero a cercar: " + num2Search);

        // Omplim la llista de numeros random:
        for (int i = 0; i < listSize; i++) {
            list.add((int) (Math.random() * listSize));
            //list.add(i);
        }

        // Thread1 comença pel principi, Thread2 comença pel final.
        SearchInList thread1 = new SearchInList(list, listSize, num2Search, false);
        SearchInList thread2 = new SearchInList(list, listSize, num2Search, true);

        thread1.start();
        thread2.start();

        // Bloquea el subproceso de llamada hasta que finaliza el subproceso representado por esta instancia.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Obtenim els temps de cerca de cada Thread
        long t_pelPrincipi = thread1.getTime().getT_final();
        long t_pelFinal = thread2.getTime().getT_final();

        // Primer mirem que s'hagi trobat (si ho comprovem en T1, al ser la mateixa llista ja es suficient)
        if (thread1.isTrobat()) {
            if (t_pelPrincipi < t_pelFinal) {
                System.out.println("El numero s'ha trobat primer en la cerca pel principi (" +t_pelPrincipi + "nS) que en la cerca pel final (" + t_pelFinal + "nS).");
            } else {
                System.out.println("El numero s'ha trobat primer en la cerca pel final (" + t_pelFinal + "nS) que en la cerca pel principi (" + t_pelPrincipi + "nS).");
            }
        } else {
            System.out.println("El numero que busques no es troba a la llista.");
        }
    }
}