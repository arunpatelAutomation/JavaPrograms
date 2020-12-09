package Selenium;

public class pyramid3 {

	public static void main(String[] args) {
		
		
		int k=3; 
		
		for(int i=1;i<4;i++)  
			//(outer for loop) this block will loop for 4 times
			{ //System.out.println( "outer loop started"); 
			for(int j=1;j<=i;j++) // inner loop 
				
				{ System.out.print( k); 
				System.out.print("\t"); 
				k=k+3; } 
		System.out.println( ""); 
		} 

		}
}

