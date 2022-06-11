package purpleIIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 필수 테스트
 * 승점구하기
 */
public class Solve_3 {

    public static int solve(String[] games){
        int score = 0;
        for (String game : games) {
            String[] split = game.split(":");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if(a>b){
                score+=3;
            }else if (a==b){
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[10];

        for(int i = 0; i < 10; i++){
            input[i] = bf.readLine();
            String[] split = input[i].split(":");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if(a>4 || b>4){
                return;
            }
        }

        int score = solve(input);
        System.out.println(score);
    }
}