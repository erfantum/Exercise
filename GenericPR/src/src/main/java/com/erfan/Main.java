package com.erfan;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get("joda.txt");
        Map<String, Long> collect = Files.readAllLines(filePath)
                .parallelStream()
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(w -> w.matches("\\w+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(String.valueOf(collect));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
