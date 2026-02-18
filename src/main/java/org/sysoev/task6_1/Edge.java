package org.sysoev.task6_1;

public class Edge {
    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "from "+from+" to "+to+" weight "+weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        if (from != edge.from) return false;
        if (to != edge.to) return false;
        return weight == edge.weight;
    }
}