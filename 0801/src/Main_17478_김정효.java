import java.util.Scanner;

/**
 * BOJ 17478 재귀 함수가 뭔가요?
 * @author kjh
 *
 */
public class Main_17478_김정효 {
	static int cnt = 0;
	static int res(int n) {
		if (n < 0) {
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			return ans(cnt);
		}
		
		for(int j=0; j<cnt; j++) {
			System.out.print("____");			
		}
		System.out.println("\"재귀함수가 뭔가요?\"");
		
			for(int j=0; j<cnt; j++) {
				System.out.print("____");			
			}
		if (n > 0) {
			System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			
			for(int j=0; j<cnt; j++) {
				System.out.print("____");			
			}
			System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			
			for(int j=0; j<cnt; j++) {
				System.out.print("____");			
			}
			System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		}
		cnt += 1;
		return res(n-1);
	}
	
	static int ans(int n) {
		if (n < 1) return 1;
		for(int j=1; j<cnt; j++) {
			System.out.print("____");			
		}
		cnt -= 1;
		System.out.println("라고 답변하였지.");
		return ans(n-1);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		res(N);
		
		

	}

}
