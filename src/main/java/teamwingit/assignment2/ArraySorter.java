package teamwingit.assignment2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySorter<T> implements IArraySorter<T> {

    private T[] items;
    private int size;

    public ArraySorter(T[] items, int size) {
        this.items = items;
        this.size = size;
    }

    @Override
    public void enqueue(T item) {
        resize(1);
        this.items[this.items.length - 1] = item;
    }

    @Override
    public T dequeue() {
        T item = this.items[0];
        this.items[0] = null;
        resize(-1);
        return item;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(this.items);
        System.out.println(this.items);
    }

    @Override
    public void sortDescending() {
        Arrays.sort(this.items, Collections.reverseOrder());
        System.out.println(this.items);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort(this.items, comparator);
        System.out.println(this.items);
    }

    public void resize(int direction) {
        T[] newArray = (T[]) new Object[this.items.length + direction];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                newArray[i] = this.items[i];
            }
        }
        this.items = newArray;
    }

    @Override
    public String toString() {
        return "ArraySorter{" + "items=" + items + ", size=" + size + '}';
    }

}
