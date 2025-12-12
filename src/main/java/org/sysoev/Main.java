package org.sysoev;

import org.sysoev.task1.SchemaCreator;

public class Main {
    public static void main(String[] args) {
        var arraySchema = SchemaCreator.createArraySchema();
        SchemaCreator.printArraySchema(arraySchema);


        var startNode = SchemaCreator.createNodeSchema();
        SchemaCreator.printNodeSchema(startNode);
    }
}