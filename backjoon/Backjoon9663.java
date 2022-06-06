package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon9663 {

    static int n;
    static int[] ches;
    static int count = 0;

    public static void recursive(int num){

        if(num == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            ches[num]=i;
            if(isPossible(num)){
                recursive(num+1);
            }
        }
    }

    private static boolean isPossible(int num) {
        for(int i = 0; i < num; i++){
            if(ches[i]==ches[num] || Math.abs(num-i)== Math.abs(ches[num]-ches[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        ches = new int[n];

        recursive(0);

        System.out.println(count);
    }
}
