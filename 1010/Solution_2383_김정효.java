import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 1. 사람~계단1, 2 각각 거리 구해서 저장해 놓기
 * 2. 계단 2개 중 1개 선택하는 부분집합 (사람 최대 10명이니깐 2^10 OK)
 * 3. 최대 3명, 나머지 대기 => 시간 측정
 * 
 * @author kjh
 *
 */
public class Solution_2383_김정효 {
	static int N, map[][], _min;
	static List<int[]> person, stair, d;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			person = new ArrayList<>();
			d = new ArrayList<>();
			_min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {	// 사람 위치 저장
						person.add(new int[] {i, j});
					} else if (map[i][j] > 1) {	// 계단 위치 저장
						stair.add(new int[] {i, j, map[i][j]});
					}
				}
			}
			
			for (int i = 0; i < person.size(); i++) {
				stair.add(new int[] {});
			}
			
			visit = new boolean[person.size()];
			distance();
			sb.append("#").append(tc).append(" ").append(_min).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 사람~계단1, 2 각각에 대한 거리 구하기
	private static void distance() {
		for (int i = 0; i < person.size(); i++) {
			for (int j = 0; j < 2; j++) {
				d.get(i)[j] = Math.abs(person.get(i)[0]-stair.get(j)[0]) + Math.abs(person.get(i)[1]-stair.get(j)[1]);
			}
		}
		
	}

	// 모든 사람에 대해 계단1을 선택하던가, 안하던가(계단2 선택)
	private static void subset(int cnt) {
		if (cnt == person.size()) {	// 모든 사람에 대한 선택 끝나면
			go();	// 최소 시간 찾기
			return;
		}
		
		visit[cnt] = true;
		subset(cnt+1);
		visit[cnt] = false;
		subset(cnt+1);
	}
	
	
	private static void go() {
		PriorityQueue<Integer> s1 = new PriorityQueue<>();
		PriorityQueue<Integer> s2 = new PriorityQueue<>();
		int cnt = person.size();	// 계단을 내려가지 않은 남은 인원
		int[] st1 = new int[3];		// 계단에 있는 인원
		int[] st2 = new int[3];
		
		// visit=true => 계단1, visit=false => 계단2
		for (int i = 0; i < person.size(); i++) {
			if (visit[i]) {
				s1.offer(d.get(i)[0]);
				continue;
			}
			s2.offer(d.get(i)[1]);
		}
		
		int time = 0;
		while (true) {
			if (cnt == 0) {
				boolean flag = true;
				for (int i = 0; i < 3; i++) {
					if (st1[i] != 0) {
						flag = false;
						break;
					}
					if (st2[i] != 0) {
						flag = false;
						break;
					}
				}
				if (flag) break;
			}
			
			
			
			for (int i = 0; i < 3; i++) {
				// 계단1
				// 계단을 이용하는 사람이 없고, 계단 대기자가 있다면
				if (st1[i] == 0) {
					if(!s1.isEmpty()) {
						if (s1.peek() <= time) {	// 도착했다면
							cnt--;					// 남은 대기자-1
							st1[i] = stair.get(0)[2];	// 계단 길이 주기
							s1.poll();
						}
					}
				} else {	// 계단 이용자가 있다면
					st1[i]--;
					if (st1[i] == 0) {
						if(!s1.isEmpty()) {
							if (s1.peek() <= time) {	// 도착했다면
								cnt--;					// 남은 대기자-1
								st1[i] = stair.get(0)[2];	// 계단 길이 주기
								s1.poll();
							}
						}
					}
				}
				// 계단2
				if (st2[i] == 0) {
					if(!s2.isEmpty()) {
						if (s2.peek() <= time) {	// 도착했다면
							cnt--;					// 남은 대기자-1
							st2[i] = stair.get(1)[2];	// 계단 길이 주기
							s2.poll();
						}
					}
				} else {	// 계단 이용자가 있다면
					st2[i]--;
					if (st2[i] == 0) {
						if(!s2.isEmpty()) {
							if (s2.peek() <= time) {	// 도착했다면
								cnt--;					// 남은 대기자-1
								st2[i] = stair.get(1)[2];	// 계단 길이 주기
								s2.poll();
							}
						}
					}
				}
			}
			time++;
		}
		_min = Math.min(_min, time);
	}
}
