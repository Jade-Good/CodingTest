package B4;

import java.util.Scanner;

public class Boj_11121_Communication_Channels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받는 T(전송 개수)
        int T = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        for (int i = 0; i < T; i++) {
            // 각 전송의 입력과 출력 읽기
            String transmission = sc.nextLine();
            String[] parts = transmission.split(" ");
            String input = parts[0];
            String output = parts[1];

            // 입력과 출력 비교
            if (input.equals(output)) {
                System.out.println("OK");
            } else {
                System.out.println("ERROR");
            }
        }
    }
}
