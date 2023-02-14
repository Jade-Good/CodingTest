    package S1;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class boj_14888 {
        private static int n, max, min;
        private static int[] numbers, orders, picks;
        private static boolean[] used;

        public static void test(String s) throws IOException {
            StringTokenizer st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            numbers = new int[n];
            orders = new int[n - 1];
            picks = new int[n - 1];
            used = new boolean[n - 1];

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            for (int i = 0; i < 4; i++) {
                int count = Integer.parseInt(st.nextToken());
                for (int j = 0; j < count; j++) {
                    orders[idx++] = i;
                }
            }

            perm(0);

            System.out.println(max + "\n" + min);
        }

        private static void perm(int idx) { // 연산자 순서 순열, idx : orders에서 현재 고른 연산자 수
            if (idx == n - 1) { // 연산자 모두 고름
    //            System.out.println(Arrays.toString(picks));
                cal_all();
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (!used[i]) { // orders의 i번째 연산자 사용 안했으면 사용
                        used[i] = true;
                        picks[idx] = orders[i]; // 사용 연산자 기록
                        perm(idx + 1);      // 순열 재귀
                        used[i] = false;
                    }
                }
            }
        }

        private static void cal_all() {
    //        print();
            int num = numbers[0];
            for (int i = 1; i < n; i++) {
                num = calc(num, numbers[i], picks[i - 1]);
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        private static int calc(int num1, int num2, int order) {
            switch (order) {
                case 0:
                    return num1 + num2;
                case 1:
                    return num1 - num2;
                case 2:
                    return num1 * num2;
                case 3:
                    return num1 / num2;
            }
            return 0;
        }

        private static void print() {
            char[] os = {'+', '-', '*', '/'};
            System.out.print(max + " " + min + " " + numbers[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + os[picks[i - 1]] + " " + numbers[i]);
            }
            System.out.println();
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            numbers = new int[n];
            orders = new int[n - 1];
            picks = new int[n - 1];
            used = new boolean[n - 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                int count = Integer.parseInt(st.nextToken());
                for (int j = 0; j < count; j++) {
                    orders[idx++] = i;
                }
            }

            perm(0);

            System.out.println(max + "\n" + min);
        }
    }
