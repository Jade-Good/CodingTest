import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {

    private static int n;
    private static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, n)];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        result[0] = arr[1];

        dfs(2, 1);

        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean dfs(int idx, int pickCnt) {
        if (idx == arr.length) {
            return pickCnt == n;
        }

        int need = findNeed(arr[idx], pickCnt);

        if (need == 0) { // 현재 원소로 만들 수 있음
            return dfs(idx + 1, pickCnt);
        } else { // 새로 원소 추가 필요
            if (pickCnt == n) {
                return false;
            }
            result[pickCnt] = need;
            return dfs(idx + 1, pickCnt + 1);
        }
    }

    private static int findNeed(int target, int pickCnt) { // 0~pickCnt 로 target 만들 수 있는지 확인, 못만들면 필요한 원소중 가장 작은 값
        int[] subset = new int[pickCnt];
        System.arraycopy(result, 0, subset, 0, pickCnt);
        int[] minNeeded = {Integer.MAX_VALUE};
        if (findNeedRecursive(target, subset, 0, minNeeded) == 0) {
            return 0;
        } else {
            return minNeeded[0];
        }
    }

    private static int findNeedRecursive(int target, int[] subset, int index, int[] minNeeded) {
        if (index == subset.length) {
            int sum = 0;
            for (int num : subset) {
                sum += num;
            }
            if (sum == target) {
                return 0; // 현재 원소로 target을 만들 수 있음
            }
            // target을 만들 수 없는 경우, 필요한 가장 작은 원소 값 업데이트
            int need = target - sum;
            if (need < minNeeded[0]) {
                minNeeded[0] = need;
            }
            return -1; // 만들 수 없음
        }

        for (int i = index; i < subset.length; i++) {
            subset[index] = subset[i];
            int result = findNeedRecursive(target, subset, index + 1, minNeeded);
            if (result >= 0) {
                return result;
            }
            subset[index] = 0;
        }

        return -1; // 만들 수 없음
    }
}