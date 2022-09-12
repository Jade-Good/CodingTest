package B5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class boj_10699 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String formatedNow = now.format(formatter);
        System.out.println(formatedNow);

    }
}
