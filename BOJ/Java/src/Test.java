class Solution {
    private class Point {
        int r, c;
         Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int[][] map;
    private boolean[][][] visited;

    private int min;

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maze) {

        // 맵복사, 시작 위치 저장
        map = new int[maze.length][maze[0].length];
        visited = new boolean[2][maze.length][maze[0].length];


        Point red = new Point(0, 0);
        Point blue = new Point(0, 0);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 1) {
                    red = new Point(i, j);
                    map[i][j] = 0;
                } else if(maze[i][j] == 2) {
                    blue = new Point(i, j);
                    map[i][j] = 0;
                } else {
                    map[i][j] = maze[i][j];
                }
            }
        }

        visited[0][red.r][red.c] = true;
        visited[0][blue.r][blue.c] = true;

        min = Integer.MAX_VALUE;

        dfs(0, red, blue, true);

        if(min == Integer.MAX_VALUE)
            return 0;
        else if(min % 2 == 0)
            return min/2;
        else
            return min/2+1;
    }

    private void dfs(int cnt, Point red, Point blue, boolean flag) {
        // System.out.println((flag ? "red" : "blue") + " " + cnt + " " + min);
        // print(red, blue);

        if(flag) { // 빨간 수레 움직일 찰{
            if(map[red.r][red.c] == 3) { // 도착해서 움직일 수 없음
                if(map[blue.r][blue.c] == 4) { // 파란 수레도 도착 => 종료
                    min = Math.min(min, cnt);
                    return;
                } else
                    dfs(cnt, red, blue, !flag); // 파란색 탐색
            } else { // 움직임
                for (int i = 0; i < 4; i++) {
                    int row = red.r + dx[i];
                    int col = red.c + dy[i];
                    if(row >= 0 && row < map.length && col >= 0 && col < map[0].length
                        && !visited[0][row][col] && map[row][col] != 5 && !(row == blue.r && col == blue.c)) {
                        visited[0][row][col] = true;
                        dfs(cnt + 1, new Point(row, col), blue, !flag);
                        visited[0][row][col] = false;
                    }
                }
            }
        } else { // 파란 수레 움직일 찰{
            if(map[blue.r][blue.c] == 4) { // 도착해서 움직일 수 없음
                if(map[red.r][red.c] == 3) { // 빨간 수레도 도착 => 종료
                    min = Math.min(min, cnt);
                    return;
                } else
                    dfs(cnt, red, blue, !flag); // 빨간색 탐색
            } else { // 움직임
                for (int i = 0; i < 4; i++) {
                    int row = blue.r + dx[i];
                    int col = blue.c + dy[i];
                    if(row >= 0 && row < map.length && col >= 0 && col < map[0].length
                        && !visited[1][row][col] && map[row][col] != 5 && !(row == red.r && col == red.c)) {
                        visited[1][row][col] = true;
                        dfs(cnt + 1, red, new Point(row, col), !flag);
                        visited[1][row][col] = false;
                    }
                }
            }
        }
    }

    private void print(Point red, Point blue) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(red.r == i && red.c == j) {
                    System.out.println("R ");
                } else if(blue.r == i && blue.c == j) {
                    System.out.println("B ");
                } else {
                    System.out.println(map[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("=============");
    }
}