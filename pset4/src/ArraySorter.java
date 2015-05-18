import com.sun.media.jfxmedia.events.BufferListener;
import sun.misc.Sort;

import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * Created by melissa on 5/11/15.
 */
public class ArraySorter {

    private SortStrategy strategy;

    public ArraySorter(SortStrategy s) {
        this.strategy = s;
    }

    public void sorted() {
        strategy.sort();
    }

    public static void main(String args[]) {
       int selection = 0;
       Integer[] a = {7, 2, 2, 8, 9};
       Integer[] b = {45,23,11,89,77,98,4,28,65,43};

       ArraySorter bs = new ArraySorter(new BubbleSort(b));
       ArraySorter ms = new ArraySorter(new MergeSort(b));

        // Using a factory to create our objects
       SortStrategy fbs = SortStrategyFactory.getBubbleSort(a);
       SortStrategy fms = SortStrategyFactory.getMergeSort(a);



        Scanner scanner = new Scanner(System.in);
        do  {
            System.out.print("\nEnter 1 to print output to Console, enter 2 to output to file: ");
            selection = Integer.parseInt(scanner.nextLine());
            } while (selection != 1 && selection != 2);
        scanner.close();

        PrintWriter writer = new PrintWriter(System.out);

        if (selection == 2) {
            try {
                writer = new PrintWriter("ArraySorter.txt");

            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }

        // time compare ms and bs
        long startTime1 = System.currentTimeMillis();
        bs.sorted();
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        ms.sorted();
        long endTime2 = System.currentTimeMillis();

        writer.write("BubbleSort: " + Arrays.toString(fbs.sort()) + "\tTime: " + (endTime1 - startTime1) + " milliseconds\n");
        writer.write("MergeSort Time: " + Arrays.toString(fms.sort()) + "\tTime: " + (endTime2 - startTime2) + " milliseconds\n");
        writer.close();

    }
}