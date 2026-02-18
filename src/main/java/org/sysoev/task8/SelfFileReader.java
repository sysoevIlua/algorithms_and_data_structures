package org.sysoev.task8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelfFileReader {

    public static Map<Integer, List<String>> readFile(String p) throws IOException {
        
        Path path = Path.of(p);

        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .parallel()
                    .map(text -> text.trim())
                    .map(line -> line.split(":"))
                    .filter(splitLine -> splitLine.length == 2 && !splitLine[0].isBlank() && !splitLine[1].isBlank())
                    .collect(Collectors.groupingByConcurrent(
                            a -> Integer.parseInt(a[1]),
                            Collectors.mapping(
                                    a -> normalizeName(a[0]),
                                    Collectors.toList()
                            )
                    ));
        }
    }

    private static String normalizeName(String name) {
        name = name.toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
