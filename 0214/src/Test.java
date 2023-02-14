
public class Test {
	static int cnt = 0;
	
	static void ni() {
		cnt -= 1;
	}

	static void go() {
		ni();
		ni();
		cnt++;
	}

	public static void main(String[] args) {
		cnt++;
		for(int i =0; i < 3; i++){
			ni();
			cnt++;
			go();
		}
		System.out.println(cnt);
	} 
}
