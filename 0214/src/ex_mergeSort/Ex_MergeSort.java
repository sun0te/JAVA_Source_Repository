package ex_mergeSort;

class Sort {
	//임시 기억장치가 필요하기 때문에 배열 하나 더 입력
	public int sorted[] = new int [8];
	
	public void merge(int a[], int begin, int middle, int end) {
		int size = a.length;
		int i, j, k, t;
		i = begin;
		j = middle + 1;
		k = begin;
		
		// 앞부분과 뒷부분을 비교해서 작은 값을 새로운 배열에 삽입
		while(i <= middle && j <= end) {
			if(a[i] <= a[j]) {
				sorted[k] = a[i++];	//왼쪽
			} else {
				sorted[k] = a[j++];	//오른쪽
			}
			k++;
		}
		//i 가 오른쪽 j가 왼쪽
		// 왼쪽이 먼저 머지가 끝났을 때, 앞부분의 값이 남은 경우
		if(i > middle) {	//오른쪽 데이터 처리
			for(t = j; t <= end; t++, k++) {
				sorted[k] = a[t];
			}
		// 오른쪽이 먼저 머지가 끝낫을 때, 뒷부분의 값이 남은 경우
		} else {	
			for(t = i; t <= middle; t++, k++) {	//왼쪽 데이터 처리
				sorted[k] = a[t];
			}
		}
		
		// 단계별 정렬 결과 저장, 배열 sorted에 정렬된 값들을 a 배열에 복사
		for(t = begin; t <= end; t++) {
			a[t] = sorted[t];
			System.out.printf("\n 병합 정렬 >> ");
			for(t = 0; t < size; t++)
				System.out.printf("%3d ", a[t]);
		}
		
	}
	
	public void mergeSort(int a[], int begin,  int end) {
		int middle;
		if(begin < end) {
			middle = (begin + end) / 2;
			mergeSort(a, begin, middle);	//분할된 영역의 왼쪽
			mergeSort(a, middle + 1, end);	//분할된 영역의 오른쪽
			merge(a, begin, middle, end);
		}
	}
	
}

public class Ex_MergeSort {

	public static void main(String[] args) {
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		Sort S = new Sort();
		System.out.print("정렬할 원소 : ");
		for(int i = 0;i < a.length; i++) 
			System.out.print(a[i]+ " ");
		System.out.println();
		
		S.mergeSort(a, 0, size - 1);
	}

}
