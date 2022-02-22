import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon2178 {//https://coding-factory.tistory.com/251 버퍼
                            //https://covenant.tistory.com/132 dfs
    private static int col;
    private static int row;
    private static int[][] arr;

    private static Stack close = new Stack();
    private static ArrayList visited = new ArrayList();

    // 사이즈 받기
    public static void getSize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();
        StringTokenizer st = new StringTokenizer(size);
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
    }

    // 배열 입력 받기
    public static void getContent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String token = st.nextToken();
            for(int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(token.substring(j,j+1));
            }
        }
    }

    public static int getPath(){

        Status visit = new Status(0, 0);
        int flag = 0;
        visited.add(visit);

        while(!(visit.getRow() == row-1 && visit.getCol() == col-1)){
            flag = 0;
            Status buttom = new Status(visit.getRow() + 1, visit.getCol());
            Status right = new Status(visit.getRow(), visit.getCol() + 1);
            Status top = new Status(visit.getRow()-1, visit.getCol());
            Status left = new Status(visit.getRow(), visit.getCol() - 1);

            if(buttom.getRow() < row && arr[buttom.getRow()][buttom.getCol()] == 1){
                if (!visited.contains(buttom)){
                    close.push(buttom); flag++;
                }
            }
            if (right.getCol() < col && arr[right.getRow()][right.getCol()] == 1){
                if (!visited.contains(right)) {
                    close.push(right); flag++;
                }
            }
            if (top.getRow() >= 0 && arr[top.getRow()][top.getCol()] == 1){
                if (!visited.contains(top)) {
                        close.push(top); flag++;
                }
            }
            if (left.getCol() >= 0 && arr[left.getRow()][left.getCol()] == 1){
                if (!visited.contains(left)) {
                    close.push(left); flag++;
                }
            }
            visit = (Status) close.pop();
            if(flag!=0){
                visited.add(visit);
            }
        }
        return visited.size();
    }

    static class Status{
        private int row;
        private int col;
        @Override
        public boolean equals(Object obj) {
            Status status = (Status) obj;
            return status.getCol()==col && status.getRow()==row;
        }

        public Status(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
    public static void main(String[] args) throws IOException {
        getSize();
        getContent();
        System.out.println(getPath());
    }
}
