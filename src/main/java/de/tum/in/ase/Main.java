package de.tum.in.ase;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File input = new File("/Users/urkocornejo/Library/CloudStorage/OneDrive-TUM/" +
                "IdeaProjects/Personal/AdventOfCode/AdventOfCode3/src/main/java/de/tum/in/ase/input.txt");
        File test = new File("/Users/urkocornejo/Library/CloudStorage/OneDrive-TUM/" +
                "IdeaProjects/Personal/AdventOfCode/AdventOfCode3/src/main/java/de/tum/in/ase/test.txt");

        long total = 0;

        Reader reader = new Reader();
        total = reader.readFile(input);
        System.out.println(total);
    }
}