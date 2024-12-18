public class MyInsertionSort {
    /*
    prendere il seguente esempio di codice Java,inserirlo in un opportuno file / progetto e,usando
     di Eclipse/Intellij, e manipolarlo in modo da:
     1. verificare che funzioni
     2. produrne una versione applicando il meccanismo di astrazione per
     parametrizzazione; e verificare che funzioni;
     3. produrne una versione applicando la astrazione per specifica. E verificare
     che funzioni.
     */
    static int[] arr1 = {10,34,2,56,7,67,88,42};
    static int temp;

    public static void main(String a[] ) {
        riordinaArray(arr1);
        stampaArray(arr1);
    }
        private static void riordinaArray(int[] arr1){
            for(int i = 1; i < arr1.length; i++){
                for(int j = i; j > 0; j--){
                    if(arr1[j] < arr1[j-1]){
                        temp = arr1[j];
                        arr1[j] = arr1[j-1];
                        arr1[j-1] = temp;
                    }
                }
            }
        }

        private static void stampaArray(int[] arr1){
            for(int i : arr1){
                System.out.print(i);
                System.out.print(",");
            }
        }

        /*versione originale
        for(int i = 1; i < arr1.length; i++){
            for(int j = i; j > 0; j--){
                if(arr1[j] < arr1[j-1]){
                    temp = arr1[j];
                    arr1[j] = arr1[j-1];
                    arr1[j-1] = temp;
                }
            }
        }
        for(int i:arr1){
            System.out.print(i);
            System.out.print(",");
        } */

}
