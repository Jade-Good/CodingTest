package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine()); // 수강생의 수
            int[] student = new int[k];              // 수강생 저장 배열

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {            // 수강생 입력
                student[j] = Integer.parseInt(st.nextToken());
            }

            int one = 0, h = 24, m = 60, count = 0;    // 1등 수강생과 그 기록, 인증서 받은 수

            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {            // 대회 기록
                st = new StringTokenizer(br.readLine());
                int runner = Integer.parseInt(st.nextToken());
                int hour = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());

                boolean flag = false;
                for (int s = 0; s < k; s++){    // 수강생인지 배열에서 찾아보기
                    if (student[s] == runner){
                        flag = true;
                        break;
                    }
                }
                // 수강생이면서 포기하지 않고 6시간 이하
                if (flag && hour != -1 && ((hour == 6 && minute == 0) || hour < 6)) {
                    count++;
                    if (h > hour) {                         // 시가 더 빠름
                        one = runner;
                        h = hour;
                        m = minute;
                    } else if (h == hour && m > minute) {   // 분이 더 빠름
                        one = runner;
                        m = minute;
                    }
                }
            }
            System.out.println(one + " " + count);
        }
    }
}
