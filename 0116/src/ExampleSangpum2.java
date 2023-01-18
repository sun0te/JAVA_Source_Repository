
public class ExampleSangpum2 {

	static int MAX = 100;
	static Sangpum obj[] = new Sangpum[MAX];
	
	public static void main(String[] args) {
		
		int cnt = input_sungpum(obj);
		output_sangpum(obj, cnt);
	}
	
	static int input_sungpum(Sangpum obj[]) {
		int cnt = 0;
		
		for(int i =0; i < MAX; i++) {
			obj[i] = new Sangpum();
			if(obj[i].inputGoods())
				break;
			obj[i].pricess_sangpum();
			cnt++;
			System.out.println();
		}	
		return cnt;
	}
	
	static void output_sangpum(Sangpum obj[], int cnt) {
		System.out.println("\n\t\t *** 상품 정보 ***");
		System.out.println("===============================================================");
		System.out.println("상품코드  상품명 수량   단가   금액");
		System.out.println("===============================================================");
		for (int i = 0; i < cnt; i++) {
			obj[i].outputGoods();
		}
		System.out.println("===============================================================");
	}
	
}
