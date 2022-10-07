import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * BOJ 9205 맥주 마시면서 걸어가기 (플로이드 워샬)
 * - 플로이드 워샬의 정석적인 풀이
 * @author multicampus
 *
 */
public class Main_9205_김정효 {
	static int N, data[][], distance[][], drink;
	static String result;
	static boolean visit[];
	static List<Integer> store = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());	// 편의점 개수	
			result = "sad";
			// 집(0), 편의점, 락(data.length)
			data = new int[N+2][2];
			distance = new int[N+2][N+2];	// i->j 거리 넣은 배열
			visit = new boolean[N+2];
			
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j <2; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N+1; i++) {
				for (int j = i+1; j <N+2; j++) {
					distance[i][j] = Math.abs(data[i][0]-data[j][0]) + Math.abs(data[i][1]-data[j][1]);
					if (distance[i][j] > 1000) {
						distance[i][j] = -1;
						distance[j][i] = -1;
					}
				}
			}
			floyd();
			sb.append(distance[0][N+1]==-1? "sad": "happy").append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void floyd() {
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				if (i == j) continue;
				for (int k = 0; k < N+2; k++) {
					if (i==k || j==k) continue;
					if (distance[i][j]==-1 || distance[i][k]==-1) continue;
					distance[j][k] = 1;
				}
			}
		}
	}
}
