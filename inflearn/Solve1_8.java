package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * s.toUpperCase().replaceAll("[^A-Z]","");
 *  -> 대문자가 아닌 것들은 모두다 "" 로 치환하라.
 *
 *  자세한 정규식 링크
 *  https://velog.io/@minji/Java-%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9DString.replaceAll-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%B9%98%ED%99%98
 *
 */

public class Solve1_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine().toUpperCase();

        int lt = 0;
        int rt = s.length()-1;

        System.out.println(extracted(s, lt, rt));

    }

    private static String extracted(String s, int lt, int rt) {
        while(lt < rt){
            while(!Character.isAlphabetic(s.charAt(lt))){
                lt++;
            }
            while(!Character.isAlphabetic(s.charAt(rt))){
                rt--;
            }
            char a = s.charAt(lt);
            char b = s.charAt(rt);

            if(s.charAt(lt) == s.charAt(rt)){
                lt++;
                rt--;
            }else{
                return "NO";
            }
        }
        return "YES";
    }
}
