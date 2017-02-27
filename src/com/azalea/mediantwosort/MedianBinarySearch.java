package com.azalea.mediantwosort;

public class MedianBinarySearch implements IMedianOfTwoSortedArray {

	@Override
	public double findMedianSortedArrays(int[] left, int[] right) {

		int leftLen = left.length;
		int rightLen = right.length;

		int leftMax = leftLen - 1;
		int rightMax = rightLen - 1;

		if (leftLen == 0 && rightLen == 0) return -1;

		if (leftLen == 0) {
			if (((rightLen) & 1) == 0) {
				return (right[rightLen / 2] + right[rightLen / 2 - 1]) / 2F;
			} else {
				return right[rightLen / 2];
			}
		}

		if (rightLen == 0) {
			if (((leftLen) & 1) == 0) {
				return (left[leftLen / 2] + left[leftLen / 2 - 1]) / 2F;
			} else {
				return left[leftLen / 2];
			}
		}

		if (right[rightMax] < left[0]) {
			// 本身数组就有序
			// switch left and right , make it easy to use
			int[] tmp = left;
			left = right;
			right = tmp;

			int tmpMax = leftMax;
			leftMax = rightMax;
			rightMax = tmpMax;

			// switch numbers by ^ operator
			leftLen = leftLen ^ rightLen;
			rightLen = leftLen ^ rightLen;
			leftLen = leftLen ^ rightLen;
		}

		if (left[leftMax] <= right[0]) {

			// 本身数组就有序
			if (((leftLen + rightLen) & 1) == 0) {
				// even length
				if (leftLen > rightLen) {
					int mid = (leftLen + rightLen) >> 1;
					return (left[mid - 1] + left[mid]) / 2F;
				} else if (leftLen == rightLen) {
					return (left[leftMax] + right[0]) / 2F;
				} else {
					int mid = (leftLen + rightLen) >> 1;
					return (right[mid - leftLen] + right[mid - leftLen - 1]) / 2F;
				}

			} else {
				// odd length
				int mid = (leftLen + rightLen) >> 1;
				if (leftLen > rightLen) {
					return left[mid];
				} else {
					return right[mid - leftLen];
				}
			}
		}

		if (leftLen > rightLen) {
			// 本身数组就有序
			// switch left and right , make it easy to use
			int[] tmp = left;
			left = right;
			right = tmp;

			int tmpMax = leftMax;
			leftMax = rightMax;
			rightMax = tmpMax;

			// switch numbers by ^ operator
			leftLen = leftLen ^ rightLen;
			rightLen = leftLen ^ rightLen;
			leftLen = leftLen ^ rightLen;
		}

		int imin = 0, imax = leftLen;
		int halfLen = (leftLen + rightLen + 1) / 2;

		boolean isEven = (((leftLen + rightLen) & 1) == 0);

		while (imin <= imax) {

			int i = (imin + imax) / 2;
			int j = halfLen - i;

			if(i < leftLen && right[j-1]>left[i]){
				imin = i + 1;
				continue;
			}

			if (i > 0 && left[i - 1] > right[j]) {
				imax = i - 1;
				continue;
			}

			int leftMaxVal = 0;
			int rightMinVal = 0;

			if(i == 0){
				leftMaxVal = right[j-1];
			}else if(j == 0){
				leftMaxVal = left[j-1];
			}else {
				leftMaxVal = Math.max(left[i - 1], right[j - 1]);
			}

			if(!isEven){

				return leftMaxVal;

			}else {

				if(i == leftLen){
					rightMinVal = right[j];
				}else if(j == rightLen){
					rightMinVal = left[i];
				}else {
					rightMinVal = Math.min(left[i], right[j]);
				}

				return (leftMaxVal + rightMinVal) / 2F;
			}

		}

		return 0;
	}

	private void switchArray(int[] left, int[] right) {
		int[] tmp = left;
		left = right;
		right = tmp;
	}

}
