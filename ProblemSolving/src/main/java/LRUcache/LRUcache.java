package LRUcache;

import java.util.HashMap;
import java.util.Map;

public class LRUcache {
	Map<Integer, Node> map;
	int capacity;
	int count;
	Node head;
	Node tail;

	LRUcache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		map = new HashMap<>();
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
	}

	private void addNode(Node node) {		  
		  node.next = head.next;
		  node.next.prev = node;
		  node.prev = head;
		  head.next = node;
	}

	private void deleteNode(Node node) {
        node.prev.next = node.next; 
        node.next.prev = node.prev; 
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addNode(node);
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addNode(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capacity) {
				count++;
				addNode(node);
			} else {
				map.remove(tail.prev.key);
				deleteNode(tail.prev);
				addNode(node);
			}
		}
	}

}
