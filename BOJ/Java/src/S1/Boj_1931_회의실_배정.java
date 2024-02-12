package S1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1931_회의실_배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);

        int answer = 0;
        int curEnd = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i].start >= curEnd) {
                answer++;
                curEnd = meetings[i].end;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}
