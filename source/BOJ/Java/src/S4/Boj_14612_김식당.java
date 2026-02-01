package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_14612_김식당 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Order> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if (str.equals("order")) {

                list.add(new Order(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            } else if (str.equals("sort")) {

                list.sort((o1, o2) -> {
                    if (o1.time != o2.time) {
                        return o1.time - o2.time;
                    }
                    return o1.table - o2.table;
                });

            } else {
                int target = Integer.parseInt(st.nextToken());

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).table == target) {
                        list.remove(j);
                        break;
                    }
                }
            }

            if (!list.isEmpty()) {
                for (Order o : list) {
                    sb.append(o.table).append(' ');
                }
                sb.append('\n');
            } else {
                sb.append("sleep\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Order implements Comparable<Order> {
        int table;
        int time;

        public Order(int table, int time) {
            this.table = table;
            this.time = time;
        }

        public int compareTo(Order o) {
            if (this.time != o.time) {
                return this.time - o.time;
            }
            return this.table - o.table;
        }
    }
}
