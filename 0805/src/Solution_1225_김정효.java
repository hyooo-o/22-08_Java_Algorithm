import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1225_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int j=1; j<=10; j++) {
			Queue<Integer> q = new LinkedList<Integer>();
			int q_end = 0;
			int t = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i=0; i<8; i++) {
				int num = Integer.parseInt(str.split(" ")[i]);
				q.offer(num);
				q_end = num;
			}	//----------입력 완료-----------
			int cnt = 0;
			while (q_end != 0) {
				cnt++;
				q_end = q.peek() - cnt;
				if (q_end <= 0) {
					q_end = 0;
				}
				q.offer(q_end);
				q.remove();
				if(cnt % 5 == 0) {
					cnt %= 5;
				}
			}
			System.out.printf("#%d ", t);
			for(int i=0; i<8; i++) {
				System.out.print(q.poll()+" ");
			}System.out.println();
		}

	}

}
