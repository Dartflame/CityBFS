import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class testData {
    static int gasoline;
    static Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    static int start;
    static int finish;
    static ArrayList<String> coords = new ArrayList<>();
    static LinkedList queue;
    static int[] steps;
    static boolean[] array;
    static int n = 13;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            map.put(i + 1, new LinkedList<>());
        }

        coords.add("0 0");
        coords.add("0 2");
        coords.add("2 2");
        coords.add("0 -2");
        coords.add("2 -2");
        coords.add("2 -1");
        coords.add("2 1");

        coords.add("4 -1");
        coords.add("5 0");
        coords.add("5 1");
        coords.add("5 3");
        coords.add("3 3");
        coords.add("7 4");


//        map.put(1,new LinkedList<>());
//        map.put(2,new LinkedList<>());
//        map.put(3,new LinkedList<>());
//        map.put(4,new LinkedList<>());
//
//        coords.add("0 0");
//        coords.add("1 0");
//        coords.add("0 1");
//        coords.add("1 1");
    }

}
