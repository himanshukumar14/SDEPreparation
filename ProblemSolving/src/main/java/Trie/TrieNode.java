package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	Map<Character, TrieNode> children;
	boolean isEndOfWord;
	
	TrieNode() {
		this.isEndOfWord = false;
		this.children = new HashMap<>();
	}
}
