package com.azalea.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.azalea.twosum.TwoSumByHashMap;
import com.azalea.twosum.TwoSumOneHashMap;

public class TwoSumTest {
	
	/**
	 * 测试简单的数组
	 */
	@Test
	public void testSimple() {
		assertArrayEquals(new int[] { 1, 2 },new TwoSumByHashMap().twoSum(new int[] { 3, 2, 4 }, 6));
		
		assertArrayEquals(new int[] { 1, 2 },new TwoSumOneHashMap().twoSum(new int[] { 3, 2, 4 }, 6));
	}
	
	/**
	 * 测试复杂的数组
	 */
	@Test
	public void testComplex(){

		assertArrayEquals(new int[] { 3, 10 }, new TwoSumByHashMap().twoSum(new int[] { 7, 10,
				6, 5, 11, 45, 67, 43, 33, 44, 4, 74 }, 9));
		
		assertArrayEquals(new int[] { 3, 10 }, new TwoSumOneHashMap().twoSum(new int[] { 7, 10,
				6, 5, 11, 45, 67, 43, 33, 44, 4, 74 }, 9));
	}
}
