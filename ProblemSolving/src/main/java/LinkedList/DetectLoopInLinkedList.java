package LinkedList;

/**
 * 
 * Solution 3: Floyd’s Cycle-Finding Algorithm Approach: This is the fastest
 * method and has been described below:
 * 
 * Traverse linked list using two pointers. Move one pointer(slow_p) by one and
 * another pointer(fast_p) by two. If these pointers meet at the same node then
 * there is a loop. If pointers do not meet then linked list doesn’t have a
 * loop.
 */

/**
 * The algorithm is to start two pointers, slow and fast from head of linked list. We move slow one node at a time and fast two nodes at a time. If there is a loop, then they will definitely meet. This approach works because of the following facts.

1) When slow pointer enters the loop, the fast pointer must be inside the loop. Let fast pointer be distance k from slow.

2) Now if consider movements of slow and fast pointers, we can notice that distance between them (from slow to fast) increase by one after every iteration. After one iteration (of slow = next of slow and fast = next of next of fast), distance between slow and fast becomes k+1, after two iterations, k+2, and so on. When distance becomes n, they meet because they are moving in a cycle of length n.

For example, we can see in below diagram, initial distance is 2. After one iteration, distance becomes 3, after 2 iterations, it becomes 4. After 3 iterations, it becomes 5 which is distance 0. And they meet.
 */

/**
 * We can conclude below from the above diagram
 * 
 * Distance traveled by fast pointer = 2 * (Distance traveled by slow pointer)
 * 
 * (m + n*x + k) = 2*(m + n*y + k)
 * 
 * Note that before meeting the point shown above, fast was moving at twice
 * speed.
 * 
 * x --> Number of complete cyclic rounds made by fast pointer before they meet
 * first time
 * 
 * y --> Number of complete cyclic rounds made by slow pointer before they meet
 * first time From the above equation, we can conclude below
 * 
 * m + k = (x-2y)*n
 * 
 * Which means m+k is a multiple of n. So if we start moving both pointers again
 * at the same speed such that one pointer (say slow) begins from the head node
 * of the linked list and other pointers (say fast) begins from the meeting
 * point. When the slow pointer reaches the beginning of the loop (has made m
 * steps), the fast pointer would have made also moved m steps as they are now
 * moving the same pace. Since m+k is a multiple of n and fast starts from k,
 * they would meet at the beginning. Can they meet before also? No, because the
 * slow pointer enters the cycle first time after m steps.
 */

public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;
		System.out.println(detectLoop(head));
	}

	public static String detectLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println(slow.val + " " + fast.val);
				removeLoop(slow, head);
				return "Loop Exists";
			}
		}
		return "No Loop";
	}

	public static void removeLoop(ListNode slow, ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != slow) {
			curr = curr.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
	}

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
