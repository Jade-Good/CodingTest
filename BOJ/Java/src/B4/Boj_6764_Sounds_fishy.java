package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_6764_Sounds_fishy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (isRise(arr)) {
            bw.write("Fish Rising");
        } else if (isDive(arr)) {
            bw.write("Fish Diving");
        } else if (isConstant(arr)) {
            bw.write("Fish At Constant Depth");
        } else {
            bw.write("No Fish");
        }
        bw.flush();
    }

    public static boolean isRise(int[] arr) {
        int before = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (before >= arr[i]) {
                return false;
            }
            before = arr[i];
        }
        return true;
    }

    public static boolean isDive(int[] arr) {
        int before = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (before <= arr[i]) {
                return false;
            }
            before = arr[i];
        }
        return true;
    }

    public static boolean isConstant(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
