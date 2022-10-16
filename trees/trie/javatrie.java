class Trie {
    //The entire trie starting with root node
    Node root = new Node();

    boolean contains(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children[currChar - 'A'] == null) {
                return false;
            }
            curr = curr.children[currChar - 'A'];
        }
        return curr.end;
    }

    void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children[currChar - 'A'] == null) {
                curr.children[currChar - 'A'] = new Node();
                curr.children[currChar - 'A'].parent = curr;
            }
            curr = curr.children[currChar - 'A'];
            curr.count++;
        }
        curr.end = true;
    }
    void delete(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if ((curr.count == 0) && (curr.parent != null)) {
                curr.children[currChar - 'A'] = null;
            }
            if (curr.children[currChar - 'A'] != null) {
                curr = curr.children[currChar - 'A'];
                curr.count--;
            } else { //Word no exist in trie
                return;
            }
        }
        curr.end = false;
    }
    int numberNames(String word) { //Find number of names from "A" to word
        int counter = 0;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.charAt(i) - 'A'; j++) {
                if (curr.children[j] != null) {
                    counter += curr.children[j].count;
                }
            }
            if (curr.end) {
                counter++;
            }
            if (curr.children[word.charAt(i) - 'A'] == null) {
                break;
            }
            curr = curr.children[word.charAt(i) - 'A'];
        }
        return counter;
    }
}

class Node {
    //Each individual node of the tree, contains whether its an end and count
    boolean end;
    int count;
    Node parent;
    Node[] children = new Node[26];
    Node() {
        this.end = false;
        this.count = 0;
    }
}