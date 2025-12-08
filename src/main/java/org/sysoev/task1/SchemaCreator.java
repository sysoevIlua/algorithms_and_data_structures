package org.sysoev.task1;


import org.sysoev.task1.model.toArray.Edge;
import org.sysoev.task1.model.toArray.Server;
import org.sysoev.task1.model.toNode.EdgeToNode;
import org.sysoev.task1.model.toNode.ServerNode;

import java.util.*;

import static org.sysoev.task1.model.toArray.Server.*;

public class SchemaCreator {

    ////////////Массив
    public static Edge[][] createArraySchema() {
        var schema = new Edge[6][6];

        //A
        schema[A.ordinal()][B.ordinal()] = new Edge(1500, 90);
        schema[A.ordinal()][C.ordinal()] = new Edge(2000, 10);
        schema[A.ordinal()][D.ordinal()] = new Edge(1000, 50);

        //B
        schema[B.ordinal()][A.ordinal()] = new Edge(1000, 50);
        schema[B.ordinal()][F.ordinal()] = new Edge(1500, 60);

        //C
        schema[C.ordinal()][A.ordinal()] = new Edge(2000, 10);
        schema[C.ordinal()][F.ordinal()] = new Edge(500, 20);
        schema[C.ordinal()][E.ordinal()] = new Edge(900, 5);

        //D
        schema[D.ordinal()][A.ordinal()] = new Edge(1000, 50);
        schema[D.ordinal()][E.ordinal()] = new Edge(2500, 1);

        //E
        schema[E.ordinal()][D.ordinal()] = new Edge(2500, 1);
        schema[E.ordinal()][C.ordinal()] = new Edge(900, 5);
        schema[E.ordinal()][F.ordinal()] = new Edge(300, 85);

        //F
        schema[F.ordinal()][B.ordinal()] = new Edge(1500, 60);
        schema[F.ordinal()][C.ordinal()] = new Edge(500, 20);
        schema[F.ordinal()][E.ordinal()] = new Edge(300, 85);

        return schema;
    }

    public static void printArraySchema(Edge[][] schema) {
        Server[] servers = Server.values();
        for (Server s : servers) {
            System.out.printf("%15s", s.name());
        }
        System.out.println();

        for (int i = 0; i < schema.length; i++) {
            System.out.printf("%-5s", servers[i]);
            for (int j = 0; j < schema[i].length; j++) {
                if (schema[i][j] != null) {
                    System.out.printf("%-15s", "c "+ schema[i][j].capacity() + " l "+ schema[i][j].loss());
                } else {
                    System.out.printf("%-15s", "-----------");
                }
            }
            System.out.println();
        }
    }

    ////////////Лист

    public static ServerNode createNodeSchema() {

        ServerNode nodeA = new ServerNode("A");
        ServerNode nodeB = new ServerNode("B");
        ServerNode nodeC = new ServerNode("C");
        ServerNode nodeD = new ServerNode("D");
        ServerNode nodeE = new ServerNode("E");
        ServerNode nodeF = new ServerNode("F");

        connect(nodeA, nodeB, 1500, 90);
        connect(nodeA, nodeC, 2000, 10);
        connect(nodeA, nodeD, 1000, 50);
        connect(nodeB, nodeF, 1500, 60);
        connect(nodeC, nodeF, 500, 20);
        connect(nodeC, nodeE, 900, 5);
        connect(nodeD, nodeE, 2500, 1);
        connect(nodeE, nodeF, 300, 85);

        return nodeA;
    }

    private static void connect(ServerNode a, ServerNode b, int cap, int loss) {
        a.createConnect(new EdgeToNode(b, cap, loss));
        b.createConnect(new EdgeToNode(a, cap, loss));
    }

    public static void printNodeSchema(ServerNode node) {
        printNodeSchema(node, new HashSet<>());
    }

    private static void printNodeSchema(ServerNode node, Set<ServerNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);

        System.out.println(node.getName() + ":");

        for (EdgeToNode edge : node.getEdges()) {
            System.out.printf(
                    "%s, capacity: %d, loss: %d%%%n",
                    edge.serverNode().getName(),
                    edge.capacity(),
                    edge.loss()
            );
        }
        System.out.println();
        for (EdgeToNode edge : node.getEdges()) {
            printNodeSchema(edge.serverNode(), visited);
        }
    }
}
