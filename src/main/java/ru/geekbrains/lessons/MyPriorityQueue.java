package ru.geekbrains.lessons;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void insert(T item) {
        if (size == list.length) {
            reCapacity((int)(size * 1.5));
        }
        list[size] = item;
        size++;
    }

    public T remove() {

        int iMin = 0;
        T min = list[iMin];
        for (int i = 1; i < size; i++) {
            if (list[i].compareTo(min) < 0) {
                iMin = i;
                min = list[iMin];
            }
        }
        T last = peek();
        list[iMin] = last;
        size--;
        list[size] = null;
        return min;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
