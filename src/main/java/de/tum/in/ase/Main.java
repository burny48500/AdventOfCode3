package de.tum.in.ase;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Change Path
        File input = new File("resources/input.txt");
        File test = new File("resources/test.txt");

        long total = 0;

        Reader reader = new Reader();
        total = reader.readFile(input);
        System.out.println(total);
    }
}