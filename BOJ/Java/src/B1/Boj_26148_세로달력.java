package B1;

import java.io.*;

public class Boj_26148_세로달력 {
    private static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int dow = Integer.parseInt(br.readLine()) - 1;
        sum = 0;

        for (int month = 1; month <= 12; month++) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    dow = cntColCal(dow, 31);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dow = cntColCal(dow, 30);
                    break;
                case 2:
                    if ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) { // 윤년
                        dow = cntColCal(dow, 29);
                    } else {
                        dow = cntColCal(dow, 28);
                    }
                    break;
            }
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }

    private static int cntColCal(int startDow, int days) {
        int lastWeekDays = (days - (7 - startDow)) % 21;

        sum += Math.max(0, lastWeekDays - startDow);

        return lastWeekDays % 7;
    }
}
