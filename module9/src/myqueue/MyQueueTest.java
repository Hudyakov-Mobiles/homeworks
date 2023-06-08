package myqueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> testQueue = new MyQueue<>();
        testQueue.add(1);
        testQueue.add(2);
        testQueue.add(3);
        testQueue.add(4);
        testQueue.add(5);
        testQueue.add(6);
        testQueue.add(7);
        testQueue.add(8);
        System.out.println("Queue size: " + testQueue.size());
        System.out.println(testQueue.peek());
        System.out.println(testQueue.poll());
        System.out.println("Queue size: " + testQueue.size());
        System.out.println(testQueue.poll());
        System.out.println("Queue size: " + testQueue.size());
        testQueue.add(9);
        testQueue.add(10);
        testQueue.add(11);
        testQueue.add(12);
        testQueue.add(13);
        testQueue.add(14);
        testQueue.add(15);
        testQueue.add(16);
        System.out.println("Queue size: " + testQueue.size());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        testQueue.clear();
        System.out.println("Queue size: " + testQueue.size());
        System.out.println("_____________");

        MyQueue<String> testQueue1 = new MyQueue<>();
        testQueue1.add("1");
        testQueue1.add("2");
        testQueue1.add("3");
        testQueue1.add("4");
        testQueue1.add("5");
        testQueue1.add("6");
        testQueue1.add("7");
        System.out.println("Queue size: " + testQueue1.size());
        System.out.println(testQueue1.peek());
        System.out.println(testQueue1.poll());
        System.out.println("Queue size: " + testQueue1.size());
        System.out.println(testQueue1.poll());
        System.out.println(testQueue1.poll());
        System.out.println("Queue size: " + testQueue1.size());


    }
}
