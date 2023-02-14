package ex_SelectionSort;

class Sort {
	public void selectionSort(int a[]) {
		int i, j;
		for(i = 0; i < a.length -1; i++) {
			for(j = i+1; j < a.length; j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
//			System.out.print(a[i] + " ");
			System.out.printf("\n선택정렬 %d단계 : ", i+1);
			for(j = 0; j < a.length;j ++)
				System.out.printf("%3d", a[j]);
			
		}
		
	}
}

public class Ex_SelectSort {

	public static void main(String[] args) {
		int a[] = {69, 10, 2, 16, 8, 31, 22};
		Sort S = new Sort();
		System.out.print("\n 정렬할 원소 : ");
		for(int i = 0;i < a.length; i++) 
			System.out.print(a[i]+ " ");
		System.out.println();
		System.out.print("\n정렬된 원소 : ");
		S.selectionSort(a);
	}

}
