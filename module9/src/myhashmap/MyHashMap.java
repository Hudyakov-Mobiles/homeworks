package myhashmap;

import java.util.Arrays;

public class MyHashMap<K, V>{
    //    Написати свій клас MyHashMap як аналог класу HashMap.
//    Потрібно робити за допомогою однозв'язної Node.
//    Не може зберігати дві ноди з однаковими ключами.
//
//    Методи
//
//    put(Object key, Object value) додає пару ключ + значення
//    remove(Object key) видаляє пару за ключем
//    clear() очищає колекцію
//    size() повертає розмір колекції
//    get(Object key) повертає значення (Object value) за ключем
    private int nodeCounter;
    private Node<K, V> firstNode;
    private Node<K, V> nextNode;

    private Node<K, V>[] nodeArray;
    private int capacity = 10;

    public MyHashMap() {
        this.nodeCounter = 0;
        nodeArray = new Node[capacity];
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> next;

        public Node(K key,V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key, V value) {
            this(key, value, null);
        }
    }

    public void put(K key, V value){
        if (nodeCounter == 0) {
            firstNode = new Node(key, value);
            nodeArray[0] = firstNode;
            nodeCounter++;
        }
        if (getNode(key) != null) {
            getNode(key).value = value;
        }
        else {
            if (nodeCounter >= capacity) {
                capacity = capacity + capacity/2;
                Node<K, V>[] tempArray = new Node[capacity];
                for (int i = 0; i < nodeCounter; i++){
                    tempArray[i] = nodeArray[i];
                }
                nodeArray = Arrays.copyOf(tempArray, tempArray.length);
            }
            nextNode = new Node<K, V>(key, value, null);
            nodeArray[nodeCounter - 1].next = nextNode;
            nodeArray[nodeCounter] = nextNode;
            nodeCounter++;
        }
    }

    public void remove(K key) {
        if (getNode(key) == null) {
            throw new NullPointerException("Key not found!");
        }
        Node<K, V> currentNode;
        for (int i = 0; i < nodeCounter; i++) {
            currentNode = nodeArray[i];
            if (currentNode.key == key) {
                for (int j = i; j < nodeCounter - 1; j++) {
                    nodeArray[j] = nodeArray[j + 1];
                }
                nodeArray[nodeCounter - 1] = null;
                nodeCounter--;
            }
        }
    }

    public void clear() {
        this.nodeCounter = 0;
        this.nodeArray[0] = null;
    }

    public int size() {
        return nodeCounter;
    }

    public V get(K key) {
        if (getNode(key) == null) {
            throw new NullPointerException("Key not found!");
        }
        return getNode(key).value;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> currentNode;
        for (int i = 0; i < nodeCounter; i++) {
            currentNode = nodeArray[i];
            if (currentNode.key == key) return currentNode;
        }
        return null;
    }
}
