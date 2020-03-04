/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamwingit.assignment2;

import java.util.Arrays;
import java.util.Comparator;
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
    public void testEnqueue30() {
        System.out.println("enqueue30");
        Integer item = 30;
        ArraySorter instance = new ArraySorter(this.arr);
        instance.enqueue(item);
        assertTrue(instance.getItems()[5].equals(30));
    }

    /**
     * Test of dequeue method, of class ArraySorter.
     */
    @Test
    public void testDequeue10() {
        System.out.println("dequeue10");
        ArraySorter instance = new ArraySorter(this.arr);
        Integer result = (Integer) instance.dequeue();
        assertTrue(10 == result);
        assertTrue(instance.getItems().length == 9);
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
    @Test
    public void testSortOfCharacterWithCustomComparator() {
        System.out.println("sortCharacterWithCustomComparator");
        Comparable[] studentArr = new Comparable[3];
        studentArr[0] = (Comparable) new Student(2, "Mathias", "address2");
        studentArr[1] = (Comparable) new Student(3, "Alexander", "address3");
        studentArr[2] = (Comparable) new Student(1, "Stanislav", "address1");
        ArraySorter instance = new ArraySorter(studentArr);
        instance.sort(new StudentComparator());
//        assertTrue(isSortedAscending(instance.getItems()));
        System.out.println(instance.toString());

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Helper method to return true if Comparable[] is sorted in ascending
     * order.
     *
     * @param array
     * @return
     */
    private boolean isSortedAscending(Comparable[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to return true if Comparable[] is sorted in descending
     * order.
     *
     * @param array
     * @return
     */
    private boolean isSortedDescending(Comparable[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    //https://www.geeksforgeeks.org/comparator-interface-java/
    class Student implements Comparable<Student> {

        int rollno;
        String name, address;

        // Constructor 
        public Student(int rollno, String name,
                String address) {
            this.rollno = rollno;
            this.name = name;
            this.address = address;
        }

        // Used to print student details in main() 
        @Override
        public String toString() {
            return this.rollno + " " + this.name
                    + " " + this.address;
        }

        @Override
        public int compareTo(Student t) {
            return Math.min(this.rollno, t.rollno);
        }

    }

    /**
     * Comparator for Student class
     */
    class StudentComparator implements Comparator<Student> {

        /**
         * Should return the lowest roll number
         * @param t
         * @param t1
         * @return 
         */
        @Override
        public int compare(Student t, Student t1) {
            return Math.min(t.rollno, t1.rollno);
        }
    }
}
