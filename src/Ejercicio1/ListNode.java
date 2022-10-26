package Ejercicio1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public static ListNode merge(ListNode[] lists) {
        int k = lists.length;
        ListNode head = null;
        ListNode ptr = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            if (curr.next != null) {
                queue.add(curr.next);
            }
            if (head == null) {
                head = curr;
                ptr = head;
            } else {
                ptr.next = curr;
                ptr = ptr.next;
            }
        }
        return head;
    }
    public static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, k;
        n = sc.nextInt();
        m = sc.nextInt();
        ListNode[] l1 = new ListNode[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                k = sc.nextInt();
                int temp = k; 
                l1[i] = new ListNode(k);
                l1[i].next = new ListNode();
            }
        }
        ListNode head = merge(l1);
        printList(head);

    }
}
