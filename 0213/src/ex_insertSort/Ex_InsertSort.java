package ex_insertSort;

class Sort {
	
	public void insertionSort(int a[], int size) {
		int j, temp, t;
		
		for(int i = 1; i < size; i++) {
			temp = a[i];
			//a[j-1]>temp 내림차순할 때에는 부등호 방향만 바꾸기
			for(j = i; j>0 && (a[j-1]>temp); j--) {	//기존 배열의 내용을 계속 탐색중일 때
				a[j] = a[j-1];
			}
			a[j] = temp;//j가 0이거나 a[j-1] <= tmep (temp가 저장될 위치 확정)일 때 실행
			System.out.printf("\n삽입정렬 %d 단계 : ", i);
			for(t = 0; t < size; t++)
				System.out.printf("%3d", a[t]);
			}
			System.out.println();
	}
}

public class Ex_InsertSort {

	public static void main(String[] args) {
		int a[] = {69, 10, 2, 16, 8, 31, 22};
		int size = a.length;
		Sort S = new Sort();
		System.out.print("\n정렬할 원소 : ");
		for(int i = 0;i < a.length; i++) 
			System.out.print(a[i]+ " ");
		System.out.println();
		
		S.insertionSort(a, size);
	}

}
