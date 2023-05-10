import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        int[] randomArray = new int[10000];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt();
        }

        // 3. Добавление элементов массива в дерево
        int[] array1 = new int[randomArray.length];
        int[] array12 = new int[randomArray.length];
        for (int i = 0; i < randomArray.length; i++) {
            long start = System.nanoTime();
            int iter = redBlackTree.add(randomArray[i]);
            long finish = System.nanoTime();
            long elapsed = finish - start;
            array1[i] = (int) elapsed;
            array12[i] = iter;
        }

        double avarage12 = 0;
        double sum12 = 0;
        for (int i = 0; i < array12.length; i++) {
            sum12 += array12[i];
        }
        avarage12 = sum12 / array12.length;

        double avarage1 = 0;
        double sum = 0;
        for (int j = 0; j < array1.length; j++){
            sum += array1[j];
        }
        avarage1 = sum / array1.length;
        System.out.println("среднее время добавления элемента: " + avarage1 + " наносекунд");
        System.out.println("среднее количество операций для добавления элемента в дерево: " + avarage12 + " операций");

        int[] secondArray = new int[100];
        for (int i = 0; i < secondArray.length; i++){
            int index = random.nextInt(randomArray.length);
            secondArray[i] = randomArray[index];
            randomArray[index] = randomArray[randomArray.length-1];
            randomArray = Arrays.copyOf(randomArray, randomArray.length-1);
        }

        // 4. Поиск элементов в дереве
        int[] array2 = new int[secondArray.length];
        for (int i = 0; i < secondArray.length; i++) {
            long secondStart = System.nanoTime();
            redBlackTree.contains(secondArray[i]);
            long secondFinish = System.nanoTime();
            long secondElapsed = secondFinish - secondStart;
            array2[i] = (int) secondElapsed;
        }

        double avarage2 = 0;
        double sum2 = 0;
        for (int j = 0; j < array2.length; j++){
            sum2 += array2[j];
        }
        avarage2 = sum2 / array2.length;
        System.out.println("среднее время поиска элемента: " + avarage2 + " наносекунд");

        int[] thirdArray = new int[1000];
        for (int i = 0; i < thirdArray.length; i++){
            int index2 = random.nextInt(randomArray.length);
            thirdArray[i] = randomArray[index2];
            randomArray[index2] = randomArray[randomArray.length-1];
            randomArray = Arrays.copyOf(randomArray, randomArray.length-1);
        }

        // 5. Удаление элементов из дерева
        int[] array3 = new int[thirdArray.length];
        for (int i = 0; i < thirdArray.length; i++) {
            long thirdStart = System.nanoTime();
            redBlackTree.remove(thirdArray[i]);
            long thirdFinish = System.nanoTime();
            long thirdElapsed = thirdFinish - thirdStart;
            array3[i] = (int) thirdElapsed;
        }

        double avarage3 = 0;
        double sum3 = 0;
        for (int j = 0; j < array3.length; j++){
            sum3 += array3[j];
        }
        avarage3 = sum3 / array3.length;
        System.out.println("среднее время удаления элемента: " + avarage3 + " наносекунд");
    }
}
