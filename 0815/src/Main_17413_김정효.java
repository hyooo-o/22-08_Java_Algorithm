import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * BOJ 17413 문자열 뒤집기2
 * stack 사용
 * @author kjh
 *
 */
public class Main_17413_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean check = false;	// 괄호 안, 밖 확인
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// 괄호 시작
			if (c == '<') {
				check = true;				// 괄호 안
				while(!stack.isEmpty()) {	// 스택 안에 단어가 있다면 다 빼기
					sb.append(stack.pop());
				}
				sb.append(c);				// 스택이 비어있으면 < > 안에 있는 문자열 sb에 붙이기
			}
			// 괄호 안: true
			else if (check) {
				sb.append(c);
				if (c == '>') {				// 괄호 끝
					check = false;				// 괄호 나옴
				}
			}
			// 괄호 밖: false
			else if (!check) {
				if (c == ' ') {				// 공백 만나면
					while(!stack.isEmpty()) {	// stack이 빌 때까지, 빼기
						sb.append(stack.pop());
					}
					sb.append(' ');
					continue;
				}
				stack.push(c);				// 단어 or 숫자: stack에 넣기
			}
		}
		
		// 문자열을 스택에 다 넣었지만 스택이 비어있지 않다면
		while(!stack.isEmpty()) { // stack이 빌 때까지, 빼기 isEmpty: 스택이 비어있을 때 true 반환
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

}
