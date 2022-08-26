import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 7576. �丶�� (�ٽôٽôٽ� �̿ϼ�) - AD��޿��� ����� ��
 * 1: ���� �丶��, 0: ���� ���� �丶��, -1: �丶�䰡 ������� ���� ĭ
 * ����� ������ ��� �丶�䰡 �;��ִ� �����̸� 0  / �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1
 * @author kjh
 *
 */
public class Main_7576_����ȿ {
	
	static class Map{
		int x;
		int y;
		
		public Map(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m, cnt;
	static int[][] arr;
	static Queue<Map> q = new LinkedList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());	// n x m
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {	//	���� �丶�� ť�� �־��ֱ�
					q.add(new Map(i, j));
				}
			}
		}
		search(0, 0);
	}

	static boolean check = false;
	private static void search(int x, int y) {
		if(!q.isEmpty()) {
			Map map = q.poll();
			for (int i = 0; i <4; i++) {	// �����¿� Ž��
				x = map.x + dx[i];
				y = map.y + dy[i];
				if (x>=0 && y>=0 && x<n && y<m) {
//					System.out.println(x+" "+y);
					if(arr[x][y] == -1) continue;
					else if(arr[x][y] == 0) {
						check = true;
						q.add(new Map(x, y));
						arr[x][y] = arr[map.x][map.y]+1;
//						for (int k = 0; k < n; k++) {
//							for (int j = 0; j < m; j++) {
//								System.out.print(arr[k][j]+" ");
//							}
//							System.out.println();
//						}
//						System.out.println("---------");
					}
				}
			}
			search(x, y);
			return;
		}
		if(check) {
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < m; j++) {
					if(arr[k][j] == 0) {
						System.out.println("-1");
						return;
					}
				}
			}
			System.out.println(arr[x][y]);
		}
		else System.out.println("0");
	
	}

}
