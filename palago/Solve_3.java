package palago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] parts = new String[n];
        // char[] col = {'a','e','i','o','u'};
        

        for(int i = 0; i < n; i++){
            parts[i] = bf.readLine();
        }

        int start = 0;
        for (String part : parts) {
            char[] chars = part.toCharArray();
            while(start < chars.length){

                if(chars[start] == 'a' || chars[start] == 'e' || chars[start] == 'i' || chars[start] == 'o' || chars[start] == 'u'){
                    for(int j = start+1; j < chars.length; j++ ){
                        if(!(chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u')){
                            start = j;
                            break;
                        }else{
                            chars[j] = ' ';
                        }
                    }
                }
                start++;
            }
            start=0;
            String s = String.valueOf(chars).replace(" ","");
            System.out.println(s);
        }
    }
}
