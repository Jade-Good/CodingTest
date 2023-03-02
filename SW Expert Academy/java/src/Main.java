import D4.SWEA_1238_Contact;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//        String path = System.getProperty("user.dir");
//        System.out.println("Working Directory = " + path);

        int problem_num = 1238;
        try {
            System.setIn(new FileInputStream("./SW Expert Academy/java/inputFiles/" + problem_num + ".txt"));
        } catch (IOException e) {
            System.out.println("input 파일 읽기 실패");
            e.printStackTrace();
        }

        long start = System.nanoTime();
        ///////////////////////////////////////////////////////////////////////

        /*

//        public static void main(String[] args) throws IOException{
        public static void test() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int t = 1; t <= T; t++) {


                System.out.println("#" + t + " " + answer);
            }
        }

         */

        try {
            SWEA_1238_Contact.test();
        } catch (IOException e) {
            System.out.println(problem_num + "번 테스트 실패");
            e.printStackTrace();
        }

        ///////////////////////////////////////////////////////////////////////
        long end = System.nanoTime();
        int nano_seconds = (int)(end - start) / 1000;
        int milli_seconds = nano_seconds / 1000;
        int seconds = milli_seconds / 1000;
        System.out.printf("======\t %ds %dms %dns \t======\n", seconds, milli_seconds, nano_seconds);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.setIn(new FileInputStream("./SW Expert Academy/java/outputFiles/" + problem_num + ".txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("output 파일 읽기 실패");
            e.printStackTrace();
        }
    }
}
