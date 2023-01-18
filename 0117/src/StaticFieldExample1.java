
public class StaticFieldExample1 {

	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);
		
		int grandTotal = Accumulator.getGrandTotal();	//정적 메소드 호출

		
		System.out.println("obj1.total = " + obj1.total);
		//System.out.println("obj1.grandTotal = " + obj1.grandTotal);
		System.out.println("obj2.total = " + obj2.total);
		//System.out.println("obj2.grandTotal = " + obj2.grandTotal);
		System.out.println("총계 = " + grandTotal);
		
	}

}
