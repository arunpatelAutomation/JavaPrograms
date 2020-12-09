package Selenium;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "maDAM";
		 String t = "";
		 	for(int i = s.length()-1;i>=0;i--)
		{
			t = t+s.charAt(i);
			
		}
		System.out.println("Orignal String S:" + s);
		System.out.println("Reverse String T:" + t);
	
		if (s.equalsIgnoreCase(t))
		{
			System.out.println("it's same");
		}
		else
		{
			System.out.println("it's NOT same");
		}
		}
	
}

