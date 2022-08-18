import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA
 * 시뮬레이션 (구현 방법)
 * 완전탐색 (알고리즘 5가지 중 하나) - 제한시간 안에 풀 수 있는지?  => (20*20)*400 = 16만 이니깐 가능.
 * 맨하탄 거리
 * k 범위 문제 오류로 안나와있는데 추리해보면, 1<=k<=39 임.
 * @param args
 * @throws IOException 
 */

public class Solution_2117_김정효 {
	private static int[] cost = {1,1,5,13,25,41,61,85,113,145,181,221,265,313,365,421,481,545,613,685,761,841,925,1013,1105,1201,1301,1405,1513,1625,1741,1861,1985,2113,2245,2381,2521,2665,2813,2965,3121};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);	// 크기 미리 정해두면 속도 조금 이득
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 도시의 크기 N, 5 <= N <= 20;
			int M = Integer.parseInt(st.nextToken());	// 집에서 지불할 비용  M, 1 <= M <= 10;
			
			List<int[]> home = new ArrayList<int[]>();	// {행, 열}
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0, index = 0; c < N; c++, index += 2) {
					if (s.charAt(index) == '1') { // 집이면 '1' 
						home.add(new int[] {r, c});	// {행, 열}
					}
				}
			}
			// 운영 비용 = K * K + (K - 1) * (K - 1)
			int maxCntHome = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int k = 1; k <= 40; k++) {
						int cntHome = 0;
						for (int h = 0; h < home.size(); h++) {
//							r, c home.get(h) = {r, c};
							if(Math.abs(home.get(h)[0]-r) + Math.abs(home.get(h)[1]-c) < k){
								cntHome++;
							}
						}
						if (cntHome * M >= cost[k] && maxCntHome < cntHome) {
								maxCntHome = cntHome;
							}
						}
					}
				}
			sb.append("#").append(testCase).append(" ").append(0).append("\n");
		}	// end of testCase
		System.out.println(sb.toString());
	}	// end of main

}	// end of class
