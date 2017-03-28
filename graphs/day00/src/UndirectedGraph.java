import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class UndirectedGraph implements Graph {
    public HashMap<Integer, LinkedList<Integer>> graph;
    int totalEdges;
    int totalVertices;
    public UndirectedGraph(int n) {
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<Integer>());
        }
        totalEdges = 0;
        totalVertices = n;
    }

    // Runtime complexity O(1)
    @Override
    public void addEdge(int v, int w) {
        LinkedList<Integer> temp1 = graph.get(v);
        temp1.add(w);
        LinkedList<Integer> temp2 = graph.get(w);
        temp2.add(v);
        totalEdges ++;
    }


    // Runtime complexity O(1)
    @Override
    public List<Integer> vertices() {
    	return new ArrayList<Integer>(graph.keySet());
    }

    // Runtime complexity O(1)
    @Override
    public int numVertices() {
        return totalVertices;
    }

    // Runtime complexity O(1)
    @Override
    public int numEdges() {
        return totalEdges;
    }

    // Runtime complexity O(1)
    @Override
    public Iterable<Integer> getNeighbors(int v) {
        return graph.get(v);
    }

    // Runtime complexity O(E/V)
    @Override
    public boolean hasEdgeBetween(int v, int w) {
        LinkedList<Integer> temp = graph.get(v);
        for(int item: temp){
            if(item == w){
                return true;
            }
        }
        return false;
    }

}
