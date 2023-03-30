import java.io.*;
import java.util.*;


public class BucketSort {
    static int itr = 0;


    // сам алгоритм
    public static void bucketSort(int[] array, int bucketSize) {
        //int itr = 0;
        if (array.length == 0) {
            return;
        }

        // Определение максимального и минимального элементов массива
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Создание ведер (бакетов) и распределение элементов по ним
        int bucketCount = (int) Math.ceil((maxValue - minValue) / (double) bucketSize);
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (int) Math.floor((array[i] - minValue) / (double) bucketSize);
            buckets[bucketIndex].add(array[i]);
            itr++;
        }

        // Сортировка пузырьком элементов внутри каждого ведра (бакета) и объединение их
        int currentIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            //Collections.sort(buckets[i]);
            int temp = 0;
            for (int j = 0; j < buckets[i].size(); j++) {
                for (int k = 1; k < (buckets[i].size()-j); k++) {
                    if (buckets[i].get(k - 1) > buckets[i].get(k)){
                        temp = buckets[i].get(k-1);
                        buckets[i].set(k - 1, buckets[i].get(k));
                        buckets[i].set(k, temp);
                        itr++;
                    }
                }
            }
        }
    }


    // создание файла с данными
    public static class NestedArrayExample {
        public static void main(String[] args) throws IOException {

            // Создание файла для записи наборов
            File file = new File("sets.txt");
            PrintWriter writer = new PrintWriter(file);

            // Создание 70 наборов случайных чисел от 100 до 10000 и запись их в файл
            Random random = new Random();
            for (int i = 0; i < 70; i++) {
                int size = random.nextInt(9901) + 100; // Размер набора от 100 до 10000
                for (int j = 0; j < size; j++) {
                    writer.print(random.nextInt(1000000) + " ");
                }
                writer.println();
            }

            writer.close();

            // Чтение наборов из файла и запись их в вложенный массив
            Scanner scanner = new Scanner(file);
            int[][] sets = new int[70][];
            int count = 0;
            for (int i = 0; i < 70; i++) {
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                int[] set = new int[numbers.length];
                for (int j = 0; j < numbers.length; j++) {
                    set[j] = Integer.parseInt(numbers[j]);
                }
                sets[i] = set;
                count++;
            }

            scanner.close();



            Arrays.sort(sets, Comparator.comparingInt(a -> a.length));
            // проходим по каждому набору и выводим их кол-ва элементов, время, за которое набор был отсортирован, количество итераций
            int count2 = 0;
            while (count2 < count){
                long start = System.nanoTime();
                bucketSort(sets[count2],sets[count2].length);
                long finish = System.nanoTime();
                long elapsed = finish - start;
                System.out.println("" + sets[count2].length + " " + elapsed + " " + itr);
                count2++;
            }
        }
    }
}
