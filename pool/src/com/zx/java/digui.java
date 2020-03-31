package com.zx.java;

public class digui {
	public static void hanoi(int n,String A,String B,String C)
	{
		if(1==n)
			System.out.println("第一个盘子从"+A+"移到"+C);
		else
		{
			hanoi(n-1,A,C,B);
			
			System.out.println("第"+n+"盘子从"+A+"移到"+C);
			
			hanoi(n-1,B,A,C);
		}
	}
	public static void main(String[] args) {
		
        hanoi( 3, "A", "B", "C");
	}
}
