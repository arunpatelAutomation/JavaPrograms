package Selenium;

public class StringExample {

	/*public static void main (String[] args)
	{
	StringBuilder sb=new StringBuilder("abcd");
	String y=sb.charAt(3)+sb.substring(0,3);
	System.out.println(y);
	String z=sb.charAt(2)+sb.substring(0,2)+sb.substring(2,3);
	System.out.println(z);
	
	StringBuilder sb1=new StringBuilder("cat");
	String ya=sb1.charAt(2)+sb1.substring(0,2);
	System.out.println(ya);
	}

	} */
	
	
	
	    public static void main(String[] args)
	    {
	        //Creating string objects using literals
	 
	        String s1 = "abc";
	 
	        String s2 = "abc";
	 
	        System.out.println(s1 == s2);        //Output : true
	 
	        //Creating string objects using new operator
	 
	        String s3 = new String("abc");
	 
	        String s4 = new String("abc");
	 
	        System.out.println(s3 == s4);        //Output : false
	    }
	}
	//When you create a string object using string literal, JVM first checks the content of to be created object. 
//If there exist an object in the pool with the same content, then it returns the reference of that object.
//It doesn’t create new object. If the content is different from the existing objects then only it creates new object.”
//In simple words, there can not be two string objects with same content in the string constant pool. 
//But, there can be two string objects with the same content in the heap memory.


