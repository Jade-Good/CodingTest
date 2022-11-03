package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891 {
    static int arr[], now[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        arr = new int[4];
        now = new int[4];

        // 체크 배열 입력 받기
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 현재 상태 배열과 초기화
        for (int i = 0; i < p; i++){ now[idx(dna.charAt(i))]++; }

        int answer = check() ? 1:0;

        // 윈도우 이동
        for (int i = 1; i <= s - p; i++){
            now[idx(dna.charAt(i-1))]--;
            now[idx(dna.charAt(i+p-1))]++;
            if (check())
                answer++;
        }
        System.out.println(answer);
    }

    // 문자의 DNA 인덱스 위치
    private static int idx(char c){
        if (c == 'A')
            return 0;
        else if (c == 'C') {
            return 1;
        }
        else if (c == 'G') {
            return 2;
        }
        else if (c == 'T') {
            return 3;
        }
        return 0;
    }

    // 체크 배열과 현재 상태 배열 비교
    private static boolean check(){
        boolean flag = true;
        for (int i = 0; i < 4; i++){
            if (now[i] < arr[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
