package Selenium;

public class ArrayAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4};
		int sum = 0;
		
		for (int i = 0;i<a.length;i++)
			
		{
			System.out.println(a[i]);
			//sum=sum+a[i];
			if (a[i] == 3)
			{
				System.out.println("we found "+ a[i] + " at position # "+ i);
				break;
			}
		}
		//System.out.println("Sum is:"+sum);
		
	}

}
