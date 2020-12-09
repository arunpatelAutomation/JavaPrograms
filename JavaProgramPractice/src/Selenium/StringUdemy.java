package Selenium;

public class StringUdemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Payment $100 paid
		String s = "Payment $100 paid";
		System.out.println(s.charAt(8));

		String s1 = "Payments $100 paid";
		System.out.println(s1.indexOf("$"));
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.substring(9, 18));
		System.out.println(s1.substring(9));
	}

}
