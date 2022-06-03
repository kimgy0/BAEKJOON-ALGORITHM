package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon15649 {

    static int m;
    static int n;
    static String[] result;
    static boolean[] visit;
    static int fac = 1;
    static StringBuilder join = new StringBuilder("");
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        /**
         * 중복이 없는 경우 팩토리얼 n!
         * 중복이 있는 경우 제곱 n^m
         */

        result = new String[factorial(n)];
        visit = new boolean[n+1];
        Arrays.fill(visit, false);

        recursive(0);

        for (String s1 : result) {
            System.out.println(s1);
        }
    }

    private static int factorial(int n) {
        if(fac == m){
            return n;
        }
        fac ++;
        return n * factorial(n-1);
    }

    public static void recursive(int num){
        if(num == m){
            result[count] = join.toString();
            count++;
            return;
        }
        for(int i = 1; i<=n; i++){
            if(visit[i] == false){
                visit[i]= true;
                join.append(i + " ");
                recursive(num+1);
                visit[i]=false;
                join.replace(join.length()-2, join.length(), "");
            }
        }
    }
}
