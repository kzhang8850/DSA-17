import java.util.*;

public class ShortestPath {

    public static List<Integer> shortestPath(Graph g, int v, int w) {
        Queue<Integer> BS = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        Map<Integer, Integer> prev = new HashMap<>();
        ArrayList<Integer> path = new ArrayList<>();
        int current = v;
        visited.add(v);
        BS.offer(v);

        while(!BS.isEmpty()){
            current = BS.poll();
            if (current == w){
                break;
            }else{
                for(int node : g.getNeighbors(current)){
                    if(!visited.contains(node)){
                        BS.add(node);
                        visited.add(node);
                        prev.put(node, current);
                    }
                }
            }
        }
        if (current != w){
            return null;
        }
        Integer node = w;
        while(node != null) {
            path.add(node);
            node = prev.get(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static int distanceBetween(Graph g, int v, int w) {
        Queue<Integer> BS = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        Map<Integer, Integer> prev = new HashMap<>();
        ArrayList<Integer> path = new ArrayList<>();
        int current = v;
        visited.add(v);
        BS.offer(v);

        while(!BS.isEmpty()){
            current = BS.poll();
            if (current == w){
                break;
            }else{
                for(int node : g.getNeighbors(current)){
                    if(!visited.contains(node)){
                        BS.add(node);
                        visited.add(node);
                        prev.put(node, current);
                    }
                }
            }
        }
        if (current != w){
            return -1;
        }
        Integer node = w;
        while(node != null) {
            path.add(node);
            node = prev.get(node);
        }
        Collections.reverse(path);
        return path.size()-1;

    }

}