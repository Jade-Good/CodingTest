package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Mydata[] arr = new Mydata[n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Mydata(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].name);
        }
    }
}

class Mydata implements Comparable<Mydata> {
    String name;
    int kor;
    int eng;
    int math;

    public Mydata(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Mydata o) {
        if (o.kor != this.kor)
            return o.kor - this.kor;
        else if (o.eng != this.eng)
            return this.eng - o.eng;
        else if (o.math != this.math)
            return o.math - this.math;
        else return this.name.compareTo(o.name);
    }
}
