package G4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3190_뱀 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        byte N = Byte.parseByte(br.readLine());
        byte[][] board = new byte[N + 1][N + 1]; // 게임판

        byte K = Byte.parseByte(br.readLine());

        for (int i = 0; i < K; i++) { // 사과 위치 기록 : 1
            st = new StringTokenizer(br.readLine());
            board[Byte.parseByte(st.nextToken())][Byte.parseByte(st.nextToken())] = 1;
        }

        byte L = Byte.parseByte(br.readLine());
        Queue<Turn> que = new ArrayDeque<>(); // 회전 정보 저장

        for (int i = 0; i < L; i++) { // 회전 정보 기록
            st = new StringTokenizer(br.readLine());
            que.add(new Turn(Short.parseShort(st.nextToken()), st.nextToken().charAt(0) == 'L' ? (byte) 3 : (byte) 1));
        }

        // Play
        int answer = playDummy(board, que);

        // Output
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int playDummy(byte[][] board, Queue<Turn> que) {
        // 방향 정보 초기화
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 1; // 뱀은 오른쪽을 보고 시작

        // 좌표 정보 초기화
        Position now = new Position(1, 1);
        board[1][1] = 2;

        // 꼬리 정보
        Queue<Position> tail = new ArrayDeque<>();
        tail.add(new Position(1, 1));

        Turn turn = que.poll();

        int time = 0;

        while (true) {
            // 시간 증가
            time++;


            // 이동
            now.row += dx[direction];
            now.col += dy[direction];

            // 방향 변경
            if (time == turn.X) {
                direction = (direction + turn.C) % 4;
                if (!que.isEmpty()) {
                    turn = que.poll();
                }
            }

            // 게임판 벗어나면 종료
            if (now.row <= 0 || board.length <= now.row || now.col <= 0 || board[0].length <= now.col) {
                return time;
            }

            if (board[now.row][now.col] == 0) { // 일반 이동
                board[now.row][now.col] = 2;
                if (!tail.isEmpty()) { // 꼬리 없앰
                    Position tp = tail.poll();
                    board[tp.row][tp.col] = 0;
                }
                tail.add(new Position(now.row, now.col));
            } else if (board[now.row][now.col] == 1) { // 사과 먹음
                board[now.row][now.col] = 2;
                tail.add(new Position(now.row, now.col));
            } else { // 뱀 몸에 부딪힘
                return time;
            }
        }
    }

    private static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static class Turn {
        short X;
        Byte C;

        public Turn(short x, Byte c) {
            X = x;
            C = c;
        }
    }
}
