package ru.geekbrains.lessons;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 4;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item) {
        if (size == list.length)
        {
            int newSize = (int)(size * 1.5);
            T[] listNew =(T[]) new Object[newSize];
            System.arraycopy(list, 0, listNew, 0, list.length);
            list = listNew;
        }
        list[size] = item;
        size++;
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
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
}
