import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 부분집합 구현 복습
 * @author kjh
 *
 */
public class Subset {
	static int N, result;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		sub(0);
		System.out.println(result);
	}
	
	private static void sub(int index) {
		if(index == N) {
			result++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]){
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		isSelected[index] = true;
		sub(index+1);
		isSelected[index] = false;
		sub(index+1);
	}

}
