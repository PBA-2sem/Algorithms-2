/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySorter<T> {
    
    T[] items;
    int size;

    public ArraySorter(T[] items, int size) {
        this.items = items;
        this.size = size;
    }

    public void enqueue(T item) {
        resize(1);
        this.items[this.items.length - 1] = item;
    }

    public T dequeue() {
        T item = this.items[0];
        this.items[0] = null;
        resize(-1);
        return item;
    }

    public void sortAscending() {
        Arrays.sort(this.items);
        System.out.println(this.items);
    }

    public void sortDescending() {
        Arrays.sort(this.items, Collections.reverseOrder());
        System.out.println(this.items);
    }

    public void sort(Comparator<T> comparator) {
        Arrays.sort(this.items, comparator);
        System.out.println(this.items);
    }
    
    public void resize(int direction) {
        T[] newArray = (T[])new Object[this.items.length + direction];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null)
                newArray[i] = this.items[i];
        }
        this.items = newArray;
    }
}
