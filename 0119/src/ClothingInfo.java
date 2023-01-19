
public class ClothingInfo {
	
	public enum Season {
		SPRINT, SUMMER, FALL, WINTER
	}
	
	String code; 
	String name; 
	String material; 
	Season season; 
	 
	ClothingInfo(String code, String name, String material, Season season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
	}

}
