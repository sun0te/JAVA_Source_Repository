package ex_binarySearch;


public class Ex_BinarySearch {
	//이진 검색은 정렬된 데이터 사용할 것
	static int arr[] = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};
	static int cnt = 0;
	
	public static void main(String[] args) {
		System.out.println("1. 순환 흐름을 이용한 이진 탐색");
		System.out.println("결과 : " + binarySearch1(5, 0, arr.length-1));
		
		System.out.println("2. 반복을 이용한 이진 탐색");
		System.out.println("결과 : " + binarySearch2(5, 0, arr.length-1));
	}
	
	//재귀구조
	static int binarySearch1(int key, int low, int high) {
		/*
		if (low > high) {
	            return -1;
	    }

        int middle = (low + high) / 2;
        if (arr[middle] == key) {
            return middle;
        } else if (arr[middle] > key) {
            return binarySearch1(key, low, middle - 1);
        } else {
            return binarySearch1(key, middle + 1, high);
        }
        */
		int mid;
		if(low <= high) {
			Ex_BinarySearch.cnt++;
			mid = (low + high) / 2;
			
			if (key == arr[mid]) {	//탐색 성공
				System.out.println("검색 횟수 : "+ Ex_BinarySearch.cnt);
	            return mid;
	        } else if (key < arr[mid]) {
	            return binarySearch1(key, low, mid - 1);	//왼쪽 부분 탐색
	        } else {
	            return binarySearch1(key, mid + 1, high);	//오른쪽 부분 탐색
	        }
		}
		System.out.println("검색 횟수 : "+ Ex_BinarySearch.cnt);
		return -1;	//탐색 실패
	}
		
		
	
	//반복구조
	static int binarySearch2(int key, int low, int high) {
		int cnt = 0;
		while (low <= high) {
			cnt++;
            int mid = ((low + high) / 2);
            
            if (key == arr[mid]) {
            	System.out.println("검색 횟수 : " + cnt);
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
		System.out.println("검색 횟수 : " + cnt);
        return -1;	//탐색 실패
	}
	
}
