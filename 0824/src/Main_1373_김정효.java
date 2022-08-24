import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * BOJ 1373. 2진수 8진수
 * stack사용
 * 1. 스택에 숫자 하나씩 저장
 * 2. 하나씩 꺼내서 2의 (0, 1, 2) 제곱 중 어느 자리인지 확인
 * 3. 3자리씩 확인 후 sb에 붙여주기
 * @author kjh
 *
 */
public class Main_1373_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		String str = br.readLine();
		int _sum = 0;
		// 스택에 숫자 하나씩 넣기
		for (int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i)-'0');
		}
		
		for (int i = 0; i < str.length(); i++) {
			_sum += stack.peek() * (int)Math.pow(2, (i%3));	// 한 자리씩 계산
			if(i%3 == 2) {	// (0, 1, 2) 중 마지막 2이면 sb에 합계 붙여주기
				sb.append(_sum);
				_sum = 0;
			}
			else if(i%3 == 0){	// (0, 1, 2) 중에서 0이면서 스택에 남아 있는 원소가 3개 미만이면
				if(stack.size() < 3) {
					stack.pop();
					while(!stack.isEmpty()) {	// 스택이 빌 때까지 합계 구해서 sb에 붙여주기
						_sum += stack.peek() * (int)Math.pow(2, (i+1)%3);
						stack.pop();
					}
					sb.append(_sum);
					break;
				}
			}
			stack.pop();
		}
		// 뒤에서부터 확인했으니 거꾸로 출력
		System.out.println(sb.reverse());

	}

}
