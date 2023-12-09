package day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {

    public void solution() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/day2/input.txt"));
            String line = reader.readLine();
            int sum =0;
            while (line != null){
                sum += findPowerOfSet(line);
                line = reader.readLine();
            }
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private int findPowerOfSet(String line) {
        int red = 0;
        int green = 0;
        int blue = 0;
        String[] str = line.split(":");
        String[] games= str[1].split(";");
        for (String game: games){
            String[] dices = game.split(",");
            for(String dice: dices){
                String[] attributes = dice.split(" ");
                switch (attributes[2]){
                    case "red":
                        if (Integer.parseInt(attributes[1]) > red){
                            red = Integer.parseInt(attributes[1]);
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(attributes[1]) > green){
                            green = Integer.parseInt(attributes[1]);
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(attributes[1]) > blue){
                        blue = Integer.parseInt(attributes[1]);
                    }
                        break;
                }

            }
        }
        return red*blue*green;
    }
}
