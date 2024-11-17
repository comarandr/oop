public class Ripulito {
    private int[] aa; //array vuoto
    private int[] x; //array vuoto
    private int ll; //intero

    public static void main(String a[]) { //riordina l'array? funziona con gli interi
        int[] y = {-11, 89, -12, 56};
        Ripulito mms = new Ripulito();
        mms.s(y);
        for (int i : y) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
/*
non so se sia il caso di mettere il metodo s() come public, ma anche a cosa serva
 */
    public void s(int xx[]) {
        this.aa = xx;
        this.ll = xx.length;
        this.x = new int[ll];
        foo(0, ll - 1);
    }

    private void foo(int i, int j) {
        if (i < j) {
            int k = i + (j - i) / 2;
            foo(i, k);
            foo(k + 1, j);
            mp(i, k, j);
        }
    }

    private void mp(int jj, int ii, int kk) {
        for (int i = jj; i <= kk; i++) {
            x[i] = aa[i];
        }
        int i = jj;
        int j = ii + 1;
        int k = jj;
        while (i <= ii && j <= kk) {
            if (x[i] <= x[j]) {
                aa[k] = x[i];
                i++;
            } else {
                aa[k] = x[j];
                j++;
            }
            k++;
        }
        while (i <= ii) {
            aa[k] = x[i];
            k++;
            i++;
        }
    }
}
