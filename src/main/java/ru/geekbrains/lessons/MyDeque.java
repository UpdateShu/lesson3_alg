package ru.geekbrains.lessons;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 5;
    private int begin;
    private int end;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T item) {
        if (size == list.length)
            reCapacity();
        size++;
        list[end] = item;
        end = nextRight(end);
    }

    public void insertLeft(T item) {
        if (size == list.length)
            reCapacity();
        size++;
        begin = nextLeft(begin);
        list[begin] = item;
    }

    void reCapacity()
    {
        if (size == list.length)
        {
            int newSize = (int)(size * 1.5);
            int displace = newSize - size;
            T[] listNew =(T[]) new Object[newSize];
            if (begin >= end) {
                System.arraycopy(list, begin, listNew, begin + displace, list.length - begin);
                System.arraycopy(list, 0, listNew, 0, end);
                begin += displace;
            }
            else {
                System.arraycopy(list, begin, listNew, begin, begin + size);
            }
            list = listNew;
        }
    }

    public T removeLeft() {
        T temp = peekFrontLeft();
        list[begin] = null;
        begin = nextRight(begin);
        size--;
        return temp;
    }

    public T removeRight() {
        T temp = peekFrontRight();
        int endIndex = nextLeft(end);
        list[endIndex] = null;
        end = endIndex;
        size--;
        return temp;
    }

    public T peekFrontLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return list[begin];
    }

    public T peekFrontRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return list[nextLeft(end)];
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

    private int nextRight(int index) {
        return (index + 1) % list.length;
    }

    private int nextLeft(int index) {
        return (list.length + index - 1) % list.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        int i = begin;
        StringBuilder cap = new StringBuilder("\n ");
        StringBuilder sb = new StringBuilder("[");
        for (int j = 0; j < list.length; j++) {
            cap.append(j + " ");
            sb.append((list[j] != null ? list[j] : "-") + " ");
        }
        /*do {
            i = nextIndex(i);
        }
        while (i != end);*/
        sb.append("]");
        cap.append("\n" + sb.toString() + " begin = " + begin + " end = " + end);
        return cap.toString();
    }
}
