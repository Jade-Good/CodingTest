package S3;

import java.util.Scanner;

public class boj_1063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        String[] orders = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

        String kingStart = sc.next();
        String stoneStart = sc.next();
        int n = sc.nextInt();

        int kx = 8 - (kingStart.charAt(1) - '0');
        int ky = kingStart.charAt(0) - 'A';
        int sx = 8 - (stoneStart.charAt(1) - '0');
        int sy = stoneStart.charAt(0) - 'A';

        for (int i = 0; i < n; i++) {
            String order = sc.next();
            int onum = -1;
            for (int j = 0; j < 8; j++) {
                if (order.equals(orders[j])) {
                    onum = j;
                    break;
                }
            }
            if (kx + dx[onum] >= 0 && kx + dx[onum] <= 7 && ky + dy[onum] >= 0 && ky + dy[onum] <= 7) {
                if (kx + dx[onum] == sx && ky + dy[onum] == sy) {
                    if (sx + dx[onum] >= 0 && sx + dx[onum] <= 7 && sy + dy[onum] >= 0 && sy + dy[onum] <= 7) {
                        kx += dx[onum];
                        ky += dy[onum];
                        sx += dx[onum];
                        sy += dy[onum];
                    }
                }
                else {
                    kx += dx[onum];
                    ky += dy[onum];
                }
            }
        }

        System.out.println(String.format("%c%d\n%c%d", (char) (ky + 'A'), 8 - kx, (char) (sy + 'A'), 8 - sx));
    }
}
