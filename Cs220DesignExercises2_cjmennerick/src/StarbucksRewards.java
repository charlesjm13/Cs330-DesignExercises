import java.util.HashMap;

public class StarbucksRewards implements CoffeeShopInterface{
	
	public HashMap<String, Integer> cusId;
	public HashMap<Integer, Integer> cusInfo;
	public HashMap<Integer, String>	cusPref;
	public int cusNumber;
	public int couponNum;
	
	public StarbucksRewards() {
		cusId = new HashMap<String, Integer>();
		cusInfo = new HashMap<Integer, Integer>();
		cusPref = new HashMap<Integer, String>();
		cusNumber = 0;
		couponNum = 0;
		
	}
	
	public int addCustomer(String name, String coffeePreference) {
		if(cusId.containsKey(name)) {
			System.out.println("This customer already has an account. Their iD number is: " + Integer.toString(cusId.get(name)));
			return cusId.get(name);
		}
		else {
			cusId.put(name, cusNumber);
			cusPref.put(cusNumber, coffeePreference);
			cusInfo.put(cusNumber, 0);
			cusNumber++;
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
	
	public void lookup(String name) {
		if(cusId.containsKey(name)) {
			System.out.println("This customer has a rewards account. Their iD number is: " + Integer.toString(cusId.get(name)));
		}
		else {
			System.out.println("This customer does not have a rewards account.");
		}
	}
	
	public void lookup(int iD) {
		if(cusInfo.containsKey(iD) && cusPref.containsKey(iD)) {
			System.out.println("This customer currently has " + Integer.toString(cusInfo.get(iD)) + " purchases towards their next reward. " + "Their coffee preference is: " + cusPref.get(iD));
			;
		}
		else {
			System.out.println("This iD number is not in our system.");
		}
	}
	public void clear() {
		cusId = new HashMap<String, Integer>();
		cusInfo = new HashMap<Integer, Integer>();
		cusPref = new HashMap<Integer, String>();
		cusNumber = 0;
	}
	public void removeCustomer(String name, int iD) {
		cusId.remove(name);
		cusInfo.remove(iD);
		cusPref.remove(iD);
	}
}
