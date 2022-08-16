import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * BOJ 1935 후위 표기식2
 * stack 사용
 * 알파벳을 직접 숫자로 변환시, 런타임 에러 => map 또는 아스키코드 계산 이용
 * @author kjh
 *
 */
public class Main_1935_김정효 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		double[] arr = new double[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {	// 알파벳일 때,
				stack.push(arr[str.charAt(i)-'A']);				// 런타임 에러 발생 주의
			}else {			// 산술연산일 때,
				double b = stack.pop();
				double a = stack.pop();
				
				switch(str.charAt(i)) {
				case ('*'):
					stack.push(a*b);
					break;
				case ('/'):
					stack.push(a/b);
					break;
				case ('+'):
					stack.push(a+b);
					break;
				case ('-'):
					stack.push(a-b);
					break;
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
