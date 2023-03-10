package month02.date08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759_G5_암호만들기 {
	static int l;
	static int c;
	static String[] cases;
	static String[] keylist;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// 암호의 길이 L과, 암호의 갯수 C입력받음
		String[] lc = br.readLine().split(" ");
		l = Integer.parseInt(lc[0]);
		c = Integer.parseInt(lc[1]);
		
		// 암호를 저장할 배열
		cases = new String[l];
		
		// c개의 암호원소를 입력받아 저장
		keylist = br.readLine().split(" ");
		Arrays.sort(keylist);
		
		// 함수 시작
		com(0, 0);
		System.out.println(sb.toString());
	}
	private static void com(int cnt, int start) {
		if(cnt == l) {
			int bcd = 0;
			int aei = 0;
			for(int i = 0; i < cases.length; i++) {
				if("aeiou".contains(cases[i])) {
					aei += 1;
				} else {
					bcd += 1;
				}
			}
			if(aei>= 1 && bcd >=2) {
				for(int i = 0; i < cases.length; i++) {
					sb.append(cases[i]);
				}sb.append("\n");
			}
			return;
		}
		for(int i = start; i < c; i++) {
			cases[cnt] = keylist[i];
			com(cnt+1, i+1);
		}
	}
}


