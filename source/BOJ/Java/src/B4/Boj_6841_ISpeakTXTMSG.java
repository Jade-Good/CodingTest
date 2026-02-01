package B4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj_6841_ISpeakTXTMSG {
    public static void main(String[] args) {
        // 번역 테이블 생성
        Map<String, String> translationTable = new HashMap<>();
        translationTable.put("CU", "see you");
        translationTable.put(":-)", "I’m happy");
        translationTable.put(":-(", "I’m unhappy");
        translationTable.put(";-)", "wink");
        translationTable.put(":-P", "stick out my tongue");
        translationTable.put("(~.~)", "sleepy");
        translationTable.put("TA", "totally awesome");
        translationTable.put("CCC", "Canadian Computing Competition");
        translationTable.put("CUZ", "because");
        translationTable.put("TY", "thank-you");
        translationTable.put("YW", "you’re welcome");
        translationTable.put("TTYL", "talk to you later");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();  // 사용자 입력 받기

            // 입력이 번역 테이블에 있는지 확인 후 출력
            if (translationTable.containsKey(input)) {
                System.out.println(translationTable.get(input));
                if (input.equals("TTYL")) {  // "TTYL" 입력 시 종료
                    break;
                }
            } else {
                System.out.println(input);  // 테이블에 없는 경우 원문 출력
            }
        }

        scanner.close();
    }
}