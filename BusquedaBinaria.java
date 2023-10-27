import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria {


    static class QuickSort {

        public static double[] quickSort(double[] arr) {
            return quickSort(arr, 0.0, arr.length - 1.0);
        }

        private static double[] quickSort(double[] arr, double primero, double ultimo) {
            int i, j;
            double central;
            central = (primero + ultimo) / 2;
            double pivote = arr[(int) central];
            i = (int) primero;
            j = (int) ultimo;

            do {
                while (arr[i] < pivote)
                    i++;
                while (arr[j] > pivote)
                    j--;

                if (i <= j) {
                    int aux = (int) arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;

                    i++;
                    j--;
                }
                System.out.println("-" + Arrays.toString(arr));
            } while (i <= j);

            if (primero < j) {
                quickSort(arr, primero, j);
            }
            if (i < ultimo) {
                quickSort(arr, i, ultimo);
            }

            return arr;
        }

    }

    public static int binarySearch(int[] arr, int search) {
        int inicio = 0;
        int fin = arr.length - 1;
        while (inicio <= fin) {
            int centro = (inicio + fin) / 2;
            if (search == arr[centro]) {
                return centro;
            }
            if (search > arr[centro]) {
                inicio = centro + 1;
            } else {
                fin = centro - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] randomArr = new int[1000];
        Random rand = new Random();
        int last = 0;
        for(int i = 0; i < 1000; i++){
            int randomNumber = rand.nextInt(100) + 1 + last;
            last = randomNumber;
            randomArr[i] = randomNumber;
        }

        System.out.println(Arrays.toString(randomArr));
        int search = 918;
        int indice = binarySearch(randomArr, search);

        System.out.println("numero a encontrar: " + search);
        if (indice == -1) {
            System.out.println("El numero no existe en el arreglo");
        } else {
            System.out.println("numero <" + search
                    + "> encontrado en la posición : [" + indice + "]");
        }
    }

}