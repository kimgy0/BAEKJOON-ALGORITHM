package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        char[] chars = s[0].toCharArray();
        char c = s[1].charAt(0);
        int[] result = new int[chars.length];

        int temp = 1000;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == c){
                temp = 0;
            }else{
                temp++;
            }
            result[i] = temp;
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("");
        temp = 1000;
        for(int i = chars.length - 1; i>=0; i--){
            if(chars[i] == c){
                temp = 0;
            }else{
                temp++;
                if(result[i] > temp){
                    result[i] = temp;
                }
            }
        }
        for (int i : result) {
            System.out.print(i + " ");
        }


    }
}
