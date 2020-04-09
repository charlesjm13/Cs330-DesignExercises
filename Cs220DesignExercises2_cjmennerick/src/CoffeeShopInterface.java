
public interface CoffeeShopInterface {
	public int addCustomer(String name, String coffeePreference); //add a new customer to the database
	public void changePref(String name, String newPref); //changes the coffee preference of an existing customer
	public void swipe(int iD);	//charges the rewards card with a purchase
	public void lookup(String name); //returns the info about a customer given their name
	public void lookup(int iD);		//returns the name of a customer given their iD
	public void clear();		//clears the database
	public void removeCustomer(String name, int iD);	//removes a customer, requires Name and iD
	
	
	
	
}
