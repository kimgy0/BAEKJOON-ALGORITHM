package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon11722 {

    /**
     * 수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.
     * 예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는
     * 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int pivot = 0;

        String[] s = bf.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(s[i]);
        }

        int[] count = new int[n];
        count[0] = 0;

        for (int i = 1; i < n; i++){
            if(pivot > arr[i]){
                count[i] = 1;
            }
        }


    }
}
