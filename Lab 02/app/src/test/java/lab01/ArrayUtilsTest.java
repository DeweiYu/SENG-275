package lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // A sorted array - all at once
    @Test
    void sorted() {
        assertTrue(ArrayUtils.isSorted(new int[] {1,2,3,4}));
    }

    // Empty arrays are sorted
    @Test
    void sortEmpty() {
        int[] someArray = {};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // Arrays of one element are sorted
    @Test
    void oneElement() {
        int[] someArray = {1};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }
    // A partially sorted array
     @Test
     void partialSortedA(){
         int[] someArray = {1,2,3,5,4,6};       // arrange
         boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
         assertFalse(someArraySorted);
     }
    // A completely unsorted array
    @Test
    void completedUnSortedA(){
        int[] someArray = {1,4,2,6,3};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertFalse(someArraySorted);
    }
    // An array with duplicate values
    @Test
    void duplicateValue(){
        int[] someArray = {1,1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);
    }
}



