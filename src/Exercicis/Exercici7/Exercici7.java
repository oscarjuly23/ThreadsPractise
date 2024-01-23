package Exercicis.Exercici7;

import Exercicis.Time;
import java.util.ArrayList;

public class Exercici7 {
    public static void ex7() {
        int arraySize = 100;
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Mida de l'Array: " + arraySize);
        Time t = new Time();

        // Omplim l'array de numeros random:
        for (int i = 0; i < arraySize; i++) {
            arr.add((int) (Math.random() * arraySize));
            //System.out.print(arr.get(i) + " ");
            //arr.add(i);
        }
        ArrayList<Integer> arr1 = arr;

        // 1. MERGE SORT
        MergeSort t_MergeSort = new MergeSort(arr);

        t.setT_inici();
        t_MergeSort.start();
        try {
            t_MergeSort.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setT_final();
        System.out.println("MergeSort: " + t.getT_final() + "nS");

        arr = t_MergeSort.getResArr();
/*        for (int i = 0; i < arraySize; i++) {
            System.out.print(arr.get(i) + " ");
        }*/

        // 2. ORDEBACIÓ SEQUENCIAL:
        t.setT_inici();
        arr1 = sequencialSort(arr);
        t.setT_final();
        System.out.println("SequencialSort: " + t.getT_final() + "nS");
/*        for (Integer i : arr1) {
            System.out.print(i + " ");
        }*/
    }

    private static ArrayList<Integer> sequencialSort(ArrayList<Integer> arr) {
        ArrayList<Integer> resArr = new ArrayList<>();
        int minim = Integer.MAX_VALUE;
        int j = 0;
        while (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) < minim) {
                    minim = arr.get(i);
                    j = i;
                }
            }
            resArr.add(minim);
            arr.remove(j);

            j = 0;
            minim = Integer.MAX_VALUE;
        }
            return resArr;
    }
}