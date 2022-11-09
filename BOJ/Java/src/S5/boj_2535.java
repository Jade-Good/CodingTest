package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] counrtry = new int[n+1];
        Mydata[] arr = new Mydata[n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Mydata(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        int count = 0, i = 0;
        while (count < 3){
            if (counrtry[arr[i].country] < 2) {
                counrtry[arr[i].country]++;
                sb.append(arr[i].country + " " + arr[i].student + "\n");
                count++;
            }
            i++;
        }
        System.out.println(sb.toString());
    }
}

class Mydata implements Comparable<Mydata> {
    int country;
    int student;
    int grade;

    public Mydata(int country, int student, int grade) {
        this.country = country;
        this.student = student;
        this.grade = grade;
    }

    @Override
    public int compareTo(Mydata o) {
        return o.grade - this.grade;
    }
}
