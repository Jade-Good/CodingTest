package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌_깨기 {
    private static int N, H, W, map[][], selected[], ans;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    //        public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int t = 1; t <= T; t++) {
            // Input
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            selected = new int[N];
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Permutation
            ans = Integer.MAX_VALUE;

            perm(0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void perm(int idx) {
        if (idx == N) {
            ans = Math.min(ans, game());
            return;
        }

        for (int i = 0; i < W; i++) {
            selected[idx] = i;
            perm(idx + 1);
        }
    }

    private static int game() {
        int[][] temp = deppCopy();

        for (int i = 0; i < N; i++) { // 구을 N개 쏘기
            int r = 0;
            int c = selected[i];

            Queue<Block> que = new ArrayDeque<>();

            while(r < H) { // 구슬과 만나는 첫 블록 찾기
                if (temp[r][c] > 0) {
                    que.add(new Block(r, c, temp[r][c]));
                    temp[r][c] = 0;
                    break;
                }
                r++;
            }
//            print(temp);
            while(!que.isEmpty()) { // 연쇄 폭발
//                print(temp);
                Block block = que.poll();

                for (int j = 0; j < dx.length; j++) {
                    r = block.r + dx[j];
                    c = block.c + dy[j];

                    for (int k = 1; k < block.weight; k++) {
                        if (0<=r && r < H && 0 <= c && c < W && temp[r][c] > 0) {
                            if (temp[r][c] == 1) temp[r][c] = 0;
                            else {
                                que.offer(new Block(r, c, temp[r][c]));
                                temp[r][c] = 0;
                            }
                        }
                        r += dx[j];
                        c += dy[j];
                    }
                }
            }

            // 떠 있는 벽돌 하강
            for (int j = 0; j < W; j++) {
                for (int k = H-1; k > 0; k--) {
                    if (temp[k][j] == 0 && temp[k-1][j] > 0) {
                        int tem = temp[k][j];
                        temp[k][j] = temp[k-1][j];
                        temp[k-1][j] = tem;
                        if (k < H-1) k += 2;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] > 0)cnt++;
            }
        }
        return cnt;
    }

    private static int[][] deppCopy() {
        int[][] temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    private static void print(int[][] arr){
        System.out.println("==================================");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class Block {
        int r, c, weight;

        public Block(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }
}