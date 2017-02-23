package com.azalea.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumByHashMap implements ITwoSumSolution{
	
	@Override
	public int[] twoSum(int[] nums, int taget) {

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
}
