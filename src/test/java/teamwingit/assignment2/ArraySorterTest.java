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
        instance.enqueue(item);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(instance.toString());
    }

    /**
     * Test of dequeue method, of class ArraySorter.
     */
//    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        ArraySorter instance = null;
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortAscending method, of class ArraySorter.
     */
//    @Test
    public void testSortAscending() {
        System.out.println("sortAscending");
        ArraySorter instance = null;
        instance.sortAscending();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortDescending method, of class ArraySorter.
     */
//    @Test
    public void testSortDescending() {
        System.out.println("sortDescending");
        ArraySorter instance = null;
        instance.sortDescending();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class ArraySorter.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        ArraySorter instance = new ArraySorter(this.arr);
        instance.sort(null);
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

}
