package com.azalea.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] nums, int taget) {

		Map<Integer, Integer> numMap = new HashMap<>();

		for (int i = 0, len = nums.length; i < len; ++i) {
			numMap.put(nums[i], i);
		}

		for (int i = 0, len = nums.length; i < len; ++i) {
			int needFind = taget - nums[i];
			Integer needIndex = numMap.get(needFind);
			if (needIndex == null) {
				continue;
			} else {
				if(i == needIndex.intValue()) continue;
				return new int[] { i, needIndex.intValue() };
			}
		}

		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(TwoSum.twoSum(new int[] { 3, 2,
				4 }, 6)));
	}
}
