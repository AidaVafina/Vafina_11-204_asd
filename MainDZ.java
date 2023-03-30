package Homework;
// алгоритм быстрого поиска

import java.util.Scanner;

public class MainDZ {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n + 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        while (scanner.hasNextInt()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == u) {
                    array[i] = v;
                }
            }
        }
        System.out.println("Нет пути между вершинами: ");
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] != array[j]) {
                    System.out.println(i + " => " + j);
                }
            }
        }
    }
}
