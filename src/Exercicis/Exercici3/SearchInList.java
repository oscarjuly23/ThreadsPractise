package Exercicis.Exercici3;

import Exercicis.Time;
import java.util.LinkedList;

public class SearchInList extends Thread {
    private final LinkedList<Integer> list;
    private final int listSize;
    private final int num2Search;
    private final boolean reverse;
    private boolean trobat = false;
    private final Time t = new Time();

    public SearchInList(LinkedList<Integer> list, int listSize, int num2Search, boolean reverse) {
        this.list = list;
        this.listSize = listSize;
        this.num2Search = num2Search;
        this.reverse = reverse;
    }

    public void run() {
        t.setT_inici();
        if (!reverse) {
            for (int i = 0; i < listSize; i++) {
                if (num2Search == list.get(i)){
                    trobat = true;
                    break;
                }
            }
        } else {
            for (int i = listSize-1; i > 0; i--) {
                if (num2Search == list.get(i)) {
                    trobat = true;
                    break;
                }
            }
        }
        t.setT_final();
    }

    public boolean isTrobat() {
        return trobat;
    }
    public Time getTime() {
        return t;
    }
}