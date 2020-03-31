package com.zx.ex;

public class SumOfTwoNum2020314 {

	public int[] twoSum(int[] nums, int target) {
		//遍历数组依次相加，当有符合要求的数值时，返回索引值i，j
		 for (int i = 0; i < nums.length; i++) {
			 for (int j = i+1; j < nums.length; j++) {
				 if (nums[i]+nums[j]==target) {	
					 return new int[] {i,j};
				}
			}
		}
		//抛出数值异常
		throw new IllegalArgumentException("No two sum solution");
	}    
}
