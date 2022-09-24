//package S4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class boj_1940 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int m = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++)
//            arr[i] = Integer.parseInt(st.nextToken());
//
//        int answer = 0;
//        for (int i = 0; i < n - 1; i++){
//            for (int j = i+1; j < n; j++){
//                if (arr[i] + arr[j] == m)
//                    answer++;
//            }
//        }
//        System.out.println(answer);
//    }
//}

package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;
        int i = 0;
        int j = n - 1;
        while(i < j){
            if (arr[i] + arr[j] < m) i++;
            else if (arr[i] + arr[j] > m) j--;
            else {
                answer++;
                i++;
                j--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}