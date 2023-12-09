package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    HashSet<Number> numbers;
    HashSet<Symbol> symbols;

    public void solution() {
        try {
            numbers = new HashSet<>();
            symbols = new HashSet<>();

            BufferedReader reader = new BufferedReader(new FileReader("src/day3/input.txt"));

            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                findNumbers(line, count);
                findSymbols(line, count);
                line = reader.readLine();
                count++;
            }

            System.out.println(sumOfPartNumbers());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int sumOfPartNumbers() {
        return symbols.stream()
                .mapToInt(symbol -> numbers.stream()
                        .filter(number -> isAdjancent(number,symbol))
                        .mapToInt(number -> number.value)
                        .sum())
                .sum();

    }

    private boolean isAdjancent(Number number, Symbol symbol) {
        return (Math.abs(number.x - symbol.x) <= 1 && Math.abs(number.yStart - symbol.y) <= 1)
                || (Math.abs(number.x - symbol.x) <= 1 && Math.abs(number.yEnd - symbol.y) <= 1);
    }

    private void findSymbols(String line, int x) {
        Pattern symbolPattern = Pattern.compile("[^0-9\\.]");
        Matcher matcher = symbolPattern.matcher(line);
        while (matcher.find()) {
            symbols.add(new Symbol(x, matcher.start(),matcher.group().charAt(0)));
        }
    }

    private void findNumbers(String line, int x) {
        Pattern digitPattern = Pattern.compile("[0-9]+");
        Matcher matcher = digitPattern.matcher(line);
        while (matcher.find()) {
            numbers.add(new Number(Integer.parseInt(matcher.group()),x, matcher.start(), matcher.end()-1));
        }
    }
}


