package ru.geekbrains.lessons;

public class MainApp {
    public static void main(String[] args)
    {
        testStack();
        testDeque();
        testPriorityQueue();
    }

    static void testStack()
    {
        String text = "А роза упала на лапу Азора";

        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        String inverse = "";
        while (!stack.isEmpty()) {
            inverse += stack.pop();
        }
        System.out.println("Переворот строки: " + inverse);
    }

    static void testDeque()
    {
        MyDeque<Integer> deque = new MyDeque<Integer>(5);
        deque.insertRight(1);
        System.out.println(deque.toString());
        deque.insertRight(2);
        System.out.println(deque.toString());
        deque.insertRight(3);
        System.out.println(deque.toString());
        deque.removeLeft();
        System.out.println(deque.toString());
        deque.removeLeft();
        System.out.println(deque.toString());
        deque.insertLeft(5);
        System.out.println(deque.toString());
        deque.insertLeft(6);
        System.out.println(deque.toString());
        deque.insertLeft(7);
        System.out.println(deque.toString());
        deque.removeRight();
        System.out.println(deque.toString());
        deque.insertLeft(8);
        System.out.println(deque.toString());
        deque.insertRight(9);
        System.out.println(deque.toString());
        deque.insertRight(0);
        System.out.println(deque.toString());
    }

    static void testPriorityQueue()
    {
        System.out.println();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.insert(4);
        queue.insert(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(8);
        queue.insert(6);
        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());
        queue.insert(7);
        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());
    }
}
