package Selenium;

public class MinNumberArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int abc[][]= {{8,2,3},{4,5,6},{0,-1,-2}};
		
		int min = abc[0][0];
		
		for(int i=0;i<3;i++) {
			
			for(int j=0;j<3;j++) {
				System.out.println(" Array :" + abc[i][j]);
				
				if (abc[i][j] <min)
				{
					min=abc[i][j];
				}
			}
		}
		System.out.println("Miniumum Number in Array :" + min); */
		
		
		int a [] = { 1,2,3,0,-1 };
		int max = a[0];
		
		for (int i=0;i<5;i++) {
		if (a[i] > max)
		{
			max = a[i];
		}
		
		
		
		
	}
		System.out.println("Maximum Number in Array :" + max);
}
}
