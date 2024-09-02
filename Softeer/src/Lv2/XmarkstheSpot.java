package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class XmarkstheSpot {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] chars = st.nextToken().toUpperCase().toCharArray();

            int idx;

            for (idx = 0; idx < chars.length; idx++) {
                if (chars[idx] == 'X') {
                    break;
                }
            }

            sb.append(st.nextToken().toUpperCase().charAt(idx));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

/*

< 문제 분석 >
- N개의 문자열 쌍 (길이 같음)
- 앞 문자열에서 X가 나온 인덱스를 뒷 문자열에서 찾아 해당 문자를 선택
- 순서대로 문자열들 출력

< 풀이 계획 >
- 모두 대문자화
- 앞에서 X찾아서 해당 인덱스를 뒷 문자열에서 찾아 누적
- 누적 된 문자열 출력

*/