import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * SWEA 1218 괄호 짝짓기
 * 1. 단순 구현 (현재 클래스)
 * 2. 스택
 * @author kjh
 *
 */
public class Solution_1218_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=10; i++) {
			int t = Integer.parseInt(br.readLine());
			int result = 1;
			char[] str = br.readLine().toCharArray();
			int o1 = 0, o2 = 0, o3 = 0, o4 = 0;		// 여는 괄호 개수
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;		// 닫는 괄호 개수
			for(int j=0; j<t; j++) {
				if(str[j] == '{') {
					o1++;
				}else if(str[j] == '[') {
					o2++;
				}else if(str[j] == '(') {
					o3++;
				}else if(str[j] == '<') {
					o4++;
				}else if(str[j] == '}') {
					c1++;
				}else if(str[j] == ']') {
					c2++;
				}else if(str[j] == ')') {
					c3++;
				}else if(str[j] == '>') {
					c4++;
				}
				if(o1<c1 || o2<c2 || o3<c3 || o4<c4) {
					result = 0;
					break;
				}
			}
			if(o1==c1 && o2==c2 && o3==c3 && o4==c4) {
				result = 1;
			}
			System.out.printf("#%d %d%n", i, result);
			
		}
	}

}
