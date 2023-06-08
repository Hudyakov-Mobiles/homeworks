package myqueue;

import java.util.Arrays;

//        Написать свой класс MyQueue как аналог классу Queue, который будет
//        работать по принципу FIFO (first-in-first-out).
//
//        Можно делать либо с помощью Node либо с помощью массива.
//
//        Методы
//
//        add(Object value) добавляет элемент в конец
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        peek() возвращает первый элемент в очереди (FIFO)
//        poll() возвращает первый элемент в очереди и удаляет его из коллекции
public class MyQueue<T> {
    private int capacity;
    private int elementCount;
    private Object[] dataArray;

    public MyQueue() {
        this.capacity = 10;
        this.dataArray = new Object[capacity];
        this.elementCount = 0;
    }

    public void add(Object value) {
        if (capacity <= elementCount) {
            capacity = capacity + capacity/2;
            Object[] buffArray = new Object[capacity];
            for (int i = 0; i < elementCount; i++) {
                buffArray[i] = dataArray[i];
            }
            dataArray = Arrays.copyOf(buffArray, buffArray.length);
        }
        dataArray[elementCount] = value;
        elementCount++;
    }

    public void clear() {
        this.capacity = 10;
        this.dataArray = new Object[capacity];
        this.elementCount = 0;
    }

    public int size() {
        return elementCount;
    }

    public Object peek() {
        return dataArray[0];
    }

    public Object poll() {
        Object element = dataArray[0];
        elementCount--;
        for (int i = 0; i < elementCount; i++) {
            dataArray[i] = dataArray[i + 1];
        }
        return element;
    }
}
