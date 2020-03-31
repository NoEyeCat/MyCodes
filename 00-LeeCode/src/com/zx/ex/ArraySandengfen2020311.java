package com.zx.ex;

public class ArraySandengfen2020311 {
	/**
	 * 题目：给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
	 * @param A
	 * @return
	 */
	public boolean canThreePartsEqualSum(int[] A) {
		//检验数组个数和总和，个数小于三或总和除以三有余返回false
		int len=A.length;
		int sum=0;
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
		}
		if (len<3||sum%3!=0||sum==0) {
			return false;
		}
		//设置断点数和每段断点的总和，每当一个断点总和达到总数的三分之一就记录一个断点
		int sum2=0;
		int breaknum=0;
		for (int i = 0; i < A.length; i++) {
			sum2+=A[i];
				if (sum2==sum/3) {
				breaknum++;
				sum2=0;
			}
		}
		//如果断点大于等于三说明三等分，不等于三则不能三等分，大于三考虑总和为0的情况
		if (breaknum>=3) {
			return true;
		}else {
			return false;
		}
    }
}
