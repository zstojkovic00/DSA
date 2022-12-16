package Graphs.DFS;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Vertex <T>{
    private final T data;
    private boolean visited;
    @ToString.Exclude
    private List<Vertex<T>> neighbors = new ArrayList<>();
}
