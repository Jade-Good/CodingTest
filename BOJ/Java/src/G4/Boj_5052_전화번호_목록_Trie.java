package G4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Boj_5052_전화번호_목록_Trie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isConsistent = true;

            for (int i = 0; i < n; i++) {
                if (!trie.insert(br.readLine().toCharArray()))
                    isConsistent = false;
            }
            if (isConsistent)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static class Trie { // 트라이 알고리즘

        private final Node rootNode = new Node(); // 루트 노드 싱글톤 생성

        public boolean insert(char[] chars) {
            Node node = rootNode; // 루트 노드부터 시작
            boolean isNewNodeCreated = false;

            for (char c : chars) { // 해당 key가 없으면 만들어 반환, 있으면 그 value를 반환
                if (!node.chiledNode.containsKey(c)) {
                    node.chiledNode.put(c, new Node());
                    isNewNodeCreated = true;
                }
                node = node.chiledNode.get(c);
                if (node.isEnd) { // 다른 번호가 이 번호의 접두어임
                    return false;
                }
            }

            if (!isNewNodeCreated) {
                return false; // 이 번호가 다른 번호의 접두어임
            }

            node.isEnd = true; // 문자열의 마지막이 되는 노드임
            return true;
        }
    }

    private static class Node {
        final Map<Character, Node> chiledNode;
        boolean isEnd;

        public Node() {
            this.chiledNode = new HashMap<>();
            this.isEnd = false;
        }
    }
}
