package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[6];
        for (int i = 0; i < 6; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        double abx = arr[0]-arr[2];
        double aby = arr[1]-arr[3];
        double acx = arr[0]-arr[4];
        double acy = arr[1]-arr[5];
        double bcx = arr[2]-arr[4];
        double bcy = arr[3]-arr[5];

        // 기울기가 같으면 같은 직선에 존재하는 점
        // 기울기 : x증가량/y증가량
        // abx / aby == acx / acy (0을 나누면 오류가 생기므로 치환)
        // abx * acy == acx * aby
        if(abx*acy == aby*acx){
            System.out.println(-1.0);
            System.exit(0);
        }

        double ab_length = Math.sqrt(Math.pow(abx,2)+Math.pow(aby,2));
        double ac_length = Math.sqrt(Math.pow(acx,2)+Math.pow(acy,2));
        double bc_length = Math.sqrt(Math.pow(bcx,2)+Math.pow(bcy,2));

        double max = ab_length + ac_length;
        double min = ab_length + ac_length;

        if (ac_length + bc_length > max) max = ac_length + bc_length;
        if (bc_length + ab_length > max) max = bc_length + ab_length;
        if (ac_length + bc_length < min) min = ac_length + bc_length;
        if (bc_length + ab_length < min) min = bc_length + ab_length;

        System.out.println((max-min)*2);
    }
}
