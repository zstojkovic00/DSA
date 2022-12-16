package Graphs.DFS;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch <T> {

    public void traverse(Vertex<T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);
        while(!stack.isEmpty()){
            Vertex<T> current = stack.pop();
            if(!current.isVisited()){
                current.setVisited(true);
                System.out.println(current);}
            Collections.reverse((current.getNeighbors()));
            current.getNeighbors().forEach(stack::push);

        }



    }

}
