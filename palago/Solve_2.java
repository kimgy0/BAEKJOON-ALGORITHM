package palago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solve_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String id = bf.readLine();
        String pw1 = bf.readLine();
        String pw2 = bf.readLine();

        if(Pattern.matches("[a-z0-9]{4,20}",id)) {
            if(pw1.equals(pw2)){
                if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$]).{8,20}$",pw1)){
                    System.out.println("pass");
                    return;
                }
            }
        }
        System.out.println("fail");

    }
}
