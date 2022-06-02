package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve1_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bf.readLine().toUpperCase().toCharArray();

        StringBuilder sb = new StringBuilder("");
        int count = 0;

        for(int i = 0 ; i < chars.length - 1; i ++){
            if(chars[i] != chars[i+1]){
                sb.append(chars[i]);
                if(count != 0){
                    sb.append(count+1);
                    count=0;
                }
            }else{
                count++;
            }

            if(chars.length - 1 == i+1){
                sb.append(chars[i+1]);
                if(count != 0) {
                    sb.append(count + 1);
                    count = 0;
                }
            }
        }
        System.out.println(sb);

    }
}
