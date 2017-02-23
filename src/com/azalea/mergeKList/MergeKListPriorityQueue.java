package com.azalea.mergeKList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 利用优先队内进行合并
 * @author Panoo
 *
 */
public class MergeKListPriorityQueue implements IMergeKListSolution{

	@Override
	public ListNode mergeKLists(ListNode[] lists) {
		
		Comparator<ListNode> nodeComparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode left, ListNode right) {

				if (left.val < right.val) {
					return -1;
				} else if (left.val > right.val) { return 1; }

				return 0;
			}
		};
		
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(nodeComparator);
		
		for(ListNode item : lists){
			if(item != null){
				priorityQueue.offer(item);
			}
		}
		
		List<ListNode> nodeArrayList = new LinkedList<>();
		
		while (true) {
			ListNode curNode = priorityQueue.poll();
			if(curNode == null){
				break;
			}else{
				nodeArrayList.add(curNode);
				curNode = curNode.next;
				if(curNode != null){
					priorityQueue.offer(curNode);
				}
			}
		}
		
		ListNode lastItem = null;
		
		for(ListNode item : nodeArrayList){
			if(lastItem == null){
				lastItem = item;
				continue;
			}
			lastItem.next = item;
			lastItem = item;
		}
		
		if(lastItem != null){
			lastItem.next = null;
		}
		
		if(nodeArrayList.size() == 0) return null;
		
		return nodeArrayList.get(0);
	}

}


