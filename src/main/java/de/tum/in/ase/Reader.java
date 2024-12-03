package de.tum.in.ase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    private List<String> validStrings;
    private List<Integer> intNumbers;

    public long readFile(File inputFile) throws IOException {
        validStrings = new ArrayList<>();

        String regex = "mul\\([0-9]+,[0-9]+\\)";

        Pattern pattern = Pattern.compile(regex);

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    System.out.println(matcher.group());
                    validStrings.add(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile);
        }
        getNumbers(validStrings);
        return mulAndAdd(intNumbers);
    }

    private void getNumbers(List<String> strings) {
        intNumbers = new ArrayList<>();
        String regex2 = "[0-9]+";
        Pattern pattern = Pattern.compile(regex2);

        for (String string : strings) {
            Matcher matcher2 = pattern.matcher(string);
            while (matcher2.find()) {
                intNumbers.add(Integer.valueOf(matcher2.group()));
                System.out.println(intNumbers.toString());
            }
        }
    }

    private long mulAndAdd(List<Integer> numbersList) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            //Odd
            if(i % 2 != 0){
                odds.add(numbersList.get(i));
                System.out.println("Odds");
                System.out.println(odds.toString());
            } else {
                evens.add(numbersList.get(i));
                System.out.println("Evens");
                System.out.println(evens);
            }
        }
        for (int i = 0; i < odds.size(); i++) {
            total += ((long) odds.get(i) * evens.get(i));
        }
        return total;
    }
}
