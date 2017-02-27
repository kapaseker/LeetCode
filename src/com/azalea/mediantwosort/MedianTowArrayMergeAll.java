package com.azalea.mediantwosort;

/**
 * 当前的算法使用归并，先合并两个有序数组为一个，然后再计算中位数
 * @author Panoo
 *
 */
public class MedianTowArrayMergeAll implements IMedianOfTwoSortedArray {

	@Override
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int indexLeft = 0;
		int indexRight = 0;
		int allIndex = 0;

		int leftLen = nums1.length;
		int rightLen = nums2.length;

		int allLen = leftLen + rightLen;

		int[] allArray = new int[allLen];

		while (indexLeft < nums1.length && indexRight < nums2.length) {
			if (nums1[indexLeft] < nums2[indexRight]) {
				allArray[allIndex++] = nums1[indexLeft++];
			} else {
				allArray[allIndex++] = nums2[indexRight++];
			}
		}

		if (indexLeft == nums1.length) {
			while (indexRight < nums2.length) {
				allArray[allIndex++] = nums2[indexRight++];
			}
		}

		if (indexRight == nums2.length) {
			while (indexLeft < nums1.length) {
				allArray[allIndex++] = nums1[indexLeft++];
			}
		}

		return ((allLen & 1) == 0) ? (allArray[allLen / 2] + allArray[allLen / 2 - 1]) / 2F : allArray[allLen / 2];
	}

}
