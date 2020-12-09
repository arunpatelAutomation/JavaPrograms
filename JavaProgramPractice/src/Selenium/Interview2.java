package Selenium;

public class Interview2 {

	//Interview question : I/P - 24245673 O/P - BDBDeFgc
	public static void main(String[] args) {

	        String str=String.valueOf(24245673);
	        String opStr="";
	        for(int i=0;i<str.length();i++){
	            int ch=Integer.parseInt(String.valueOf(str.charAt(i)));
	            if(ch%2==1)
	                opStr= opStr+(char)(64+ch);
	            else
	                opStr= opStr+(char)(96+ch);
	        }
	        System.out.println(opStr);
	    }

	}


