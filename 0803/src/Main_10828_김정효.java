import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.naming.InterruptedNamingException;

public class Main_10828_김정효 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String data = st.nextToken();
			if(data.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}else if(data.equals("pop")){
				if(stack.empty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.pop());
				}
			}else if(data.equals("size")){
				System.out.println(stack.size());
			}else if(data.equals("empty")){
				if (stack.empty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}else if(data.equals("top")){
				if(stack.empty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.peek());
				}
				
			}
		}
	}
}
