import java.util.HashMap;

public class StarbucksRewards implements CoffeeShopInterface{
	
	public HashMap<String, Integer> cusId;
	public HashMap<Integer, Integer> cusInfo;
	public HashMap<Integer, String>	cusPref;
	public int couponNum;
	
	public StarbucksRewards() {
		cusId = new HashMap<String, Integer>();
		cusInfo = new HashMap<Integer, Integer>();
		cusPref = new HashMap<Integer, String>();
		couponNum = 0;
		
	}
	
	public int addCustomer(String name, String coffeePreference) {
		if(cusId.containsKey(name)) {
			System.out.println("This customer already has an account. Their iD number is: " + Integer.toString(cusId.get(name)));
			return cusId.get(name);
		}
		else {
			cusId.put(name, cusId.size()+1);
			cusPref.put(cusId.get(name), coffeePreference);
			cusInfo.put(cusId.get(name), 0);
			return cusId.get(name);
		}
			
	}
	public void changePref(String name, String newPref) {
		cusPref.replace(cusId.get(name), newPref);
	}
	
	public void swipe(int iD) {
		cusInfo.replace(iD, cusInfo.get(iD)+1);
		if(cusInfo.get(iD) >= 3) {
			cusInfo.replace(iD, 0);
			System.out.println("This customer has received a coupon. Their coupon number is: " + Integer.toString(couponNum));
			couponNum++;
		}
	}
	
	
	public String lookup(String name) {
		if(cusId.containsKey(name)) {
			return "This customer has a rewards account. Their iD number is: " + Integer.toString(cusId.get(name));
		}
		else {
			return "This customer does not have a rewards account.";
		}
	}
	
	public String lookup(int iD) {
		if(cusInfo.containsKey(iD) && cusPref.containsKey(iD)) {
			return "This customer currently has " + Integer.toString(cusInfo.get(iD)) + " purchases towards their next reward. " + "Their coffee preference is: " + cusPref.get(iD);
		}
		else {
			return "This iD number is not in our system.";
		}
	}
	public void clear() {
		cusId = new HashMap<String, Integer>();
		cusInfo = new HashMap<Integer, Integer>();
		cusPref = new HashMap<Integer, String>();

	}
	public void removeCustomer(String name, int iD) {
		cusId.remove(name);
		cusInfo.remove(iD);
		cusPref.remove(iD);
	}
	public int returnNumCus() {
		return cusId.size();
	}
	public int getPurchases(int iD) {
		return cusInfo.get(iD);
	}
	public int getID(String name) {
		return cusId.get(name);
	}
	public String getPref(int iD) {
		return cusPref.get(iD);
	}
}
