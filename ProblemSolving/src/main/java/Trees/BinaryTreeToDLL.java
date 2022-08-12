package Trees;

/*Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. 
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
*/

public class BinaryTreeToDLL {

	public static void main(String[] args) {
		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);
		Node head = tree.bintree2list(tree.root);
		tree.printList(head);
	}

	Node root;

	Node bintree2listUtil(Node node) {
		if (node == null)
			return node;
		if (node.left != null) {
			Node left = bintree2listUtil(node.left);
			while (left.right != null) {
				left = left.right;
			}
			left.right = node;
			node.left = left;
		}
		if (node.right != null) {
			Node right = bintree2listUtil(node.right);
			while (right.left != null) {
				right = right.left;
			}
			right.left = node;
			node.right = right;
		}
		return node;
	}

	Node bintree2list(Node node) {
		if (node == null)
			return node;
		node = bintree2listUtil(node);
		while (node.left != null)
			node = node.left;
		return node;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree2 {
	Node root;
	Node head;
	static Node prev = null;

	void BinaryTree2DoubleLinkedList(Node root) {
		if (root == null)
			return;
		BinaryTree2DoubleLinkedList(root.left);
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		BinaryTree2DoubleLinkedList(root.right);
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
}