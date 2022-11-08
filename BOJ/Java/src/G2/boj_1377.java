package G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] arr = new mData[n];

        for (int i = 0; i < n; i++) arr[i] = new mData(Integer.parseInt(br.readLine()), i);

        Arrays.sort(arr);                   // arr배열 정렬 : O(nlogn)
        int max = 0;
        for (int i = 0; i < n; i++){
            if (max < arr[i].index - i)     // (정렬 전 index - 정렬 후 index) 계산의 최대값 저장
                max = arr[i].index - i;
        }
        System.out.println(max + 1);
    }
}
class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {     // value 기준 오름차순 정렬하기
        return this.value - o.value;
    }
}