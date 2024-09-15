package B4;

import java.util.Scanner;

public class Boj_4714_Lunacy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double earthWeight = scanner.nextDouble();

            // 입력이 음수인 경우 프로그램 종료
            if (earthWeight < 0) {
                break;
            }

            // 달에서의 무게는 지구 무게의 0.167배
            double moonWeight = earthWeight * 0.167;

            // 결과 출력 (소수점 둘째 자리까지)
            System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.%n", earthWeight, moonWeight);
        }

        scanner.close();
    }
}
