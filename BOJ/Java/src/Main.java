import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import S1.boj_1074;

public class Main {
    static int problem_num = 1074; // <<<<<<<<<<<<< 수정하기
    static BufferedReader br;
    static StringBuilder sb;
    static String s;

    private static void doTest(String input) throws IOException {
        long start = System.nanoTime();
        boj_1074.test(input); // <<<<<<<<<<<<<<<<<< 수정하기

        /* 템플릿

        public static void test (String s) throws IOException {
            StringTokenizer st = new StringTokenizer(s);

        }
        public static void main(String[] args) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        }

         */

        long end = System.nanoTime();
        System.out.println("\n======\t\ttime : " + (end - start) / 1000 + " micro seconds\t\t======");
    }

    private static void doInput() {
        try {
            System.setIn(new FileInputStream("./BOJ/Java/inputFiles/" + problem_num + ".txt"));

            sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(System.in));
            while ((s = br.readLine()) != null) {
                if (s.equals("=")) {
                    doTest(sb.toString());
                    sb = new StringBuilder();
                } else
                    sb.append(s + "\n");
            }
            doTest(sb.toString());
        } catch (IOException e) {
            System.out.println("input 파일 읽기 실패");
            e.printStackTrace();
        }
    }

    private static void doOutput() {
        try {
            System.setIn(new FileInputStream("./BOJ/Java/outputFiles/" + problem_num + ".txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("output 파일 읽기 실패");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String path = System.getProperty("user.dir");
//        System.out.println("Working Directory = " + path);

        doInput();
        doOutput();
    }
}
