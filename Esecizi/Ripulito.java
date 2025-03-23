public class Ripulito {
    private int[] aa;
    private int[] x;
    private int ll;

    public static void main(String a[]) {
        int[] y = {45,23,11,89,77,98,4,28,65,43};
        Ripulito mms = new Ripulito();
        mms.s(y);
        for(int i:y){
            System.out.print(i);
            System.out.print(" ");
        }
    }

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
