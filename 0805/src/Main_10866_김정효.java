import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_10866_김정효 {
/**
 * 22/08/05
 * BOJ 10866 덱
 * deque 사용
 * @param args
 * @throws IOException 
 */
	static Deque<Integer> deque = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			String[] str = br.readLine().split(" ");
			switch(str[0]) {
			case ("push_front"):{
				push_front(Integer.parseInt(str[1]));
				break;
			}
			case ("push_back"):{
				push_back(Integer.parseInt(str[1]));
				break;
			}case ("pop_front"):{
				sb.append(pop_front()).append("\n");
				break;
			}case ("pop_back"):{
				sb.append(pop_back()).append("\n");
				break;
			}case ("size"):{
				sb.append(size()).append("\n");
				break;
			}case ("empty"):{
				sb.append(empty()).append("\n");
				break;
			}case ("front"):{
				sb.append(front()).append("\n");
				break;
			}case ("back"):{
				sb.append(back()).append("\n");
				break;
			}
			}
			System.out.print(sb);
		}
	}
	
	static void push_front(int n) {
		deque.addFirst(n);
	}
	
	static void push_back(int n) {
		deque.addLast(n);
	}
	
	static int pop_front() {
		if(deque.isEmpty()) return -1;
		return deque.pollFirst();
	}
	
	static int pop_back() {
		if(deque.isEmpty()) return -1;
		return deque.pollLast();
	}
	
	static int size() {
		return deque.size();
	}

	static int front() {
		if(deque.isEmpty()) return -1;
		return deque.peekFirst();
	}
	
	static int back() {
		if(deque.isEmpty()) return -1;
		return deque.peekLast();
		
	}
	
	static int empty() {
		if(deque.isEmpty()) return 1;
		return 0;
	}
	
}
