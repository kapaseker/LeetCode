package com.azalea.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.azalea.twosum.TwoSum;

public class TwoSumTest {
	
	/**
	 * ���Լ򵥵�����
	 */
	@Test
	public void testSimple() {
		assertArrayEquals(new int[] { 1, 2 }, TwoSum.twoSum(new int[] { 3, 2, 4 }, 6));
	}
	
	/**
	 * ���Ը��ӵ�����
	 */
	@Test
	public void testComplex(){

		assertArrayEquals(new int[] { 3, 10 }, TwoSum.twoSum(new int[] { 7, 10,
				6, 5, 11, 45, 67, 43, 33, 44, 4, 74 }, 9));
	}
}