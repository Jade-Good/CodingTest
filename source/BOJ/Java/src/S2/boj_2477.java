package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_2477 {
    static int k, ans;
    static int[] dirArray, lenArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine()); // 면적 당 참외의 수
        dirArray = new int[6];
        lenArray = new int[6];

        // 가장 긴 너비 index, 높이 index => 값
        // 위로 부터 가장 짧은 너비, 높이 index 구한다.

        /// 입력으로부터 각각 비교하면서 구한다.
        int wMax = 0;
        int wMaxIdx = 0;
        int hMax = 0;
        int hMaxIdx = 0;

        // 위의 값이 구해지면 +3, %6 계산
        int wMinIdx = 0;
        int hMinIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            dirArray[i] = dir;
            lenArray[i] = len;

            switch ( dir ) {
                // width
                case 1:
                case 2:
                    if (len > wMax ) {
                        wMax = len;
                        wMaxIdx = i;
                    }
                    break;
                // height
                case 3:
                case 4:
                    if (len > hMax ) {
                        hMax = len;
                        hMaxIdx = i;
                    }
                    break;
            }
        }

        // 여기까지, 가로 세로 가장 긴 변의 index를 확보
        // 대각선 방향 대응되는 wMinIdx, hMinIdx 를 구한다 => +3 하고 안전하게 %6
        wMinIdx = (hMaxIdx + 3) % 6;
        hMinIdx = (wMaxIdx + 3) % 6;

        ans = (lenArray[wMaxIdx]*lenArray[hMaxIdx] - lenArray[wMinIdx] * lenArray[hMinIdx]) * k;

        System.out.println(ans);

    }
}
