import java.util.Arrays;
import java.util.HashMap;

public class StemFormalDiets implements DietDatabase<String, String> {
	
	public HashMap<String, String> dietMap;
	
	public StemFormalDiets() {
		dietMap = new HashMap<String, String>();
	}
	
	
	public void add(String name, String diet) {
		if (!dietMap.containsKey(name)) {
			dietMap.put(name, diet);
		}
	}
	
	public void clear() {
		this.dietMap.clear();
	}
	
	public void change(String name, String newDiet) {
		if (this.dietMap.containsKey(name)) {
			this.dietMap.replace(name, newDiet);
		}
		else {
			this.dietMap.put(name, newDiet);
		}
	}
	
	public String[] returnAll(String diet) {
		int count = 0;
		for(HashMap.Entry<String, String> value: this.dietMap.entrySet())
			if(value.getValue() == diet)
				count++;
		
		String[] names = new String[count];
		int spot = 0;
		
		for(HashMap.Entry<String, String> value: this.dietMap.entrySet())
			if(value.getValue() == diet) {
				names[spot] = value.getKey();
				spot ++;
			}
		Arrays.sort(names);
		return names;
				
	}
	
	
	public String getDiet(String name) {
		return this.dietMap.get(name);
	}
	
	public void remove(String name) {
		this.dietMap.remove(name);
	}
	
	public int size() {
		return this.dietMap.size();
	}
	
	public boolean contains(String name) {
		return this.dietMap.containsKey(name);
	}
	
	public static void main(String args[]) {
		DietDatabase<String, String> test = new StemFormalDiets();
		test.add("James", "Vegetarian");
		test.add("John", "Vegan");
		test.add("Courtney", "Vegan");
		test.add("Blane", "Vegan");
		test.add("Cynthia", "Vegetarian");
		test.add("Michelle", "Pescatarian");
		test.add("Bruce", "Vegetarian");
		test.add("Harley", "Non-Vegetarian");
		test.add("Christie", "Pescatarian");
		System.out.print(Arrays.toString(test.returnAll("Vegan")));
	}
}
