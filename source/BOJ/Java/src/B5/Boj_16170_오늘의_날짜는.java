package B5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

public class Boj_16170_오늘의_날짜는 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LocalDate currentDate = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        sb.append(currentDate.getYear()).append('\n').append(currentDate.getMonthValue()).append('\n')
                .append(currentDate.getDayOfMonth());

        bw.write(sb.toString());
        bw.flush();
    }
}
