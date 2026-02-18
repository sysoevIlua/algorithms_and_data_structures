package org.sysoev;


import org.sysoev.task8.SelfFileReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        var map = SelfFileReader.readFile("src/main/java/org/sysoev/task8/test.txt");

        System.out.println(map);
    }
}