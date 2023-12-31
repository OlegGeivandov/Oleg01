import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{25, 34, 8, 30, 64, 7, 95, 48, 14, 75, 16};
        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    // left и right – индексы подмассивов для сортировки, крайние слева и справа
    // Изначально они имеют значения 0 и array.length-1
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return; // выход из рекурсии
        int mid = (left+right)/2; // средний индекс
        mergeSort(array, left, mid); // рекурсивное обращение к левому подмассиву
        mergeSort(array, mid+1, right); // рекурсивное обращение к правому подмассиву
        merge(array, left, mid, right);
    }

    static void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}