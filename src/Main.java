import Exercicis.Exercici3.Exercici3;
import Exercicis.Exercici4.Exercici4;
import Exercicis.Exercici5.Exercici5;
import Exercicis.Exercici7.Exercici7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("SESSIO 1 - THREADS & CONCURRENCIA");

        while (true) {
            System.out.println("1 -> Exercici 3: 2 Threads cerca paralela LinkedList");
            System.out.println("2 -> Exercici 4: Cerca paralela d'un enter en un Array");
            System.out.println("3 -> Exercici 5: Cerca paralela amb memoria compartida");
            System.out.println("4 -> Exercici 7: Programa multithread MergeSort");

            switch (read.nextLine()) {
                case "1" -> {
                    System.out.println("EXERCICI 3 - 2 Threads cerca paralela LinkedList");
                    Exercici3.ex3();
                }
                case "2" -> {
                    System.out.println("EXERCICI 4 - Cerca paralela d'un enter en un Array");
                    Exercici4.ex4();
                }
                case "3" -> {
                    System.out.println("EXERCICI 5 - Cerca paralela amb memoria compartida");
                    Exercici5.ex5();
                }
                case "4" -> {
                    System.out.println("EXERCICI 7 - Programa multithread MergeSort");
                    Exercici7.ex7();
                }
            }
            System.out.println();
        }
    }
}
