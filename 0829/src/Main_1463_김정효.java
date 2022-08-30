

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 1463 1로 만들기  (완성)
 * DP로도 풀이 가능
 * @author kjh
 *
 */
public class Main_1463_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		System.out.println(bfs(x, 0));
	}

	private static int bfs(int n, int cnt) {
		if(n < 2) {	// n == 1 로하면 오류남   =>  1이 아니라 0으로 끝날 수도 있기 때문에 2보다 작다고 설정해주어야 함
			return cnt;
		}
		// bfs(n/2, cnt+1+(n%2)) : 2로 나누었으니깐 cnt 횟수를 1 늘려주고, 2로 나누었을 때의 나머지는 빼기 1를 한 것과 같으므로 나머지를 cnt 횟수에 더해줌
		// bfs(n/3, cnt+1+(n%3)) : 3로 나누었으니깐 cnt 횟수를 1 늘려주고, 3로 나누었을 때의 나머지는 빼기 1를 한 것과 같으므로 나머지를 cnt 횟수에 더해줌
		// 둘 중 최소값을 return 해줌
		return Math.min(bfs(n/2, cnt+1+(n%2)), bfs(n/3, cnt+1+(n%3)));
		 
	}

}
