package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Boj_16199_나이_계산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M d");

        LocalDate birthDate = LocalDate.parse(br.readLine(), formatter);
        LocalDate currentDate = LocalDate.parse(br.readLine(), formatter);

        // 나이 계산
        sb.append(calculateInternationalAge(birthDate, currentDate)).append('\n');
        sb.append(calculateKoreanAge(birthDate, currentDate)).append('\n');
        sb.append(calculateYearAge(birthDate, currentDate)).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    public static int calculateInternationalAge(LocalDate birthDate, LocalDate currentDate) {
        // 만 나이 계산
        if (currentDate.isBefore(birthDate.plusYears(currentDate.getYear() - birthDate.getYear()))) {
            return currentDate.getYear() - birthDate.getYear() - 1;
        } else {
            return currentDate.getYear() - birthDate.getYear();
        }
    }

    public static int calculateKoreanAge(LocalDate birthDate, LocalDate currentDate) {
        // 세는 나이 계산
        return currentDate.getYear() - birthDate.getYear() + 1;
    }

    public static int calculateYearAge(LocalDate birthDate, LocalDate currentDate) {
        // 연 나이 계산
        return currentDate.getYear() - birthDate.getYear();
    }
}
