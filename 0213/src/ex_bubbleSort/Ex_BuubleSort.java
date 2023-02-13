package ex_bubbleSort;

class Sort {
	public void bubbleSort(int a[]) {
		int i, j, flag; //flag : 버블정렬 데이터의 교환이 없을 경우(모두 정렬된 상태) 끝냄
		for(i = 0; i < a.length; i++) {
			System.out.printf("\n버블정렬 %d단계 : ", i);
			flag = 0;
			for(j = 0; j < a.length -1 -i; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = 1;
				}
			}
//			System.out.print(a[i] + " ");
			
			for(j = 0; j < a.length;j ++)
				System.out.printf("%3d", a[j]);
			if(flag == 0)
				break;
		}
		
	}
}

public class Ex_BuubleSort {

	public static void main(String[] args) {
		int a[] = {69, 10, 2, 16, 8, 31, 22};
		Sort S = new Sort();
		System.out.print("\n 정렬할 원소 : ");
		for(int i = 0;i < a.length; i++) 
			System.out.print(a[i]+ " ");
		System.out.println();
		System.out.print("\n 정렬된 원소");
		S.bubbleSort(a);
	}

}
