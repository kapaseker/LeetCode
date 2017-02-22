package com.azalea.test;

import org.junit.Test;

import com.azalea.mergeKList.ListNode;
import com.azalea.mergeKList.MergeKList;

public class MergeKListTest {

	@Test
	public void test() {
		// [-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]

		ListNode leftNode = generateList(new int[] { -10, -9, -9, -3, -1, -1,
				0 });

		ListNode rightNode = generateList(new int[] { -5 });

		ListNode midNode = generateList(new int[] { 4 });

		ListNode node4 = generateList(new int[] { -8 });

		ListNode node5 = null;
		ListNode node6 = generateList(new int[] { -9, -6, -5, -4, -2, 2, 3 });
		ListNode node7 = generateList(new int[] { -3, -3, -2, -1, 0 });

		printList(new MergeKList().mergeKLists(new ListNode[] { leftNode,
				rightNode, midNode, node4, node5, node6, node7 }));
	}

	public ListNode generateList(int[] array) {

		ListNode nodeHead = null;
		ListNode lastNode = null;
		for (int i : array) {
			if (nodeHead == null) {
				lastNode = new ListNode(i);
				nodeHead = lastNode;
				continue;
			}

			lastNode.next = new ListNode(i);
			lastNode = lastNode.next;
		}
		return nodeHead;
	}

	public void printList(ListNode node) {

		ListNode nodeHead = node;
		System.out.print("[");
		if (nodeHead != null) {
			System.out.print(nodeHead.val + "");
			nodeHead = nodeHead.next;
		}
		while (nodeHead != null) {
			System.out.print("," + nodeHead.val);
			nodeHead = nodeHead.next;
		}
		System.out.println("]");
	}

}
