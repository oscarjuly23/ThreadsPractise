package Exercicis.Exercici7;

import java.util.ArrayList;

public class MergeSort extends Thread {
    ArrayList<Integer> arr;
    ArrayList<Integer> resArr = new ArrayList<>();

    public MergeSort(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public void run() {
        mergeSort();
    }

    private void mergeSort() {
        // Es crida recursivament fins que quedi 1.
        if (arr.size() == 1) {
            resArr.add(arr.get(0));
            return;
        }

        // D'aquesta manera anem dividint l'array.
        int chunkSize = arr.size() % 2 == 0 ? arr.size() / 2 : (arr.size() / 2) + 1;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        // Posem totes les divisions en un array i a l'altre.
        for (int i = 0; i < arr.size(); i++) {
            if (i < chunkSize) {
                arr1.add(arr.get(i));
            } else {
                arr2.add(arr.get(i));
            }
        }

        // Cada divisió del MergeSort s'ordenarà en dos nous Threads
        MergeSort mer1 = new MergeSort(arr1);
        MergeSort mer2 = new MergeSort(arr2);

        mer1.start();
        mer2.start();
        try {
            mer1.join();
            mer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        merge(mer1.getResArr(), mer2.getResArr());
    }

    private void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        resArr.clear();

        while (!arr1.isEmpty() && !arr2.isEmpty()) {
            if (arr1.get(0) > arr2.get(0)) {
                resArr.add(arr2.get(0));
                arr2.remove(0);
            } else {
                resArr.add(arr1.get(0));
                arr1.remove(0);
            }
        }

        while (!arr1.isEmpty()) {
            resArr.add(arr1.get(0));
            arr1.remove(0);
        }

        while (!arr2.isEmpty()) {
            resArr.add(arr2.get(0));
            arr2.remove(0);
        }
    }

    public ArrayList<Integer> getResArr() {
        return resArr;
    }
}