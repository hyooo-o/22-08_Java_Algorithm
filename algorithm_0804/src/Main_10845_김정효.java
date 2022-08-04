

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10845_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		int q_end = 0;
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			switch (str[0]) {
				case ("push"): {
					q_end = Integer.parseInt(str[1]);
					q.add(q_end);
					break;
				}
				case ("pop"): {
					if (q.isEmpty()) {
						System.out.println("-1");
						continue;
					}
					System.out.println(q.poll());
					break;
				}
				case ("size"): {
					System.out.println(q.size());
					break;
				}
				case ("empty"): {
					if (q.isEmpty()) {
						System.out.println("1");
						continue;
					}
					System.out.println("0");
					break;
				}
				case ("front"): {
					if (q.isEmpty()) {
						System.out.println("-1");
						continue;
					}
					System.out.println(q.peek());
					break;
				}
				case ("back"): {
					if (q.isEmpty()) {
						System.out.println("-1");
						continue;
					}
					System.out.println(q_end);
					break;
				}
			}
		}

	}

}
