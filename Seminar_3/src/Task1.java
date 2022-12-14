//Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Заполните массив целыми числами: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Заданный массив: " + Arrays.toString(arr));
        System.out.println("Отсортированный массив: " + Arrays.toString(mergeSort(arr, size)));
    }

    public static int[] mergeSort(int[] arr, int size) {
        if (size < 2) return arr;

        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, size - mid);

        mergeSort(left, mid);
        mergeSort(right, size - mid);

        merge(arr, left, right, mid, size - mid);
        return arr;
    }

    private static void merge(int[] arr, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }
}





