package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solve1_6 {

    /**
     *  조잡하게 생각할 것 없이... 다른풀이 방법은
     *  if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = bf.readLine().toCharArray();

        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            if(!list.contains(aChar)){
                list.add(aChar);
            }
        }

        StringBuilder s = new StringBuilder(list.size());
        for (Character c : list){
            s.append(c);
        }
        System.out.println(s.toString());


    }

}
