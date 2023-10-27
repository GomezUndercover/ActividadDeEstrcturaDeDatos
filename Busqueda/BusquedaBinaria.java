import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BusquedaBinaria {

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
        Scanner sc = new Scanner(System.in);
        int[] randomArr = new int[1000];
        Random rand = new Random();
        int last = 0;
        for (int i = 0; i < 1000; i++) {
            int randomNumber = rand.nextInt(5) + 1 + last;
            last = randomNumber;
            randomArr[i] = randomNumber;
        }
        System.out.println(Arrays.toString(randomArr));
        System.out.println("Que numero deseas buscar dentro del array?: ");
        int search = sc.nextInt();
        int indice = binarySearch(randomArr, search);

        System.out.println("numero a encontrar: " + search);
        if (indice == -1) {
            System.out.println("El numero no existe en el arreglo");
        } else {
            System.out.println("numero <" + search
                    + "> encontrado en la posicion : [" + indice + "]");
        }
    }

}
