public class MyUnknown1 {
    public static void main(String a[]){
        System.out.format("\nfoo(%f", 4.0,foo(10));
        System.out.format("\nfoo(%f)=%f",40.0,foo(40));
        System.out.format("\nfoo(%f)=%f",10.0,foo(10));
    }

    /**
     * @param coef the number whose foo has to be computed; REQUIRED > 0
     * @return an aproximation of XXX(coef)
     */
    static double foo(double coef){
        assert coef > 0;
        double ans = coef/2.0;
        int i = 1;
        while (i < 7){
            ans = ans - ((ans * ans - coef)/(2.0*ans));
            i = i+1;
        }
        return ans;
    }
}
