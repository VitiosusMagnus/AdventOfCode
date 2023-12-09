package day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part1 {

    public void solution() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/day2/input.txt"));
            String line = reader.readLine();
            int id = 1;
            int sum =0;
            while (line != null){
                if (isGameValid(line)){
                    sum+= id;
                }
                line = reader.readLine();
                id++;
            }
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isGameValid(String line) {
        int RED = 12;
        int GREEN = 13;
        int BLUE = 14;
        String[] str = line.split(":");
        String[] games= str[1].split(";");
        for (String game: games){
            String[] dices = game.split(",");
            for(String dice: dices){
                String[] attributes = dice.split(" ");
                switch (attributes[2]){
                    case "red":
                        if (Integer.parseInt(attributes[1]) > RED){
                            return false;
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(attributes[1]) > GREEN){
                            return false;
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(attributes[1]) > BLUE){
                            return false;
                        }
                        break;
                }

            }
        }
        return true;
    }
}
