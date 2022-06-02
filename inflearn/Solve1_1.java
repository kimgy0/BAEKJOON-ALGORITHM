package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        String character = bf.readLine();
        int count = 0;
        String[] split = string.split("");
        for (String s : split) {
            if(character.toUpperCase().equals(s)
                    || character.toLowerCase().equals(s)){
                count++;
            }
        }
        System.out.println(count);
    }
}
