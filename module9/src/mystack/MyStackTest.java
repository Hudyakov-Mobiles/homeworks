package mystack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        System.out.println("Stack size: " + testStack.size());
        System.out.println(testStack.peek());
        System.out.println(testStack.pop());
        System.out.println("Stack size: " + testStack.size());
        testStack.push(31);
        System.out.println("Stack size: " + testStack.size());
        System.out.println(testStack.peek());
        testStack.remove(3);
        System.out.println(testStack.peek());
        System.out.println("Stack size: " + testStack.size());
        testStack.clear();
        System.out.println("Stack size: " + testStack.size());
    }
}
