import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListFirst = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи длину массива: ");
        int scInt = scanner.nextInt();
        for (int i = 0 ; i < scInt; i++){
            int absoluteNumber = (int) (Math.random()*(10000000 +1));
            int binaryNumber = (int) (Math.random()*(1 +1));
            if (binaryNumber == 1){
                absoluteNumber = absoluteNumber * -1;
            }
            arrayListFirst.add(absoluteNumber);
        }
        ArrayList<Integer> arrayListSecond = (ArrayList<Integer>) arrayListFirst.clone();
        System.out.println("Неотсортированный массив: " + arrayListFirst);
        long startTimeSelectionSort = System.currentTimeMillis();
        for (int i = 0; i < arrayListFirst.size() - 1; i++){
            int minNumberIndex = i;
            int minNumber = arrayListFirst.get(i);
            for (int j = i + 1; j < arrayListFirst.size(); j++){
                if (minNumber > arrayListFirst.get(j)){
                    minNumber = arrayListFirst.get(j);
                    minNumberIndex = j;
                }
            }
            arrayListFirst.set(minNumberIndex, arrayListFirst.get(i));
            arrayListFirst.set(i, minNumber);
        }
        long finishTimeSelectionSort = System.currentTimeMillis();
        long elapsed = finishTimeSelectionSort - startTimeSelectionSort;
        System.out.println("Отсортированный массив выбором: " + arrayListFirst);
        System.out.println("Время сортировки выбором, мс " + elapsed);
        long startTimeSort = System.currentTimeMillis();
        Collections.sort(arrayListSecond);
        long finishTimeSort = System.currentTimeMillis();
        long elapsedSort = finishTimeSort - startTimeSort;
        System.out.println("Время сортировки методом sort, мс " + elapsedSort);
    }
}