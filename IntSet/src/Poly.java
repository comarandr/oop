public class Poly {
    private int[] trms;
    private int deg;

    public Poly() {
        trms = new int[1];
        deg = 0;
    }

    public Poly(int c, int n) {
        if (n < 0)
            throw new NegativeExponentException("Poly(int,int");
        if (c == 0) {
            trms = new int[1];
            deg = 0;
            return;
        }
        trms = new int[n + 1];
        for (int i = 0; i < n; i++) {
            trms[i] = 0;
            trms[n] = c;
            deg = n;
        }
    }

    private Poly(int n){
        trms = new int[n+1];
        deg = n;
    }

    
}