package com.azalea.mergeKList ;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 利用归并算法进行合并
 * @author Panoo
 *
 */
public class MergeKListMergeSolution implements IMergeKListSolution{
	
	@Override
	public ListNode mergeKLists(ListNode[] lists) {

		int listSize = lists.length;
		
		Queue<ListNode> nodeQueue = new ArrayDeque<>();

		for (int i = 0; i < listSize ; i+=2) {
			if (i + 1 < listSize) {
				if(lists[i] == null&& lists[i + 1] == null){
					continue;
				}
				nodeQueue.add(mergeTwoListNode(lists[i], lists[i + 1]));
			} else {
				if(lists[i] != null){
					nodeQueue.add(lists[i]);
				}
			}
		}
		
		int size = nodeQueue.size();
		
		while(size > 1){
			
			for (int i = 0; i < size; i += 2) {
				if(i + 1 < size){
					nodeQueue.add(mergeTwoListNode(nodeQueue.poll(),nodeQueue.poll()));
				}else{
					nodeQueue.add(nodeQueue.poll());
				}
			}
			
			size = (((size & 1) == 0) ? (size / 2) : (size / 2 + 1));
//			size = nodeQueue.size();
		}

		return nodeQueue.poll();
	}

	public ListNode mergeTwoListNode(ListNode left, ListNode right) {
		
		List<ListNode> mergedList = new LinkedList<>();
		
		while (left != null && right != null) {
			if (less(left, right)) {
				mergedList.add(left);
				left = left.next;
			} else {
				mergedList.add(right);
				right = right.next;
			}
		}
		
		if(left == null){
			while(right != null){
				mergedList.add(right);
				right = right.next;
			}
		}
		
		if(right == null){
			while(left != null){
				mergedList.add(left);
				left = left.next;
			}
		}
		
		ListNode lastNode = null;
		
		for(ListNode node : mergedList){
			if(lastNode == null){
				lastNode = node;
				continue;
			}
			lastNode.next = node;
			lastNode = node;
		}
		
		if(mergedList.size() == 0){
			return null;
		}
		
		ListNode mergedHead = mergedList.get(0);
		
		mergedList.clear();
		
		return mergedHead;
	}

	public boolean less(ListNode left, ListNode right) {

		if (left.val < right.val) {
			return true;
		} else {
			return false;
		}
	}
}
