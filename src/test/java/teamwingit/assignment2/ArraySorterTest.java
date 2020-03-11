/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamwingit.assignment2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stanislavnovitski
 */
public class ArraySorterTest {

    Integer[] arr;

    public ArraySorterTest() {
        this.arr = new Integer[]{10, 14, 19, 26, 31, 42, 27, 44, 35, 33};
    }

    /**
     * Test of enqueue method, of class ArraySorter.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Integer item = 30;
        ArraySorter instance = new ArraySorter(this.arr);
        System.out.println("LENGTH:" + instance.getItems().length);
        instance.enqueue(item);
        System.out.println("LENGTH:" + instance.getItems().length);
        assertTrue(instance.getItems()[5].equals(30));
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(instance.toString());
    }

    /**
     * Test of dequeue method, of class ArraySorter.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        ArraySorter instance = new ArraySorter(this.arr);
        Integer result = (Integer) instance.dequeue();
        assertTrue(10 == result);
        assertTrue(instance.getItems().length == 9);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sortAscending method, of class ArraySorter.
     */
    @Test
    public void testSortAscending() {
        System.out.println("sortAscending");
        ArraySorter instance = new ArraySorter(this.arr);
        instance.sortAscending();
        assertTrue(isSortedAscending(instance.getItems()));
    }

    /**
     * Test of sortDescending method, of class ArraySorter.
     */
    @Test
    public void testSortDescending() {
        System.out.println("sortDescending");
        ArraySorter instance = new ArraySorter(this.arr);
        instance.sortDescending();
        assertTrue(isSortedDescending(instance.getItems()));
    }

    /**
     * Test of sort method, of class ArraySorter.
     */
    //@Test
    public void testSort() {
        System.out.println("sort");
        ArraySorter instance = new ArraySorter(this.arr);
        instance.sortAscending();
        System.out.println(instance.toString());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ArraySorter.
     */
//    @Test
    public void testToString() {
        System.out.println("toString");
        ArraySorter instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private boolean isSortedAscending(Comparable[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSortedDescending(Comparable[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }
    
}
