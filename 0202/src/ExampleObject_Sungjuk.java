
public class ExampleObject_Sungjuk {

	public static void main(String[] args) {
		Sungjuk obj1 = new Sungjuk();
//		Sungjuk obj2 = new Sungjuk();
		
		obj1.input();
		obj1.process();
//		obj2.input();
//		obj2.process();
		
		Sungjuk obj2 = (Sungjuk) obj1.clone(); //클론
		
		if(obj1.equals(obj2))
			System.out.println("같음");
		else
			System.out.println("다름");
		
		System.out.println(obj1);
		System.out.println(obj2);
	}

}
