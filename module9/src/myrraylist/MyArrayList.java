package myrraylist;

import java.util.Arrays;

public class MyArrayList<T> {

//    add(Object value) добавляет элемент в конец
//    remove(int index) удаляет элемент под индексом
//    clear() очищает коллекцию
//    size() возвращает размер коллекции
//    get(int index) возвращает элемент под индексом

    private int capacity;
    private int elementCount;
    private final static Object[] EMPTY_ARR = {};
    private Object[] dataArray;

    public MyArrayList() {
        this.dataArray = EMPTY_ARR;
    }
    public MyArrayList(T element) {
        capacity = 10;
        this.dataArray = new Object[capacity];
        dataArray[0] = element;
        elementCount = 1;
    }

    public void add(T value) {
        if (elementCount < capacity) {
            dataArray[elementCount] = value;
        }
        else {
            capacity = capacity + 5;
            Object[] buffArray = new Object[capacity];
            for (int i = 0; i < elementCount; i++) {
                buffArray[i] = dataArray[i];
            }
            buffArray[elementCount] = value;
            dataArray = Arrays.copyOf(buffArray, buffArray.length);
        }
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
        dataArray = null;
        capacity = 10;
        elementCount = 0;
    }

    public int size() {
        return elementCount;
    }

    public Object get(int index) {
        return dataArray[index];
    }

    @Override
    public String toString() {
        return "Data Array: " + Arrays.toString(dataArray);
    }
}
