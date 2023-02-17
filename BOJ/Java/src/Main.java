import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import G4.boj_17281;

public class Main {
    static int problem_num = 17281; // <<<<<<<<<<<<< 수정하기
    static BufferedReader br;
    static StringBuilder sb;
    static String s;

    private static void doTest(String input, int count) throws IOException {
        long start = System.nanoTime();
        boj_17281.test(input); // <<<<<<<<<<<<<<<<<< 수정하기

        /* 템플릿

        public static void test (String s) throws IOException {
            StringTokenizer st = new StringTokenizer(s);

        }
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ) ;

        }

         */

        long end = System.nanoTime();
        int nano_seconds = (int)(end - start) / 1000;
        int milli_seconds = nano_seconds / 1000;
        int seconds = milli_seconds / 1000;
        System.out.printf("======\t (%d) %ds %dms %dns \t======", count, seconds, milli_seconds, nano_seconds);
    }

    private static void doInput() {
        try {
            System.setIn(new FileInputStream("./BOJ/Java/inputFiles/" + problem_num + ".txt"));

            sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(System.in));
            int count = 1;
            while ((s = br.readLine()) != null) {
                if (s.equals("=")) {
                    doTest(sb.toString(), count++);
                    sb = new StringBuilder();
                } else
                    sb.append(s + "\n");
            }
            doTest(sb.toString(), count);
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
