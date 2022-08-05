import java.util.Scanner;
/**
 * BOJ 9012
 * @author 김정효
 *
 */
public class BOJ_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=t; i++) {
			String result = "YES";
			String[] data;
			data = sc.nextLine().split("");  
			if(data[0] == ")") {
				result = "NO";
				break;
			}else {
				int l_cnt = 1;
				for(int j=1; j<data.length; j++) {	// 인덱스0은 어차피 "(" 이니깐 1부터 시작
					if(data[j] == "(") {
						l_cnt += 1;
					}
					else {
						l_cnt -= 1;
						if(l_cnt < 0) {
							result = "NO";
							break;
						}
					}
				}
			}
			System.out.println(result);
		}

	}

}
