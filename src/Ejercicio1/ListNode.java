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

class arrays {

    public static ListNode mArray(ListNode[] list) {
        int k = list.length;

        for (int i = 1; i < k; i++) {
            while (true) {

                ListNode head = list[0];
                ListNode headn = list[i];

                if (headn == null) {
                    break;
                }

                if (head.val > headn.val) {
                    list[i] = headn.next;
                    headn.next = head;
                    list[0] = headn;
                } else {

                    while (head.next != null) {

                        if (head.next == null) {
                            list[i] = headn.next;
                            headn.next = null;
                            head.next = headn;
                            head.next.next = null;
                            break;
                        }

                        if (head.next.val > headn.val) {
                            list[i] = headn.next;
                            headn.next = head.next;
                            head.next = headn;
                            break;
                        }

                        head = head.next;

                    }
                }
            }
        }
        return list[0];
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = 3;
        ListNode l1[] = new ListNode[n];

        l1[0] = new ListNode(6);
        l1[0].next = new ListNode(10);
        l1[0].next.next = new ListNode(12);
        l1[0].next.next.next = new ListNode(20);

        l1[1] = new ListNode(11);
        l1[1].next = new ListNode(3);
        l1[1].next.next = new ListNode(5);
        l1[1].next.next.next = new ListNode(7);

        l1[2] = new ListNode(1);
        l1[2].next = new ListNode(15);
        l1[2].next.next = new ListNode(9);
        l1[2].next.next.next = new ListNode(4);

        ListNode head = mArray(l1);
        printList(head);

    }
}
