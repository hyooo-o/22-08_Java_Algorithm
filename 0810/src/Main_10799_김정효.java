import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 10799 쇠막대기
 * 08/10
 * 문자열 잘라서 규칙 찾기
 * @author kjh
 *
 */
public class Main_10799_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;		// '('의 개수 == 쇠 막대기 개수
		int total = 0;		// 전체 쇠막대기 조각 개수
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(') {	
				if(str.charAt(i+1) == ')') {	// '()'이면,
					total += cnt;				// 앞서 나왔던 '('의 개수 == 쇠 막대기 개수, 만큼 누적 더하기
					i++;						// '(' 다음이 ')'인 것을 아니깐 i++로 다음 인덱스는 검사 안하고 넘어가기
				}else {							// '(('이면,
					cnt += 1;					// 쇠 막대기 조각 추가
				}
			}else {								// ')'이면,
				cnt -= 1;						// 쇠 막대기 길이가 끝났으므로 쇠막대기 개수 감소
				total += 1;						// 쇠 막대기 조각 개수 추가
			}
		}
		System.out.println(total);
	}

}
