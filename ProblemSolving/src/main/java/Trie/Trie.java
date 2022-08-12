package Trie;

public class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.isEndOfWord = true;
	}

	public void recursiveInsert(String word) {
		recursiveInsert(word, root, 0);
	}

	public void recursiveInsert(String word, TrieNode current, int index) {
		if (index == word.length()) {
			current.isEndOfWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		recursiveInsert(word, node, index + 1);
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null)
				return false;
			current = node;
		}
		return current.isEndOfWord;
	}

	public boolean recursiveSearch(String word) {
		return recursiveSearch(word, root, 0);
	}

	public boolean recursiveSearch(String word, TrieNode current, int index) {
		if (index == word.length())
			return current.isEndOfWord;
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null)
			return false;
		return recursiveSearch(word, node, index + 1);
	}

	public void delete(String word) {
		delete(word, root, 0);
	}

	public boolean delete(String word, TrieNode current, int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord)
				return false;
			current.isEndOfWord = false;
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null)
			return false;
		boolean shouldDeleteCurrentNode = delete(word, node, index + 1);
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}
}
