package mylinkedlist;

public class MyLinkedListTest {
        public static void main(String[] args) {
            MyLinkedList<Integer> testList = new MyLinkedList();
            testList.add(1);
            testList.add(2);
            testList.add(3);
            testList.add(4);
            testList.add(5);
            testList.add(6);
            testList.add(7);
            testList.add(8);
            System.out.println("List size: " + testList.size());
            System.out.println(testList.get(6));
            testList.clear();
            System.out.println("List size: " + testList.size());
            System.out.println("_____________");

            MyLinkedList<String> testList1 = new MyLinkedList();
            testList1.add("First value");
            testList1.add("Second value");
            testList1.add("Third value");
            testList1.add("Fourth value");
            System.out.println(testList1.get(1));
            System.out.println("List size: " + testList1.size());
            testList1.remove(1);
            System.out.println("List size: " + testList1.size());
            System.out.println(testList1.get(1));
        }
}
