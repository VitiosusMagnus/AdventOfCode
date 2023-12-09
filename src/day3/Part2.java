package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
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

            System.out.println(sumOfGearRatios());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int sumOfGearRatios() {
        return symbols.stream()
                .filter(symbol -> symbol.value == '*')
                .mapToInt(symbol -> calculateGearRatio(symbol))
                .sum();
    }

    private int calculateGearRatio(Symbol symbol) {
        List<Number> adjacentNumbers = numbers.stream()
                .filter(number -> isAdjancent(number, symbol))
                .toList();

        if (adjacentNumbers.size() == 2) {
           return adjacentNumbers.get(0).value * adjacentNumbers.get(1).value;
        }

        return 0;
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


