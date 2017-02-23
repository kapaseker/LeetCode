package com.azalea.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOneHashMap implements ITwoSumSolution {

	@Override
	public int[] twoSum(int[] nums, int target) {

		
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0, len = nums.length; i < len; ++i) {
			int targetNum = target - nums[i];
			if(numMap.containsKey(targetNum)){
				return new int[] { numMap.get(targetNum), i };
			}else{
				numMap.put(nums[i], i);
			}
		}

		return null;
	}

}
