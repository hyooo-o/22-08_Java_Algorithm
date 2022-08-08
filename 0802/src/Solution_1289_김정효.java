import java.util.Scanner;

public class Solution_1289_김정효 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=t; i++) {
			int cnt = 0;
			String data = sc.nextLine();
			// next(): 스트링 문자열로 데이터 읽어 옴, 공백 전까지 앞의 개행문자 무시하고 읽어 옴
			// nextLine(): \n까지 읽고, \n버린 뒤 나머지 앞 문자열 읽어 옴
			int[] arr = new int[data.length()];
			for(int j=0; j<arr.length; j++) {
				arr[j] = data.charAt(j)-'0';
			}
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == 1) {
					arr[j] = 0;
					for(int k=j+1; k<arr.length; k++) {
						if (arr[k] == 1) {
							arr[k] = 0;
						}else {
							arr[k] = 1;
						}
					}
					cnt += 1;
				}
			}
			System.out.printf("#%d %d%n", i, cnt);
		}

	}

}
