package Selenium;

public class ReverseEachWord {
	
	public static void main(String[] args) {
		
		String str = "my name is Arun";
		String[] sst = str.split(" ");
		String reverseWord="";
		
		
		for(String astr: sst) {
			
			reverseWord = reverseWord.trim() + " "+ reverseStringfun(astr);
			
		}
		
		System.out.println(reverseWord);
	}

	
	public static String reverseStringfun(String s) {
		
		StringBuffer sb = new StringBuffer(s);
		return sb.reverse().toString();
		
	}
	
}
