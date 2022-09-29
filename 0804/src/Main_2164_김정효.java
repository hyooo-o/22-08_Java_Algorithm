

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
/**
 * BOJ 2164 카드2
 * 큐
 * @author kjh
 *
 */
public class Main_2164_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int q_end = n;		// 큐의 마지막 값
		
		for (int i=1; i<=n; i++) {	// 큐에 1~n 번호 적힌 카드 넣어줌
			q.offer(i);
		}
		
		while (q.size() > 1) {	// 카드가 한 장 남으면 종료
			q.remove();
			if (q.size() > 1) {
				q_end = q.poll();
				q.offer(q_end);
				continue;
			}break;
		}
		System.out.println(q_end);
	}

}
