package myhashmap;

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
    private Node<K, V> prevNode;

    public MyHashMap() {
        this.nodeCounter = 0;
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
            nodeCounter++;
        }
        if (nodeCounter == 1){
            if (key == firstNode.key) firstNode.value = value;
            else {
                prevNode = new Node<K, V>(key, value, null);
                nodeCounter++;
                firstNode.next = prevNode;
            }
        }
        if (getNode(key) != null) {
            getNode(key).value = value;
        }
        else {
            nextNode = new Node<K, V>(key, value, null);
            prevNode.next = nextNode;
            prevNode = nextNode;
            nodeCounter++;
        }
    }

    public void remove(K key) {
        if (getNode(key) == null) {
            throw new NullPointerException("Key not found!");
        }
        if (key == firstNode.key){
            firstNode = firstNode.next;
        }
        else {
            Node<K, V> prevNode = firstNode;
            Node<K, V> currentNode = firstNode;
            for (int i = 0; i < nodeCounter; i++) {
                if (currentNode.key == key) prevNode.next = currentNode.next;
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        nodeCounter--;
    }

    public void clear() {
        this.nodeCounter = 0;
        this.firstNode = null;
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
        Node<K, V> currentNode = firstNode;
        for (int i = 0; i < nodeCounter; i++) {
            if (currentNode.key == key) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}
