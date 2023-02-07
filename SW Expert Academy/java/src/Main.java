import D2.SWEA_1859;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//        String path = System.getProperty("user.dir");
//        System.out.println("Working Directory = " + path);

        int problem_num = 1859;
        try {
            System.setIn(new FileInputStream("./SW Expert Academy/java/inputFiles/" + problem_num + ".txt"));
        } catch (IOException e) {
            System.out.println("input 파일 읽기 실패");
            e.printStackTrace();
        }

        long start = System.nanoTime();
        ///////////////////////////////////////////////////////////////////////

        //    public void test() throws IOException{}
        try {
            SWEA_1859.test();
        } catch (IOException e) {
            System.out.println(problem_num + "번 테스트 실패");
            e.printStackTrace();
        }

        ///////////////////////////////////////////////////////////////////////
        long end = System.nanoTime();
        System.out.println("\n============================" + " time : " + (end - start) / 1000
                + "ms ===========================");
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
