package org.sysoev.task1.model.toNode;

import java.util.ArrayList;
import java.util.List;

public class ServerNode{
    private final String name;
    private final List<EdgeToNode> edges = new ArrayList<>();

    public ServerNode(String name) {
        this.name = name;
    }

    public List<EdgeToNode> getEdges() {
        return edges;
    }

    public String getName() {
        return name;
    }

    public void createConnect(EdgeToNode edge){
        edges.add(edge);
    }
}
