package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1068_트리 {
    private static int N, cnt;
    private static Node[] adjList;
    private static boolean[] visit;
    public static void test (String s) throws IOException {
        // Input
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        adjList = new Node[N];

        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] check = new boolean[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) {
                check[i] = true;
                adjList[i] = null;
            }
            else if (check[num]) {
                check[i] = true;
                adjList[num] = new Node(i, adjList[num]);
                adjList[i] = new Node(i, null);
            }
            else {
                queue.add(new Pair(i, num));
            }
        }

        print();

        // Delete node
        delete_Child(Integer.parseInt(st.nextToken()));
        print();

        // Output
        visit = new boolean[N];
        dfs(0);
        System.out.println(cnt);
    }
    private static void dfs(int v) {
        if (adjList[v] != null) {

        }
    }

    private static void delete_Child(int num) {
        // 자식 노드 제거
        if (adjList[num].link != null) {
            for (Node temp = adjList[num]; temp != null; temp = temp.link) {
                if (temp.vertex != num)
                    delete_Child(temp.vertex);
            }
        }
        adjList[num] = null;
    }

    private static class Node{
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", link=" + link +
                    '}';
        }
    }
    private static class Pair{
        int i, num;

        public Pair(int i, int num) {
            this.i = i;
            this.num = num;
        }
    }

    private static void print(){
        for (Node node :
                adjList) {
            System.out.println(node);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ) ;

    }
}