package mylinkedlist;

//        add(Object value) добавляет элемент в конец
//        remove(int index) удаляет элемент под индексом
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(int index) возвращает элемент под индексом

public class MyLinkedList<T> {
    private int nodeCounter;
    private Node<T> firstNode;
    private Node<T> nextNode;
    private Node<T> prevNode;

    public MyLinkedList() {

    }

    private static class Node<T> {
        Node<T> prev;
        private T element;
        Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
        public Node(T element) {
            this(null, element, null);
        }
    }

    public void add(T value) {
        if (nodeCounter == 0) {
            firstNode = new Node<T>(value);
        }
        else if (nodeCounter == 1){
            prevNode = new Node<T>(firstNode, value, null);
            firstNode.next = prevNode;
        }
        else {
            nextNode = new Node<T>(prevNode, value, null);
            prevNode.next = nextNode;
            prevNode = nextNode;
        }
        nodeCounter++;
    }

    public void remove(int index) {
        if (index < 0 || index >= nodeCounter) {
            throw new IndexOutOfBoundsException("IndexOutOfBounds!");
        }
        if (index == 0) firstNode = firstNode.next;
        else {
            prevNode = getNode(index - 1);
            nextNode = prevNode.next;
            prevNode.next = nextNode.next;
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

    public T get(int index) {
        if (index < 0 || index >= nodeCounter) {
            throw new IndexOutOfBoundsException("IndexOutOfBounds!");
        }
        Node<T> node = getNode(index);
        return node.element;
    }

    private Node<T> getNode(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
