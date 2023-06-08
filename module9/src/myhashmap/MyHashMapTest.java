package myhashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap();
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
        System.out.println(hashMap.get(6));
        hashMap.remove(6);
        System.out.println("HashMap size: " + hashMap.size());
        hashMap.put(6, "yeyey");
        hashMap.put(6, "ssS");
        System.out.println(hashMap.get(6));
        System.out.println("HashMap size: " + hashMap.size());
        hashMap.clear();
        System.out.println("HashMap size: " + hashMap.size());
        System.out.println("_____________");

        MyHashMap<String, Integer> hashMap1 = new MyHashMap();
        hashMap1.put("1one", 1);
        hashMap1.put("2two", 2);
        hashMap1.put("3three", 3);
        System.out.println("HashMap size: " + hashMap1.size());
        System.out.println(hashMap1.get("2two"));
        hashMap1.remove("2two");
        System.out.println("HashMap size: " + hashMap1.size());
    }
}
