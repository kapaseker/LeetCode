package com.azalea.mediantwosort;

/**
 * 同样采用归并的算法，但是，并不全部进行合并，而是合并到中间就停止即可
 * @author Panoo
 *
 */
public class MedianTowArrayMergeMid implements IMedianOfTwoSortedArray{

	@Override
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int indexLeft = 0;
		int indexRight = 0;
		int allIndex = 0;

		int leftLen = nums1.length;
		int rightLen = nums2.length;

		int allLen = leftLen + rightLen;

		int[] allArray = new int[allLen];
		
		boolean isEven = ((allLen & 1) == 0);
		
		if(isEven){
			
			int leftFindIndex = allLen / 2 - 1;
			int rightFindIndex = allLen / 2;
			
			boolean isLeftFind = false;
			boolean isRightFind = false;
			
			int leftNum = 0;
			int rightNum = 0;
			
			while (indexLeft < nums1.length && indexRight < nums2.length) {

				isRightFind = (rightFindIndex == allIndex);
				isLeftFind = (leftFindIndex == allIndex);

				if (nums1[indexLeft] < nums2[indexRight]) {
					allArray[allIndex++] = nums1[indexLeft++];
				} else {
					allArray[allIndex++] = nums2[indexRight++];
				}
				if (isLeftFind) {
					leftNum = allArray[leftFindIndex];
				}
				if (isRightFind) { return (leftNum + allArray[rightFindIndex]) / 2F; }
			}

			if (indexLeft == nums1.length) {
				while (indexRight < nums2.length) {
					isRightFind = (rightFindIndex == allIndex);
					isLeftFind = (leftFindIndex == allIndex);
					allArray[allIndex++] = nums2[indexRight++];
					if (isLeftFind) {
						leftNum = allArray[leftFindIndex];
					}
					if (isRightFind) { return (leftNum + allArray[rightFindIndex]) / 2F; }
				}
			}

			if (indexRight == nums2.length) {
				while (indexLeft < nums1.length) {
					isRightFind = (rightFindIndex == allIndex);
					isLeftFind = (leftFindIndex == allIndex);
					allArray[allIndex++] = nums1[indexLeft++];
					if (isLeftFind) {
						leftNum = allArray[leftFindIndex];
					}
					if (isRightFind) { return (leftNum + allArray[rightFindIndex]) / 2F; }
				}
			}
			
		}else{
			
			int midIndex = allLen / 2;
		
			while (indexLeft < nums1.length && indexRight < nums2.length) {
				boolean isFind = (midIndex == allIndex);
				if (nums1[indexLeft] < nums2[indexRight]) {
					allArray[allIndex++] = nums1[indexLeft++];
				} else {
					allArray[allIndex++] = nums2[indexRight++];
				}
				if(isFind){
					return allArray[midIndex];
				}
			}

			if (indexLeft == nums1.length) {
				while (indexRight < nums2.length) {
					boolean isFind = (midIndex == allIndex);
					allArray[allIndex++] = nums2[indexRight++];
					if(isFind){
						return allArray[midIndex];
					}
				}
			}

			if (indexRight == nums2.length) {
				while (indexLeft < nums1.length) {
					boolean isFind = (midIndex == allIndex);
					allArray[allIndex++] = nums1[indexLeft++];
					if (isFind) { return allArray[midIndex]; }
				}
			}
		}

		return 0;
	}

}
