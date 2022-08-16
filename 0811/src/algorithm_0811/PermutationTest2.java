package algorithm_0811;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {

		static int N, R, totalCnt;
		static int[] numbers, input;
		
		//nPn: n개의 입력 받은 수 중 n개를 모두 뽑아 순서적으로 나열한 것 (입력 받은 수: 1~10만)
		//nPr: n개의 입력 받은 수 중 r개를 모두 뽑아 순서적으로 나열한 것 (1<=r<=n)
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			R = sc.nextInt();
			totalCnt = 0;
			
			input = new int[N];
			numbers = new int[R];
			
			for (int i = 0; i < N; i++) {
				input[i] = sc.nextInt();
				
			}
			perm(0, 0);
			System.out.println("총 경우의 수: "+totalCnt);
		}
		
		// flag: 선택된 수들의 상태를 비트로 표한하고 있는 비트열(정수)
		private static void perm(int cnt, int flag) { // cnt: 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1번째 해당하는 순열에 포함될 수를 뽑기
			if(cnt==R) {
				totalCnt++;
				System.out.println(Arrays.toString(numbers));
				return;
			}
			// 가능한 모든 수에 대해 시도
			for (int i = 0; i < N; i++) {		// 배열의 모든 원소인 선택지
				// 시도하는 수가 선택되었는지 판단
				if((flag & 1<<i) != 0)  continue;
				// 앞쪽에서 선택되지 않았다면 수를 사용
				numbers[cnt] = input[i];
				// 다음 수 뽑으러 감
				perm(cnt+1, flag | (1<<i));
				// 뽑고 나면, 사용했던 수에 대해 선택 되돌림
			}
			
			
		}
/*
 *  매개변수: `boolean[] isSelected` → `int flag` - `i` 인덱스 사용 여부 체크: `isSelected[i] == true` → `(flag & 1 << i ) != 0`
 *  사용 체크 / 사용 체크 해제 - `isSelected[i] = true, isSelected[i] = false` → `perm(cnt + 1, **flag | 1 << i**)` → `&` : 조건 판단 → `|` : 상태 누적 → `<<` : 자리 이동
 *  비트열의 값이 중요한 게 아니라, 해당 자리(index)에 해당하는 값의 사용을 검사하는 용도 - 비트로 접근해야 함 - `int` → `boolean[32]` - `long` → `boolean[64]`
 */
	}
