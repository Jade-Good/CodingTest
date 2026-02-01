package S5;

import java.util.Scanner;

public class boj_1331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input[] = new String[36];
        boolean arr[][] = new boolean[6][6];
        int night[][] = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};

        for (int i = 0; i < 36; i++)
            input[i] = sc.next();

        int x = 0, y = 0, new_x, new_y;

        new_x = 5 - (int)(input[0].charAt(1) - '1');
        new_y =  (int)(input[0].charAt(0) - 'A');
        x = new_x;
        y = new_y;
        arr[new_x][new_y] = true;

        for (int i = 1; i < 36; i++){
                new_x = 5 - (int)(input[i].charAt(1) - '1');
                new_y =  (int)(input[i].charAt(0) - 'A');

                int diff_x = new_x - x;
                int diff_y = new_y - y;

                boolean flag = false;
                for (int k = 0; k < 8; k++){
                    if (diff_x == night[k][0] && diff_y == night[k][1]){
                        if (!arr[new_x][new_y]){
                            arr[new_x][new_y] = true;
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    System.out.println("Invalid");
                    System.exit(0);
                }

                x = new_x;
                y = new_y;
        }

        boolean flag = false;

        int diff_x = x - (5 - (int)(input[0].charAt(1) - '1'));
        int diff_y = y - (int)(input[0].charAt(0) - 'A');

        for (int k = 0; k < 8; k++){
            if (diff_x == night[k][0] && diff_y == night[k][1]){
                if (arr[new_x][new_y]){
                    arr[new_x][new_y] = true;
                    flag = true;
                    break;
                }
            }
        }

        if(flag)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}
