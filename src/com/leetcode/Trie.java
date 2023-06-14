package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/6/14
 */
public class Trie {

    private TrieNode<Character> head;

    public Trie() {
        head = new TrieNode<Character>(null);
    }

    public void insert(String word) {
        char[] str = word.toCharArray();
        TrieNode cur = head;
        for (int i = 0; i < str.length; i++) {
            if (cur.nexts[str[i] - 'a'] == null) {
                cur.nexts[str[i] - 'a'] = new TrieNode<Character>(str[i]);
            }
            cur.pass++;
            cur = cur.nexts[str[i] - 'a'];
        }
        cur.ends++;
        cur.pass++;
    }

    public boolean search(String word) {
        char[] str = word.toCharArray();
        TrieNode cur = head;
        for (char c : str) {
            if (cur.nexts[c - 'a'] == null) {
                return false;
            }
            cur = cur.nexts[c - 'a'];
        }
        return cur.ends > 0 ? true : false;
    }

    public boolean delete(String word) {
        if (!search(word)) {
            return false;
        }
        char[] str = word.toCharArray();
        TrieNode cur = head;
        for (char c : str) {

            if (--cur.pass == 0) {
                cur.nexts[c-'a'] = null;
                return true;
            }
            cur = cur.nexts[c - 'a'];
        }
        cur.ends--;
        return true;
    }

    public boolean startsWith(String prefix) {
        char[] str = prefix.toCharArray();
        TrieNode cur = head;
        for (char c : str) {
            if (cur.nexts[c - 'a'] == null) {
                return false;
            }
            cur = cur.nexts[c - 'a'];
        }
        return cur.pass > 0 ? true : false;

    }

    class TrieNode<E> {
        public int ends;
        public int pass;

        public E e;
        public TrieNode<E>[] nexts;

        public TrieNode(E e) {
            this.e = e;
            this.nexts = new TrieNode[26];
        }
    }
}

class t01 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] str = new String[]{"abc","a",""};
        for (String s : str) {
            trie.insert(s);
            System.out.println(trie);
        }

        System.out.println(trie.startsWith("a"));
        System.out.println(trie.search("a"));
        System.out.println(trie.delete("a"));


    }
}

