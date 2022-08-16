import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_김정효 {
	static int T, num1, num2;
	static boolean[] check;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		arr = new int[T][2];
		check = new boolean[T];
		num1 = 1;
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		
	}
	
	private static void subset(int index) {
		if (index == T) {
			
		}
		
		check[index] = true;
		num1 *= arr[index][0];
		check[index] = false;
		subset(index+1);
	}

}
