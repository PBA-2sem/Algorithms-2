package teamwingit.assignment2;

import java.util.Comparator;

/**
 * This is an interface for ArraySorter.
 *
 * @param <T>
 */
public interface IArraySorter<T> {

    public void enqueue(T item);

    public T dequeue();

    public void sortAscending();

    public void sortDescending();

    public void sort(Comparator<T> comparator);
}
