package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * str.substring(0,5) -> 0인덱스 부터 5인덱스까지 잘라냄.
 * str.substring(1) -> 1부터 끝까지 잘라냄.
 *
 * str.indexOf(' ') -> 공백 문자가 처음으로 나오는 인덱스 번호.
 * ! 만약 찾지 못했다면, -1 을 반환함.
 */
public class Solve1_3 {
    public static void main(String[] args) throws IOException {
        String max = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.length() > max.length())
            {
                max = token;
            }
        }
        System.out.println(max);
    }
}
