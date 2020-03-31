package com.zx.ex;

import java.util.Arrays;

public class Duoshuyuansu2020313 {
	 public int majorityElement(int[] nums) {
		 //排序后大于一半的众数一定符合条件
		 Arrays.sort(nums);
	     return nums[nums.length/2];
	 }
}
