package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);

        int answer = 1;
        int end = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start >= end) {
                end = meetings[i].end;
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static class Meeting implements Comparable<Meeting>{
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end)
                return this.end - o.end;
            return this.start - o.start;
        }
    }
}
