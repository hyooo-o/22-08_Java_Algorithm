import java.util.*;

class Main {
    private static int N;
    private static int[][] map;
    private static boolean[][] isUnderWatered; //물에 잠겼는지
    private static int answer = 0;
    private static int count = 0;
    private static List<Integer> heightList = new ArrayList<>(); //물 높이 경우의 수 리스트
    private static int[] dr = new int[]{-1, 0, 1, 0};
    private static int[] dc = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
                if (!heightList.contains(map[r][c])) heightList.add(map[r][c]); 
            }
        }
        heightList.add(0);
        Collections.sort(heightList);
        for (int height : heightList) {
            isUnderWatered = new boolean[N][N];
            count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] <= height) {
                        isUnderWatered[r][c] = true;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isUnderWatered[i][j]) bfs(i, j);
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    private static void bfs(int _r, int _c) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(_r, _c));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int r = point.r;
            int c = point.c;
            for (int i = 0; i < 4; i++) {
                int r2 = r + dr[i];
                int c2 = c + dc[i];
                if ((r2 >= 0 && c2 >= 0 && r2 < N && c2 < N) && !isUnderWatered[r2][c2]) {
                    isUnderWatered[r2][c2] = true;
                    queue.offer(new Point(r2, c2));
                }
            }
        }
        count++;
    }

    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
