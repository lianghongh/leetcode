class Trie {
    private TrieNode root;

    class TrieNode
    {
        public int count;
        public boolean isEnd;
        public TrieNode[] next;
        public TrieNode()
        {
            count=1;
            isEnd=false;
            next=new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null||word.length()==0)
            return;
        TrieNode p=root;
        for(int i=0;i<word.length();i++)
        {
            int k = word.charAt(i) - 'a';
            if(p.next[k]!=null)
                p.next[k].count++;
            else
                p.next[k]=new TrieNode();
            p = p.next[k];
        }
        p.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null||word.length()==0)
            return false;
        TrieNode p=root;
        for(int i=0;i<word.length();i++)
        {
            int k = word.charAt(i) - 'a';
            if(p.next[k]==null)
                return false;
            p = p.next[k];
        }
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        if(word==null||word.length()==0)
            return false;
        TrieNode p=root;
        for(int i=0;i<word.length();i++)
        {
            int k = word.charAt(i) - 'a';
            if(p.next[k]==null)
                return false;
            p = p.next[k];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */