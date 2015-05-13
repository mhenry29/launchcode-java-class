import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by melissa on 5/11/15.
 */
public class SortStrategyTest extends TestCase {

    @Test
    public void testSort() {
        Integer[] sortArray = {9, 4, 2, 6, 9, 7};
        SortStrategy s = new BubbleSort(sortArray);
        Integer[] sortedArray =   {2, 4, 6, 7, 9, 9};
        Integer[] anotherSorted = {2, 4, 6, 7, 9, 9};
        assertEquals(sortArray, anotherSorted);
        Integer[] actual = s.sort();
       // assertEquals(sortedArray, actual);


    }
}
