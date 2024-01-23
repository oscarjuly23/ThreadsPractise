package Exercicis;

public class Time {
    private long t_inici, t_final;

    public void setT_inici() {
        t_inici = System.nanoTime();;
    }
    public void setT_final() {
        this.t_final = System.nanoTime() - t_inici;
    }
    public long getT_final() {
        return t_final;
    }
}
