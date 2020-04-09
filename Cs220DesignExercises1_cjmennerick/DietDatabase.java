
public interface DietDatabase<T1, T2> {
	
	public void add(T1 name, T2 diet);	//adds a person and their diet to the database
	
	public void clear();	//clears the database
	
	public void change(T1 name, T2 newDiet);	//changes the diet entry for a person
	
	public String[] returnAll(T2 diet);		// returns all people of a certain diet
	
	public String getDiet(T1 name);		//returns the diet of a given person
	
	public void remove(T1 name);		//removes a person from the database
	
	public int size();				//returns how many people are in the database
	
	public boolean contains(T1 name);	//returns whether a person is already in the database
	
}
