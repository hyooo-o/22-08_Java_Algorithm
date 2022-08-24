import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1373_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		String str = br.readLine();
		int _sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i)-'0');
		}
		for (int i = 0; i < str.length(); i++) {
			_sum += stack.peek() * (int)Math.pow(2, (i%3));
			if(i%3 == 2) {
				sb.append(_sum);
				_sum = 0;
			}
			else if(i%3 == 0){
				if(stack.size() < 3) {
					while(!stack.isEmpty()) {
						stack.pop();
						_sum += stack.peek() * (int)Math.pow(2, (i+1)%3);
						sb.append(_sum);
					}
					break;
				}
			}
			stack.pop();
		}
		System.out.println(sb.reverse());

	}

}
