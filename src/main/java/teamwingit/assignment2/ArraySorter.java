package teamwingit.assignment2;

import java.util.Comparator;

public class ArraySorter<T extends Comparable<T>> implements IArraySorter<T> {

    private T[] items;
    private boolean sortedAscending = true;

    public ArraySorter(T[] items) {
        this.items = items;
    }

    @Override
    public void enqueue(T item) {
        expand();
        this.items[items.length - 1] = item;
        if (sortedAscending)
            sortAscending();
        else 
            sortDescending();
    }

    @Override
    public T dequeue() {
        T item = this.items[0];
        this.items[0] = null;
        shrink();
        if (sortedAscending)
            sortAscending();
        else 
            sortDescending();
        return item;
    }

    @Override
    public void sortAscending() {
        sort((a, b) -> a.compareTo(b));
        sortedAscending = true;
    }

    @Override
    public void sortDescending() {
        sort((a, b) -> b.compareTo(a));
        sortedAscending = false;
    }

    @Override
    public void sort(Comparator<T> comparator) {

        // HEAP Sort logic needs to impl comparator for asc or desc logic.
        int n = this.items.length;

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(this.items, n, i, comparator);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            T temp = this.items[0];
            this.items[0] = this.items[i];
            this.items[i] = temp;

            // call max heapify on the reduced heap 
            heapify(this.items, i, 0, comparator);
        }
    }

    public void resize(int direction) {
        T[] newArray = (T[]) new Comparable[this.items.length + direction];
        
        for (int i = 1, j = 0; i < this.items.length; i++, j++) {
            if (this.items[i] != null) {
                newArray[j] = this.items[i];
            }
        }
        this.items = newArray;
    }
    public void expand() {
        T[] newArray = (T[]) new Comparable[this.items.length + 1];
        
        for (int i = 0; i < this.items.length; i++) {
                newArray[i] = this.items[i];
        }
        this.items = newArray;
    }
    
    public void shrink() {
        T[] newArray = (T[]) new Comparable[this.items.length - 1];
        
        for (int i = 1; i < this.items.length; i++) {
            if (this.items[i] != null) {
                newArray[i-1] = this.items[i];
            }
        }
        this.items = newArray;
    }

    @Override
    public String toString() {
        String s = "";
        for (T item : items) {
            s += item.toString() + "\n";
        }
        return s;
    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    private void heapify(T[] arr, int n, int i, Comparator comparator) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && comparator.compare(arr[l], arr[largest]) > 0) {
            largest = l;
        }
        // If right child is larger than largest so far 
        if (r < n && comparator.compare(arr[r], arr[largest]) > 0) {
            largest = r;
        }
        // If largest is not root 
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest, comparator);
        }
    }

    public T[] getItems() {
        return items;
    }
    
}
