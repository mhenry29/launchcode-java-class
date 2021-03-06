import java.util.Arrays;


/**
 * Created by melissa on 5/11/15.
 */
public class MergeSort implements SortStrategy {

    private Integer[] array;
    private Integer[] tempMergArr;
    private int length;

    public MergeSort (Integer toSort[]) {
        this.array = toSort;
        this.length = toSort.length;
        this.tempMergArr = new Integer[this.length];
    }

    public Integer[] sort() {

        doMergeSort(0, length - 1);
        return this.array;
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }

    public static void main(String args[]){

        Integer[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort ms = new MergeSort(inputArr);
        System.out.println("Merge Sorted: " + Arrays.toString(ms.sort()));

    }

}
