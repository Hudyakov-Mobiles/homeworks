package myrraylist;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> testList = new MyArrayList();

        MyArrayList<Boolean> testListBool = new MyArrayList(true);

        MyArrayList<String> testList1 = new MyArrayList("Hello!");
        System.out.println(testList1.size());

        for (int i = 0; i < 18; i++) {
            testList1.add("element " + i);
        }
        System.out.println(testList1);
        System.out.println(testList1.size());
        testList1.remove(5);
        System.out.println(testList1);
        System.out.println(testList1.size());

        System.out.println(testList1.get(0));
        testList1.clear();
        System.out.println(testList1.size());







    }
}
