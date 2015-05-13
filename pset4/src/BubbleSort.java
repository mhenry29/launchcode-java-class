import sun.misc.Sort;

import java.util.Arrays;

/**
 * Created by melissa on 5/11/15.
 */
public class BubbleSort implements SortStrategy {

    private Integer array[];

    public BubbleSort(Integer toSort[]) {
        this.array = toSort;
    }

    public Integer[] sort() {
        // cycle through array n-1 time
        // s bc we don't compare 1st one to self
        int swaps;

        for (int k = 0; k < this.array.length - 1; k++) {
            do {
                // reset swap counter
                swaps = 0;

                // optimize sort be decrementing k which is how many elements that are already sorted
                for (int i = 0; i < this.array.length - 1 - k; i++) {
                    //check if adjacent elements are in order
                    if (this.array[i] > this.array[i + 1]) {
                        int temp = this.array[i + 1];
                        this.array[i + 1] = this.array[i];
                        this.array[i] = temp;
                        swaps++;
                    }
                }
            } while (swaps > 0);
        }
        return this.array;
    }

    public static void main(String args[]) {
        Integer[] a = {7, 2, 2, 8, 9};
        BubbleSort bs = new BubbleSort(a);
        System.out.println("Bubble Sorted: " + Arrays.toString(bs.sort()));
    }
}

