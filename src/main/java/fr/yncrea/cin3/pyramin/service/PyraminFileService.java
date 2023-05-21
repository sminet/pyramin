package fr.yncrea.cin3.pyramin.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PyraminFileService {
    public List<List<Integer>> loadFromFile(String filename) throws IOException {
        return Files.lines(getPath(filename))
                .map(this::lineToIntegers)
                .toList();
    }

    public void generateToFile(String filename, int size) {
        var lines = Stream.iterate(1, e -> e <= size, e -> e + 1)
                .map(this::generateLine)
                .toList();

        try {
            Files.write(getPath(filename), lines);
        } catch (IOException e) {
            System.err.println("Could not write output file");
        }
    }

    private String generateLine(int size) {
        var randoms = new LinkedList<String>();

        for (int cpt = 0; cpt < size; ++cpt) {
            randoms.add(String.format("%d", (int)(Math.random() * 10)));
        }

        return String.join(" ", randoms);
    }

    private Path getPath(String filename) {
        return Paths.get("var", "data", filename);
    }

    private List<Integer> lineToIntegers(String line) {
        return Arrays.asList(line.split("\\s+")).stream()
                .map(Integer::parseInt)
                .toList();
    }
}
