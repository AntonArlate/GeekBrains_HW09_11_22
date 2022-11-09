import java.util.Arrays;

// Реализовать алгоритм быстрой сортировки

/*
**Быстрая** - (обязательна рекурсия). Делим массив пополам (нечёт с любым сдвигом). Запоминаем середину как ik и уровень L. 

Ищем слева значение <= L

Затем ищем справа значение >= L

Меняем значения местами, повторяем поиск.

Далее повторяем деление рекурсивно для обеих частей i0-ik и ik-iend

 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 13, 3, 16, 1, 20, 11, 17, 15, 10}; 
        int iStart = 0;
        int iEnd = arr.length-1;

        System.out.println(Arrays.toString(arr));
        QSort(arr, iStart, iEnd);
        System.out.println(Arrays.toString(arr));
    }

    public static void QSort (int[] arr, int iStart, int iEnd) {
        
        // Делим массив пополам (нечёт с любым сдвигом). Запоминаем середину как ik и уровень L. 
        int indexK;
        if (iStart < iEnd) indexK = (iEnd+iStart) / 2;
        else return;
        int pivot = arr[indexK];
        int indexLeft = iStart;
        int indexRight = iEnd;

        while (true) {   
            //Ищем слева значение >= L
            while (arr[indexLeft] < pivot) {
                indexLeft += 1;            
            }
            //Затем ищем справа значение <= L
            while (arr[indexRight] > pivot) {
                indexRight -= 1;            
            }
            //Меняем значения местами, повторяем поиск.
            if (indexLeft >= indexRight) { // если указатели пересеклись, то выходим
                break;
            }
            swap(arr, indexLeft, indexRight);
        }
        //Далее повторяем деление рекурсивно для обеих частей i0 - ir и ir+1 - iend
        QSort(arr, iStart, indexRight);
        QSort(arr, indexRight+1, iEnd);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // System.out.println(Arrays.toString(arr));
    }
}

    