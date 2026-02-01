package G5;

import java.io.*;

public class Boj_5639_이진_검색_트리 {
    private static class Node {
        private final int root;
        private Node left;
        private Node right;

        public Node(int root) {
            this.root = root;
        }

        public int getRoot() {
            return root;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String str = null;

        // Pre Order

        while ((str = br.readLine()) != null) {
            make_tree(root, Integer.parseInt(str));
        }

        // Post Order

        StringBuilder sb = new StringBuilder();

        travel_tree(root, sb);

        // Output
        bw.write(sb.toString());
        bw.flush();
    }

    private static void make_tree(Node node, int num) { // Pre order
        if (node.getRoot() > num) { // left
            if (node.getLeft() == null) {
                node.setLeft(new Node(num));
            } else {
                make_tree(node.getLeft(), num);
            }
        } else { // right
            if (node.getRight() == null) {
                node.setRight(new Node(num));
            } else {
                make_tree(node.getRight(), num);
            }
        }
    }

    private static void travel_tree(Node node, StringBuilder sb) { // Post order
        // left
        if (node.getLeft() != null) {
            travel_tree(node.getLeft(), sb);
        }

        // right
        if (node.getRight() != null) {
            travel_tree(node.getRight(), sb);
        }

        // root
        sb.append(node.getRoot()).append('\n');
    }
}