import java.util.Scanner;

/**
 * BOJ 9012
 * @author 김정효
 *
 */
public class Main_9012_김정효 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=t; i++) {
			String result = "YES";
			String data = sc.next();
			int l_cnt = 0;
			for(int j=0; j<data.length(); j++) {
				char c = data.charAt(j);
				if(c == '(') {
					l_cnt += 1;
				}else {
					l_cnt -= 1;
					if(l_cnt < 0) {
						result = "NO";
						break;
					}
				}if(j == data.length()-1 && l_cnt > 0 ) {
					result = "NO";
					break;
				}
			}
			System.out.println(result);
		}
	}
}
