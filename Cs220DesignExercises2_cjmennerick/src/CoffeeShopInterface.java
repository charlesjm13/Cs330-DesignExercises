
public interface CoffeeShopInterface {
	public int addCustomer(String name, String coffeePreference); //add a new customer to the database
	public void changePref(String name, String newPref); //changes the coffee preference of an existing customer
	public void swipe(int iD);	//charges the rewards card with a purchase
	public String lookup(String name); //returns the info about a customer given their name
	public String lookup(int iD);		//returns the name of a customer given their iD
	public void clear();		//clears the database
	public void removeCustomer(String name, int iD);	//removes a customer, requires Name and iD
	public int returnNumCus(); //returns the number of customers	
	public int getID(String name); // return id of customer given name
	public String getPref(int iD); //return drink preference given iD
	public int getPurchases(int iD); //return the number of current purchases going towards a reward
	
}
