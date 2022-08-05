import java.util.Scanner;

public class Solution_1873_김정효 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();		// TC 개수
		int h = sc.nextInt();		// 높이
		int w = sc.nextInt();		// 너비
		//상하좌우
		int[][] udlr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for(int k=1; k<=t; k++) {			// TC 시작
			char[][] arr = new char[h][w];
			char n_d='N';					// 현재 내가 보고 있는 방향
			int x=0, y=0, dx=0, dy=0;
			for(int i=0; i<h; i++) {		// 맵 입력 받기
				String str = sc.next();
				for(int j=0; j<w; j++) {
					arr[i][j] = str.charAt(j);
					switch(arr[i][j]) {		// 포차 위치, 방향 찾기
						case ('<'):{
							x=i;
							y=j;
							n_d = 'L';
						}
						case ('>'):{
							x=i;
							y=j;
							n_d = 'R';
						}
						case ('^'):{
							x=i;
							y=j;
							n_d = 'U';
						}
						case ('v'):{
							x=i;
							y=j;
							n_d = 'D';
						}
					}
				}
			}//--------- 배열 입력 완료--------
			int N = sc.nextInt();			// 방향 개수 받기
			char[] d = new char[N];
			String user_str = sc.next();
			for(int i=0; i<N; i++) {		// 방향 받기
				d[i] = user_str.charAt(i);
				//--------사용자 입력 완료--------
				switch(d[i]) {		
					case ('S'):{
						if(n_d == 'U') {
							dx = x + udlr[0][0];
							if(arr[dx][y] == '.') {
								for(int m=1; m<=h-x; m++) {
									dx = x + udlr[0][0]*m;
									if(dx == 0) {
										x = x + udlr[0][0];
									}
									if(arr[dx][y] == '*') {
										n_d = 'U';
										arr[dx][y] = '.';
										arr[x][y] = '^';
										break;
									}else if(arr[dx][y] == '#') {
										break;
									}
								}
							}
						}
						else if(n_d == 'D') {
							dx = x + udlr[0][0];
							if(arr[dx][y] == '.') {
								for(int m=1; m<=h-x; m++) {
									dx = x + udlr[1][0]*m;
									if(dx == h-1) {
										x = x + udlr[1][0];
									}
									if(arr[dx][y] == '*') {
										arr[dx][y] = '.';
										arr[x][y] = 'v';
										break;
									}else if(arr[dx][y] == '#') {
										break;
									}
								}
							}
						}
						else if(n_d == 'L') {
							dy = y + udlr[2][1];
							if(arr[x][dy] == '.') {
								for(int m=1; m<=h-x; m++) {
									dy = y + udlr[2][1]*m;
									if(dy == 0) {
										y = y + udlr[2][1];
									}
									if(arr[x][dy] == '*') {
										arr[x][dy] = '.';
										arr[x][y] = '<';
										break;
									}else if(arr[x][dy] == '#') {
										break;
									}
								}
							}
						}
						else if(n_d == 'R') {
							dy = y + udlr[3][1];
							if(arr[x][dy] == '.') {
								for(int m=1; m<=h-x; m++) {
									dy = y + udlr[3][1]*m;
									if(dy == w-1) {
										y = y + udlr[3][1];
									}
									if(arr[x][dy] == '*') {
										arr[x][dy] = '.';
										arr[x][y] = '>';
										break;
									}else if(arr[x][dy] == '#') {
										break;
									}
								}
							}
						}
					}
					case ('U'):{
						dx = x + udlr[0][0];
						if(arr[dx][y] == '.') {
							n_d = 'U';
							x = dx;
							arr[x][y] = '^';
						}
						else if(arr[dx][y] == '-') {
							n_d = 'U';
							arr[x][y] = '^';
							break;
						}else if(arr[dx][y] == '*') {
							n_d = 'U';
							arr[dx][y] = '.';
							arr[x][y] = '^';
							break;
						}else if(arr[dx][y] == '#') {
							break;
						}
						
					}
					
					case ('D'):{
						dx = x + udlr[1][0];
						if(arr[dx][y] == '.') {
							n_d = 'D';
							x = dx;
							arr[x][y] = 'v';
						}
						else if(arr[dx][y] == '-') {
							n_d = 'D';
							arr[x][y] = 'v';
							break;
						}else if(arr[dx][y] == '*') {
							n_d = 'D';
							arr[dx][y] = '.';
							arr[x][y] = 'v';
							break;
						}else if(arr[dx][y] == '#') {
							break;
						}
					}
					case ('R'):{
						dy = y + udlr[2][1];
						if(arr[x][dy] == '.') {
							n_d = 'R';
							y = dy;
							arr[x][y] = '>';
						}
						else if(arr[dx][y] == '-') {
							n_d = 'R';
							arr[x][y] = '>';
							break;
						}else if(arr[dx][y] == '*') {
							n_d = 'R';
							arr[dx][y] = '.';
							arr[x][y] = '>';
							break;
						}else if(arr[dx][y] == '#') {
							break;
						}
					}
					case ('L'):{
						dy = y + udlr[3][1];
						if(arr[x][dy] == '.') {
							n_d = 'L';
							y = dy;
							arr[x][y] = '<';
						}
						else if(arr[dx][y] == '-') {
							n_d = 'L';
							arr[x][y] = '<';
							break;
						}else if(arr[dx][y] == '*') {
							n_d = 'L';
							arr[dx][y] = '.';
							arr[x][y] = '<';
							break;
						}else if(arr[dx][y] == '#') {
							break;
						}
					}
				}
			}
			print(h, w, arr);
			
		}
	}
	
	
	
//	public void recursive(char c) {
//		switch(c) {
//			case ('U'):{
//				
//			}
//			case ('D'):{
//				
//			}
//			case ('R'):{
//				
//			}
//			case ('L'):{
//				
//			}
//		}
//	}
	
	
	public static void print(int h, int w, char[][] arr) {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}
	
	public void print1(int N, char[] d) {
		for(int j=0; j<N; j++) {
			System.out.print(d[j]);
		}System.out.println();
	}

}
