package day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part1 {
    public void solution() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/day1/input.txt"));
            String line = reader.readLine();
            int sum = 0;
            while (line != null){
                sum += findCalibrationValue(line);
                line = reader.readLine();
            }
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int findCalibrationValue(String line) {
        int i = 0;
        int first;
        int last;
        while (!Character.isDigit(line.charAt(i))){
            i++;
        }
        first = Integer.parseInt(line.charAt(i) + "0");
        i = line.length() - 1;
        while (!Character.isDigit(line.charAt(i))){
            i--;
        }
        last = Integer.parseInt(""+line.charAt(i));
        return first + last;
    }

}
