package day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {
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
        int start = 0;
        int end = 0;
        for (int i = 0; i <line.length(); i++) {
            if (Character.isDigit(line.charAt(i))){
                start = Integer.parseInt(line.charAt(i) + "0");
                break;
            }
            if (isLetterNumber(line.substring(i)) > -1){
                start = 10*isLetterNumber(line.substring(i));
                break;
            }
        }
        for (int i = line.length()-1; i >=0 ; i--) {
            if (Character.isDigit(line.charAt(i))){
                end = Integer.parseInt(line.charAt(i) +"");
                break;
            }
            if (isLetterNumber(line.substring(i)) > -1){
                end = isLetterNumber(line.substring(i));
                break;
            }
        }
        System.out.println("start: " + start + " end: " + end);
        return start + end;
    }

    private int isLetterNumber(String str) {
        String[] numbers = {"one", "two","three","four","five","six","seven","eight","nine"};
        for (int i = 0; i < numbers.length; i++) {
            if (str.startsWith(numbers[i])){
                return i + 1;
            }
        }
        return -1;
    }


}
