package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split("");
        Arrays.sort(str, Collections.reverseOrder());
        for (String s : str){
            System.out.print(s);
        }
    }
}

/* 교재 선택정렬 연습 */
//import java.util.Scanner;
//
//public class boj_1427 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        int[] A = new int[str.length()];
//        for (int i = 0; i < str.length(); i++){
//            A[i] = Integer.parseInt(str.substring(i, i+1));
//        }
//        for (int i = 0; i < str.length()-1; i++){
//            int max = i;
//            for (int j = i+1; j < str.length(); j++){ // 최대값 찾기
//                if (A[j] > A[max])
//                    max = j;
//            }
//            if (A[i] < A[max]){     // 최대값과 교환
//                int temp = A[i];
//                A[i] = A[max];
//                A[max] = temp;
//            }
//        }
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(A[i]);
//        }
//    }
//}




