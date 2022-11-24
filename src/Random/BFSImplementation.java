import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class BFSImplementation {

    int V;

    ArrayList<Integer> adj[];
    BFSImplementation(int noOfvertex){
        V = noOfvertex;
        adj = new ArrayList[noOfvertex];
        for (int i = 0; i < noOfvertex ; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    void edge(int x, int y){
        adj[x].add(y);
    }

    void breathFirstSearch(int sourcevertex){
        boolean[] visited = new boolean[V];
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        visited[sourcevertex] = true;
        a1.add(sourcevertex);
        while(!a1.isEmpty()){
            sourcevertex = a1.remove(0);
            System.out.println(sourcevertex+" ");
            Iterator i = adj[sourcevertex].iterator();
            while(i.hasNext()){
                int n = (int) i.next();
                if(!visited[n]){
                    visited[n] = true;
                    a1.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSImplementation bfs = new BFSImplementation(6);
        bfs.edge(0,1);
        bfs.edge(0,2);
        bfs.edge(0,5);
        bfs.edge(1,0);
        bfs.edge(1,2);
        bfs.edge(2,0);
        bfs.edge(2,1);
        bfs.edge(2,3);
        bfs.edge(2,4);
        bfs.edge(3,2);
        bfs.edge(4,2);
        bfs.edge(4,5);
        bfs.edge(5,0);
        bfs.edge(5,4);


        bfs.breathFirstSearch(0);

    }
}
