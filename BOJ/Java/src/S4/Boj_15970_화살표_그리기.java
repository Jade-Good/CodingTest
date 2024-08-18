package S4;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_15970_화살표_그리기 {
    private static int[][] arr;
    private static int[] color;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][2]; // 입력 받은 정보
        color = new int[N + 1]; // i번 컬러의 최근 위치

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            color[i] = -1;
        }

        // Sort
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        // Process
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (color[arr[i][1]] == -1) { // 처음 등장한 컬러
                answer += getArrowLength(arr[i][0], i + 1, 100_000, arr[i][1]);
            } else { // 이전에 등장한 컬러
                answer += getArrowLength(arr[i][0], i + 1, arr[i][0] - color[arr[i][1]], arr[i][1]);
            }
        }
        
        // Output
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int getArrowLength(int now, int start, int max, int colorIdx) {
        int result;
        for (int i = start; i < arr.length; i++) {
            if (arr[i][0] - now >= max) { // 더 안찾아도 됨
                break;
            } else if (arr[i][1] == colorIdx) { // 같은 색 찾음
                result = arr[i][0] - now;
                color[colorIdx] = now;
                return result;
            }
        }
        result = now - color[colorIdx];
        color[colorIdx] = now;
        return result;
    }
}
