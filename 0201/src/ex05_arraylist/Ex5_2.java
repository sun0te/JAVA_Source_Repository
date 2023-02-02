package ex05_arraylist;

import java.util.Scanner;

public class Ex5_2 {

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		Sungjuk data;
		int menu;
		
		do {
			print_menu();
			System.out.println("\n 메뉴 선택 =>");
			menu = in.nextInt();
			
			if(menu == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
			switch (menu)
			{
			case 1:
				System.out.println();
				data = new Sungjuk();
				System.out.println("번호 입력 => ");
				data.setBunho(in.nextInt());
				System.out.println("이름 입력 => ");
				data.setIrum(in.next());
				System.out.println("점수 입력 => ");
				data.setJumsu(in.nextInt());
				arr.insertLastNode(data);
				break;
			case 2:
				arr.printList();
				break;
			case 3:
				System.out.println();
				data = new Sungjuk();
				System.out.print("검색할 번호 입력 => ");
				data.setBunho(in.nextInt());
				arr.searchNode(data);
				break;
			case 4:
				System.out.println();
				data = new Sungjuk();
				System.out.println("삭제할 번호를 입력 => ");
				data.setBunho(in.nextInt());
				arr.deleteNode(data);
				break;
			default:
				System.out.println("\n메뉴를 다시 입력하세요!\n");
				break;
			}
			
		} while(true);

	}

	static void print_menu() {
		System.out.println("\n*** 메뉴 ***\n");
		System.out.println("1. 데이터 입력\n");
		System.out.println("2. 데이터 출력\n");
		System.out.println("3. 데이터 검색\n");
		System.out.println("4. 데이터 삭제\n");
		System.out.println("5. 프로그램 종료\n");
	}
}

	class ArrayList {
		static int MAX = 10;
		static int cnt = 0;
		Sungjuk arr[];
		
		ArrayList() {
			this.arr = new Sungjuk[MAX];
		}
		
		
		public void insertLastNode(Sungjuk data) { //데이터 입력, 최대 10회
			/*
			if(this.cnt < MAX) {
				arr[cnt] = data;
				cnt++;
				System.out.println("삽입 성공 !!");
			} else {
				System.out.println("입력 횟수 10회를 초과했습니다.");
			}
			*/
			
			if(this.cnt == MAX) {
				System.out.println("\n 메모리 풀");
				return;
			}
			this.arr[this.cnt++] = data;
			System.out.println("\n 데이터삽입 성공");
			
		}
		
		public void printList() { //전체 데이터 출력, 데이터 없을 때 메시지
			/*
			if(cnt == 0) {
				System.out.println("입력한 정보가 없습니다. 데이터를 입력해주세요");
			} else {
				System.out.println("번호\t이름\t점수");
				System.out.println("---------------------");
				for(int i = 0; i < cnt; i++) {
					System.out.println(arr[i].getBunho() + "\t" + arr[i].getIrum() + "\t" + arr[i].getJumsu());
				}
			}
			*/
			
			if(this.arr.length == 0) {
				System.out.println("출력할 데이터 없음");
				return ;
			}
			System.out.println();
			System.out.println("번호\t이름\t점수");
			System.out.println("---------------------");
			for(int i = 0; i < this.cnt; i++) {
				System.out.println(this.arr[i].getBunho() + "\t" + this.arr[i].getIrum() + "\t" + this.arr[i].getJumsu());
			}
		}
		
		public void searchNode(Sungjuk data) {  //번호를 가지고 배열 내에서 동일한 번호를 가진 성적 객체 찾기, 출력양식			  
			/*
			  int search_bunho = data.getBunho();
			  for (int i = 0; i < cnt; i++) {
			    if (arr[i].getBunho() == search_bunho) {
			      System.out.println("번호\t이름\t점수");
			      System.out.println("---------------------");
			      System.out.println(arr[i].getBunho() + "\t" + arr[i].getIrum() + "\t" + arr[i].getJumsu());
			      
			    }//if
			  }//for //하다가 오류남
			  */
			
			  for(int i = 0; i < this.cnt; i++) {
				  if(data.getBunho() == this.arr[i].getBunho()) {
					  System.out.println();
					  System.out.println("번호\t이름\t점수");
				      System.out.println("---------------------");
				      System.out.printf("%3d, %3s, %4d \n", this.arr[i].getBunho() + "\t" + this.arr[i].getIrum() + "\t" + this.arr[i].getJumsu());
				  }
			  }
			  System.out.println("검색할 데이터가 없습니다.");
		}
		
		public void deleteNode(Sungjuk data) {  //삭제하면 이전 데이터 이동, cnt개수 1 감소
			for(int i = 0; i < this.cnt; i++) {
				if(data.getBunho() == this.arr[i].getBunho()) {
					for(int k = i; k < this.cnt -1; k++) {
						this.arr[k] = this.arr[k+1];
					}
					this.cnt--;  
					// 데이터의 접근 범위는 결국 이동된 인덱스 위치까지 줄어든다 
					// ex)4->3으로 이동하면 범위가 4에서 3으로 됨, 결국 이동후 범위가 끝
					System.out.println("\n삭제 성공!!\n");
					return;
				}
			}
			System.out.println("삭제할 데이터가 없음");
		}
		
	}

	class Sungjuk {
		private int bunho; //직접 접근 못 함
		private String irum;
		private int jumsu;
		
		//아래의 메소드를 통해 접근 가능 -> 접근자
		public int getBunho() {
			return bunho;
		}
		public void setBunho(int bunho) {
			this.bunho = bunho;
		}
		public String getIrum() {
			return irum;
		}
		public void setIrum(String irum) {
			this.irum = irum;
		}
		public int getJumsu() {
			return jumsu;
		}
		public void setJumsu(int jumsu) {
			this.jumsu = jumsu;
		}
		
	}

