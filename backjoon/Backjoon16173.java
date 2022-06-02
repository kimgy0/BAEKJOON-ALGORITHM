package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon16173 {

    static class Reach{
        private int row;
        private int col;

        public Reach(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public boolean equals(Object reach) {
            return ((Reach) reach).getRow() == this.row && ((Reach) reach).getCol() == this.col;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader bfSize = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(bfSize.readLine());
            int value = 0;
            int[][] values = new int[size][size];
            String str;
            Queue<Reach> queue = new LinkedList<>();
            boolean[][] visited = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    visited[i][j] = false;
                }
            }



//            for (String s = br.readLine(); s != null; s = br.readLine())
            for (int i = 0; i < size; i++) {
                str = bfSize.readLine();
                StringTokenizer st = new StringTokenizer(str);
                for (int j = 0; j < size; j++) {
                    values[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            queue.add(new Reach(0, 0));
            while (!queue.isEmpty()) {
                Reach reach = queue.poll();
                if((reach.getCol() + (values[reach.getRow()][reach.getCol()])) < size ||(reach.getRow() + (values[reach.getRow()][reach.getCol()])) < size){
                    if (visited[reach.getRow()][reach.getCol()] == false) {
                        value = values[reach.getRow()][reach.getCol()];
                        visited[reach.getRow()][reach.getCol()] = true;
                        if (value == -1) {
                            System.out.println("HaruHaru");
                            break;
                        }
                        Reach right = new Reach(reach.getRow(), reach.getCol() + value);
                        if((reach.getCol() + value) < size && !queue.contains(right)){
                            queue.add(right);
                        }
                        Reach under = new Reach(reach.getRow() + value, reach.getCol());
                        if((reach.getRow() + value) < size && !queue.contains(under)){
                            queue.add(under);
                        }
                    }
                }
            }
            if(value != -1){
                System.out.println("Hing");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
