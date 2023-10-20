import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arrToBubbleSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
        int[] arrToQuickSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
        int[] arrToRadixSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
        int[] arrToMergeSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
        int input;
        do {
            System.out.print("1.BubbleSort\n2.QuickSort\n3.RadixSort\n4.MergeSort\n5.Salir\n=>");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("\nArray ordenado con BubbleSort: \n");
                    System.out.println("Antes: " + Arrays.toString(arrToBubbleSort));
                    BubbleSort.bubbleSort(arrToBubbleSort);
                    System.out.println("\nAhora: " + Arrays.toString(arrToBubbleSort));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\nArray ordenado con QuickSort: \n");
                    System.out.println("Antes: " + Arrays.toString(arrToQuickSort));
                    int[] arrQuickSort = QuickSort.quickSort(arrToQuickSort);
                    System.out.println("Ahora: " + Arrays.toString(arrQuickSort));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\nArray ordenado con RadixSort: \n");
                    System.out.println("Antes: " + Arrays.toString(arrToRadixSort));
                    int[] arrRadixSort = RadixSort.radixSort(arrToRadixSort);
                    System.out.println("Ahora: " + Arrays.toString(arrRadixSort));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\nArray ordenado con MergeSort: \n");
                    System.out.println("Antes: " + Arrays.toString(arrToMergeSort));
                    int[] arrMergeSort = MergeSort.mergeSort(arrToMergeSort);
                    System.out.println("Ahora: " + Arrays.toString(arrMergeSort));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion no definida.");
                    break;
            }
        } while (input != 5);
        sc.close();
        
    }
}