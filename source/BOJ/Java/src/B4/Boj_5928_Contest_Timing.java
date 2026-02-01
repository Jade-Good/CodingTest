package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_5928_Contest_Timing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시작 시간 설정
        int startDay = 11;
        int startHour = 11;
        int startMinute = 11;

        // 입력받은 종료 시간
        int endDay = Integer.parseInt(st.nextToken());
        int endHour = Integer.parseInt(st.nextToken());
        int endMinute = Integer.parseInt(st.nextToken());

        // 시작 시간을 분 단위로 변환
        int startTotalMinutes = (startDay * 24 * 60) + (startHour * 60) + startMinute;

        // 종료 시간을 분 단위로 변환
        int endTotalMinutes = (endDay * 24 * 60) + (endHour * 60) + endMinute;

        // 경과 시간 계산
        int elapsedMinutes = endTotalMinutes - startTotalMinutes;

        // 결과 출력
        if (elapsedMinutes < 0) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(elapsedMinutes));
        }
        bw.flush();
    }
}
