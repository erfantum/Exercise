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
    public static void main(String[] args) {
        Path filePath = Paths.get("joda.txt");
        Map<String, Long> collect = null;
        try {
            collect = Files.readAllLines(filePath)
                    .parallelStream()
                    .map(line -> line.split("[.]|[ ]|[?]|[!]|[\"]|[,]|\\n|[:]|[+]"))
                    .flatMap(Arrays::stream)
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
        } catch (IOException e) {
            System.out.println("File not found");

        }

    }
}
