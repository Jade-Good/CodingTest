package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_6763_Speed_fines_are_not_fine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());

        if (speed <= limit) {
            bw.write("Congratulations, you are within the speed limit!");
        } else {
            int money = 0;
            if (speed - limit <= 20) {
                money = 100;
            } else if (speed - limit <= 30) {
                money = 270;
            } else {
                money = 500;
            }
            bw.write("You are speeding and your fine is $" + money + ".");
        }
        bw.flush();
    }
}
