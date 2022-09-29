package algorithm_0804;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {

		static int N, R, totalCnt;
		static int[] numbers, input;
		static boolean[] isSeleted;
		
		//nPn: n개의 입력 받은 수 중 n개를 모두 뽑아 순서적으로 나열한 것 (입력 받은 수: 1~10만)
		//nPr: n개의 입력 받은 수 중 r개를 모두 뽑아 순서적으로 나열한 것 (1<=r<=n)
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			R = sc.nextInt();
			totalCnt = 0;
			
			input = new int[N];
			numbers = new int[R];
			isSeleted = new boolean[N+1];	// 입력 받은 수의 개수 만큼 할당
			
			for (int i = 0; i < N; i++) {
				input[i] = sc.nextInt();
				
			}
			perm(0);
			System.out.println("총 경우의 수: "+totalCnt);
		}
		
		private static void perm(int cnt) { // cnt: 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1번째 해당하는 순열에 포함될 수를 뽑기
			if(cnt==R) {
				totalCnt++;
				System.out.println(Arrays.toString(numbers));
				return;
			}
			// 가능한 모든 수에 대해 시도
			for (int i = 0; i < N; i++) {		// 배열의 모든 원소인 선택지
				// 시도하는 수가 선택되었는지 판단
				if(isSeleted[i]) continue;
				// 앞쪽에서 선택되지 않았다면 수를 사용
				numbers[cnt] = input[i];
				isSeleted[i] = true;
				// 다음 수 뽑으러 감
				perm(cnt+1);
				// 뽑고 나면, 사용했던 수에 대해 선택 되돌림
				isSeleted[i] = false;
			}
			
			
		}

	}
