import java.util.Scanner;

/**
 * BOJ 1244 스위치 켜고 끄기
 * @author kjh
 *
 */
public class Main_1244_김정효 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n+1];
		for (int i=1; i<n+1; i++) {
			 arr[i] = sc.nextInt();
		}
		int std = sc.nextInt();
		for (int i=0; i<std; i++) {
			 int s = sc.nextInt();
			 if (s == 1) {
				 int num = sc.nextInt();
				 for (int j=1; j<n+1; j++) {
					 if(j % num == 0) {
						 if(arr[j] == 0) {
							 arr[j] = 1;
						 }else {
							 arr[j] = 0;
						 }
					 }
				}
			 }
			 else {
				 int num = sc.nextInt();
				 if (num > 1 && num < n) {
					 for(int j=1; j<n/2; j++) {
						 if(num-j > 0 && num+j <= n && arr[num+j] == arr[num-j]) {
							 if(arr[num+j] == 0) {
								 arr[num+j] = 1;
								 arr[num-j] = 1;
							 }else {
								 arr[num+j] = 0;
								 arr[num-j] = 0;
							 }
						 }else {
							 break;
						 }
					 }
					 
				 }if(arr[num] == 0) {
					 arr[num] = 1;
				 }else {
					 arr[num] = 0;
				 }
			 }
		}
		for(int i=1; i<n+1; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}

	}

}
