import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CityBFSclean {
    static int gasoline;
    static Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    static int start;
    static int finish;
    static ArrayList<String> coords = new ArrayList<>();
    static LinkedList queue;
    static int[] steps;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
            map.put(i,new LinkedList<>());
            coords.add(reader.readLine());
        }

        gasoline = Integer.parseInt(reader.readLine());
        String startEndPoints = reader.readLine();
        start = Integer.parseInt(startEndPoints.split(" ")[0]);
        finish = Integer.parseInt(startEndPoints.split(" ")[1]);

        for (Map.Entry entry : map.entrySet())
            route((int) entry.getKey());

        visited = new boolean[n];
        steps = new int[n];
        queue = new LinkedList<Integer>();

        int result = findWay();
        if(result == -1)
            System.out.println(result);
        else
            System.out.println(steps[finish-1]);
    }

    public static void route(int city) {
        for (int i = city - 1; i < coords.size() - 1; i++) {
            int startX = Integer.parseInt(coords.get(city - 1).split(" ")[0]);
            ;
            int startY = Integer.parseInt(coords.get(city - 1).split(" ")[1]);
            ;
            int x = Integer.parseInt(coords.get(i + 1).split(" ")[0]);
            int y = Integer.parseInt(coords.get(i + 1).split(" ")[1]);
            if (Math.abs(x - startX) + Math.abs(y - startY) <= gasoline && i + 2 != city) {
                map.get(city).add(i + 2);
                map.get(i + 2).add(city);
            }
        }
    }

    public static int findWay() {

        int pick;
        boolean found = false;

        for (int i = start; i <= map.size(); ) {
            visited[i - 1] = true;
            for (int j = 0; j < map.get(i).size(); j++) {
                pick = map.get(i).get(j);

                if (pick == finish)
                    found = true;

                if (!queue.contains(pick) && !visited[pick - 1]) {
                    steps[pick-1] = steps[i-1] + 1;
                    queue.add(pick);
                }
            }
            if (!queue.isEmpty())
                i = (int) queue.poll();
            else
                i++;

            if (found) {
                return 1;
            }
        }
        return -1;
    }
}