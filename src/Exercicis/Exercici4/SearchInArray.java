package Exercicis.Exercici4;

public class SearchInArray extends Thread  {
    private final int nArray;
    private final int[] Array;
    private final int inici;
    private final int final_;
    private final int aBuscar;
    private boolean trobat = false;
    private int posArray;

    public SearchInArray(int nArray, int[] array, int inici, int final_, int aBuscar) {
        this.nArray = nArray;
        Array = array;
        this.inici = inici;
        this.final_ = final_;
        this.aBuscar = aBuscar;
    }

    public void run() {
        for (int i = inici; i < final_; i++) {
            //System.out.println(nArray + ": " + i);
            if (Array[i-inici] == aBuscar) {
                trobat = true;
                posArray = i;
                break;
            }
        }
    }

    public int getPosArray() {
        return posArray;
    }
    public boolean isTrobat() {
        return trobat;
    }
    public int getnArray() {
        return nArray;
    }
}