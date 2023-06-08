package mystack;

import java.util.Arrays;

public class MyStack<T> {
//    Написать свой класс MyStack как аналог классу Stack,
//    который работает по принципу LIFO (last-in-first-out).
//    Можно делать либо с помощью Node либо с помощью массива.
//
//    Методы:
//
//    push(Object value) добавляет элемент в конец
//    remove(int index) удаляет элемент под индексом
//    clear() очищает коллекцию
//    size() возвращает размер коллекции
//    peek() возвращает первый элемент в стеке (LIFO)
//    pop() возвращает первый элемент в стеке и удаляет его из коллекции
        private int capacity;
        private int elementCount;
        private Object[] dataArray;
        public MyStack() {
            this.capacity = 10;
            this.dataArray = new Object[capacity];
            this.elementCount = 0;
        }

        public void push(Object value) {
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
        public void remove(int index) {
            for (int i = index; i < dataArray.length-1; i++) {
                dataArray[i] = dataArray[i+1];
            }
            dataArray[dataArray.length-1] = null;
            elementCount--;
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
            return dataArray[elementCount-1];
        }

        public Object pop() {
            Object element = dataArray[elementCount-1];
            elementCount--;
            return element;
        }
}
