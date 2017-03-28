import java.util.List;
import java.util.*;

public class GraphProblems {

    public static boolean connected(Graph g, int v, int u) {
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        bfs.offer(v);
        visited.add(v);
        int current;
        while(!bfs.isEmpty()){
            current = bfs.poll();
            if(current == u){
                return true;
            }
            else{
                for(int node: g.getNeighbors(current)){
                    if(!visited.contains(node)){
                        visited.add(node);
                        bfs.offer(node);
                    }
                }
            }
        }
        return false;
    }

    public static List<Integer> topologicalOrder(Digraph g) {
        List<Integer> toposorted = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> vertices = g.vertices();
        int index = 0;
        while(visited.size() < g.numVertices()){
            int start = vertices.get(index);
            Object[] thing = DFStopo(g, start, toposorted, visited);
            toposorted = (List)thing[0];
            visited = (HashSet<Integer>) thing[1];
            index++;
        }
        return toposorted;
    }

    public static Object[] DFStopo(Digraph g, int node, List<Integer> tracker, HashSet<Integer> visited) {
        if(!visited.contains(node)){
            visited.add(node);
            for(int neighbor: g.getNeighbors(node)) {
                if(!visited.contains(neighbor)) {
                    DFStopo(g, neighbor, tracker, visited);
                }
            }
            tracker.add(0, node);


        }
        return new Object[]{tracker, visited};

    }


    public static boolean hasCycle(UndirectedGraph g) {
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> vertices = g.vertices();
        boolean cyclic = false;
        int index = 0;
        while(visited.size() < g.numVertices()){
            int start = vertices.get(index);
            cyclic = DFScycle(g, -1, start, visited, cyclic);
            index++;
        }
        return cyclic;

    }
    public static boolean DFScycle(Digraph g, int previousnode, int node, HashSet<Integer> visited, boolean cyclic) {
//        Object[] thing = new Object[2];
        if(visited.contains(node)) {
            cyclic = true;
            return cyclic;
        }
        else{

            visited.add(node);
            for(int neighbor: g.getNeighbors(node)) {
                if(neighbor != previousnode)
                    cyclic = DFScycle(g, node, neighbor, visited, cyclic);


            }


        }
        return cyclic;

    }

}