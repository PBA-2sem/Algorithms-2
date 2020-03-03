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

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    private void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }

    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

}
