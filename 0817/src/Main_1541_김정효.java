import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * 1. - �� ������ - �ڿ� ���� �� ���ϱ�
 * 2. ���� �� - �ٿ��ֱ�
 * 3. ���� �� ���ϱ�
 * @author multicampus
 *
 */
public class Main_1541_����ȿ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sub_total = 0;
		int total = 0;
		String[] minus = br.readLine().split("-");
		for (int i = 0; i < minus.length; i++) {
			if(minus[i].contains("+")) {
				String[] plus = minus[i].split("\\+");
				if(i != 0) {
					for (int j = 0; j < plus.length; j++) {
						sub_total += Integer.parseInt(plus[j]);
					}
					total += -sub_total;
				}else {
					for (int j = 0; j < plus.length; j++) {
						sub_total += Integer.parseInt(plus[j]);
					}
					total += sub_total;
				}
				sub_total = 0;
			}else if(i == 0) {
				total += Integer.parseInt(minus[0]);
			}else {
				total -= Integer.parseInt(minus[i]);
			}
		}
		System.out.println(total);
		
		
		

	}

}
