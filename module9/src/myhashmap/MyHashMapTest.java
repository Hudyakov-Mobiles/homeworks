package myhashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        hashMap.put(4, "four");
        hashMap.put(5, "five");
        hashMap.put(6, "six");
        hashMap.put(7, "seven");
        System.out.println("HashMap size: " + hashMap.size());
        System.out.println(hashMap.get(6));
        hashMap.put(6, "fert");
        hashMap.put(6, "66666");
        System.out.println(hashMap.get(6));
        hashMap.remove(1);
        System.out.println("HashMap size: " + hashMap.size());
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println("HashMap size: " + hashMap.size());
        hashMap.put(8, "888");
        hashMap.put(9, "999");
        hashMap.put(10, "1010101");
        hashMap.put(11, "1111111");
        hashMap.put(12, "1212121");
        hashMap.put(13, "131313");
        hashMap.put(14, "141414");
        hashMap.put(15, "151515");
        hashMap.put(16, "161616");
        hashMap.put(1, "12222");
        hashMap.put(2, "4444");
        System.out.println("HashMap size: " + hashMap.size());
        hashMap.clear();
        System.out.println("HashMap size: " + hashMap.size());
    }
}
